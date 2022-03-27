package it.warpmobile.scanner

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.rememberPermissionState

/**
 * @author Giuseppe Sorce
 */

@ExperimentalFoundationApi
@ExperimentalPermissionsApi
@Composable
fun BuildCameraUI(closeScanListener: () ->Unit, barCodeListener: (barCode: String) -> Unit) {
    val context = LocalContext.current
    val permissionState = rememberPermissionState(
        Manifest.permission.CAMERA
    )
    CameraScannerStart(closeScanListener, barCodeListener,  permissionState, true) {
        //open settings screen to get permissions
        context.startActivity(
            Intent(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.parse("package:${context.packageName}")
            )
        )
    }
}

@ExperimentalFoundationApi
@ExperimentalPermissionsApi
@Composable
fun CameraScannerStart(
    closeScanListener: () -> Unit,
    barCodeListener: (barCode: String) -> Unit,
    permissionState: PermissionState,
    launcheNow: Boolean = false,
    openSettings: () -> Unit
) {

    //if user doesn't give persissions for two time
    var countPermission by remember { mutableStateOf(1) }
    when {
        permissionState.hasPermission -> {
            Scanner(closeScanListener, barCodeListener)
        }
        !permissionState.permissionRequested -> {
            PermissionExplainContent(
                modifier = Modifier.fillMaxSize(),
            ) {
                countPermission++
                permissionState.launchPermissionRequest()
            }
            if (launcheNow) {
                LaunchedEffect(key1 = permissionState.hasPermission) {
                    permissionState.launchPermissionRequest()
                }
            }
        }
        else -> {
            if (countPermission == 1) {
                PermissionExplainContent(modifier = Modifier.fillMaxSize()) {
                    countPermission++
                    permissionState.launchPermissionRequest()
                }

            } else {
                PermissionDeniedContent(
                    modifier = Modifier.fillMaxSize(),
                    handleLaunchSettings = {
                        openSettings()
                    }
                )
            }
        }
    }
}

