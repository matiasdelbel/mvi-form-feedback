package com.fabrik.design.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fabrik.design.theme.Theme

@Composable
fun TextFieldLabel(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
internal fun TextFieldPreview() {
    Theme {
        TextFieldLabel(text = "TextField label")
    }
}
