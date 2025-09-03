package com.fabrik.design.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fabrik.design.theme.Theme
import com.fabrik.design.theme.spacers

@Composable
fun TextFieldHelperText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelSmall,
        modifier = modifier.padding(top = MaterialTheme.spacers.xs)
    )
}

@Preview(showBackground = true)
@Composable
internal fun TextFieldHelperTextPreview() {
    Theme {
        TextFieldHelperText(text = "TextField helper text")
    }
}
