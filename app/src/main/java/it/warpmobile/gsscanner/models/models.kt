package it.warpmobile.gsscanner.models

/**
 * @author Giuseppe Sorce
 */
data class ScannerState(
    var openScan: Boolean = false,
    var code: String = ""
)

sealed class ScannerEvents {
    object CloseScanner : ScannerEvents()
    object OpenScanner : ScannerEvents()
    data class SetCode(var code: String) : ScannerEvents()
}