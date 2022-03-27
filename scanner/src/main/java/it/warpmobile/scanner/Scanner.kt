package it.warpmobile.scanner

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.ViewGroup
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.core.content.ContextCompat
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean

/**
 * @author Giuseppe Sorce
 */
@Composable
fun Scanner(closeScanListener: () -> Unit, barCodeListener: (barCode: String) -> Unit) {

    var activeFlash by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .background(Color.Black)) {


        val (preview, flashButton, closeButton) = createRefs()
        val executor = remember(context) { ContextCompat.getMainExecutor(context) }
        val imageCapture: MutableState<ImageCapture?> = remember { mutableStateOf(null) }

      MLCameraView(
            barCodeListener,
            modifier = Modifier.constrainAs(preview) {
                linkTo(top = parent.top, bottom = parent.bottom)
                linkTo(start = parent.start, end = parent.end)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }, // Occupy the max size in the Compose UI tree
            imageCapture = imageCapture,
            context = context,
            executor = executor,
           activeFlash = activeFlash
        )

        Image(
            painter = if(activeFlash) painterResource(id = R.drawable.ic_torch_on) else  painterResource(id = R.drawable.ic_torch),
            contentDescription = null,
            modifier = Modifier
                .clickable {
                    activeFlash = !activeFlash
                }
                .height(dimSize(R.dimen.torchdimen))
                .width(dimSize(R.dimen.torchdimen))
                .constrainAs(flashButton) {
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom, 20.dp)
                }

        )

        Image(
            painter = painterResource(id =R.drawable.close),
            contentDescription = null,
            modifier = Modifier.clickable {
                closeScanListener()
            }
                .height(dimSize(R.dimen.closedimen))
                .width(dimSize(R.dimen.closedimen))
                .constrainAs(closeButton) {
                    end.linkTo(parent.end, 20.dp)
                    top.linkTo(parent.top, 10.dp)
                }
        )
    }
}

private var camera: Camera? = null
private var imageAnalyzer: ImageAnalysis? = null
private var cameraExecutor: ExecutorService = Executors.newSingleThreadExecutor()
private var processingBarcode = AtomicBoolean(false)

@Composable
fun MLCameraView(
    barCodeListener: (barCode: String) -> Unit, modifier: Modifier,
    imageCapture: MutableState<ImageCapture?>,
    executor: Executor,
    context: Context,
    activeFlash:Boolean
) {
    val previewCameraView = remember { PreviewView(context) }
    val cameraProviderFuture =
        remember(context) { ProcessCameraProvider.getInstance(context) }
    val cameraProvider = remember(cameraProviderFuture) { cameraProviderFuture.get() }
    val lifecycleOwner = LocalLifecycleOwner.current

    // this customview create a rectangle over qrcode image
    var overlay = BarcodeOverlay(context)

    AndroidView(
        modifier = modifier,
        factory = {
            cameraProviderFuture.addListener(
                {
                    val cameraSelector = CameraSelector.Builder()
                        .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                        .build()
                    // ImageAnalysis
                    imageAnalyzer = ImageAnalysis.Builder()
                        .setBackpressureStrategy(ImageAnalysis.STRATEGY_BLOCK_PRODUCER)
//                        .setTargetAspectRatio(screenAspectRatio)
                        .build()
                        .also {
                            it.setAnalyzer(cameraExecutor,
                                BarcodeAnalyzer(overlay) { barcode ->
                                    if (processingBarcode.compareAndSet(false, false)) {
                                        //   Log.i("network", "baerc ode "+barcode)
                                        barCodeListener(barcode)
                                    }
                                })
                        }
                    imageCapture.value = ImageCapture.Builder().build()
                    cameraProvider.unbindAll()
                    val prev = Preview.Builder().build().also {
                        it.setSurfaceProvider(previewCameraView.surfaceProvider)
                    }

                 camera=   cameraProvider.bindToLifecycle(
                        lifecycleOwner,
                        cameraSelector as CameraSelector,
                        prev,
                        imageAnalyzer

                    )
                }, executor
            )
            previewCameraView
        }

    )
    camera?.cameraControl?.enableTorch(activeFlash)
    AndroidView(
        factory = { overlay }
    ) { view ->
        view.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }
}


class BarcodeAnalyzer(val overlay: BarcodeOverlay, val listener: (barcode: String) -> Unit) :
    ImageAnalysis.Analyzer {
    private var isBusy = AtomicBoolean(false)
    @SuppressLint("UnsafeExperimentalUsageError", "UnsafeOptInUsageError")
    override fun analyze(image: ImageProxy) {
        if (isBusy.compareAndSet(false, true)) {
            val visionImage =
                InputImage.fromMediaImage(image.image!!, image.imageInfo.rotationDegrees)
            BarcodeScanning.getClient().process(visionImage)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        task.result?.let { barcodes ->
                            overlay.update(visionImage.mediaImage, barcodes)
                            for (barcode in barcodes) {
                                listener(barcode.rawValue ?: "")
                            }
                        }
                    } else {
                        Log.e("scanner", "failed to scan image: ${task.exception?.message}")
                    }
                    image.close()
                    isBusy.set(false)
                }
        } else {
            image.close()
        }
    }
}

@Composable
fun dimSize(dimen:Int) =with(LocalDensity.current) { dimensionResource(dimen) }