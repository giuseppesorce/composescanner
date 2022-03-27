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
fun PermissionExplainContent(modifier: Modifier = Modifier, requestPermission: () -> Unit) {
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.permission_explainer_message),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                requestPermission()
            }
        ) {
            Text(stringResource(id = R.string.permission_explainer_action))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_PermissionExplainer() {
    PermissionExplainContent(modifier = Modifier.fillMaxWidth()) { }

}