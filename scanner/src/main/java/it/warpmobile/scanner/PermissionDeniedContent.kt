package it.warpmobile.scanner

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


/**
 * @author Giuseppe Sorce
 */
@Composable
fun PermissionDeniedContent(
    modifier: Modifier = Modifier,
    handleLaunchSettings: () -> Unit
) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.permission_message),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            modifier = Modifier,
            onClick = { handleLaunchSettings() }
        ) {
            Text(
                text = stringResource(id = R.string.launch_settings)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_PermissionDeniedContent() {
    PermissionDeniedContent(modifier = Modifier.fillMaxWidth()) { }

}