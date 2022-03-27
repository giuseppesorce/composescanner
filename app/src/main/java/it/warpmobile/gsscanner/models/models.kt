package it.warpmobile.gsscanner.models

/**
 * @author Giuseppe Sorce
 */
data class ScannerState(
    var openScan: Boolean = false
)

sealed class ScannerEvents {
    object CloseScanner : ScannerEvents()
    object OpenScanner : ScannerEvents()
}