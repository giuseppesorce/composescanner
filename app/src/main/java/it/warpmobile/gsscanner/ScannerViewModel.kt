package it.warpmobile.gsscanner

import androidx.lifecycle.ViewModel
import it.warpmobile.gsscanner.models.ScannerEvents
import it.warpmobile.gsscanner.models.ScannerState
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * @author Giuseppe Sorce
 */
class ScannerViewModel : ViewModel() {

    val uiState = MutableStateFlow(ScannerState())


    fun handleEvent(scanEvent: ScannerEvents) {
        when (scanEvent) {
            is ScannerEvents.SetCode-> {
                if(!scanEvent.code.isNullOrEmpty()){
                    uiState.value = uiState.value.copy(
                        code = scanEvent.code
                    )
                }

            }
            is ScannerEvents.CloseScanner-> {

                uiState.value = uiState.value.copy(
                    openScan = false
                )

            }
            is ScannerEvents.OpenScanner -> {
                uiState.value = uiState.value.copy(
                    openScan = true
                )
            }
        }

    }
}
