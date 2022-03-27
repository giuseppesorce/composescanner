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


    fun handleEvent(pairingEvent: ScannerEvents) {
        when (pairingEvent) {
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
