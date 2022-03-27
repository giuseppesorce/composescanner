package it.warpmobile.gsscanner

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import it.warpmobile.gsscanner.models.ScannerEvents
import it.warpmobile.scanner.BuildCameraUI

/**
 * @author Giuseppe Sorce
 */

@ExperimentalFoundationApi
@ExperimentalPermissionsApi
@Composable
fun MainScan() {

    val viewModel: ScannerViewModel = viewModel()
    var scannerState = viewModel.uiState.collectAsState().value

    Box(modifier = Modifier.fillMaxSize()) {
        if(scannerState.openScan){
            BuildCameraUI (closeScanListener = {
                viewModel.handleEvent(ScannerEvents.CloseScanner)
            }){ barcode ->
                Log.i("scanner", "Barcodde " + barcode)
            }
        }else{
            Button(onClick = { viewModel.handleEvent(ScannerEvents.OpenScanner)}, modifier = Modifier.align(
                Alignment.Center)) {

                Text(text = stringResource(id = R.string.open_scanner))
            }
        }
    }
}