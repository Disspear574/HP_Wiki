package components.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CenteredColumn(
    modifier: Modifier = Modifier,
    topPadding: Dp = 0.dp,
    vertical: Arrangement.Vertical = Arrangement.Center,
    content:
        @Composable
        (ColumnScope.() -> Unit),
) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(top = topPadding)
                .then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = vertical,
        content = content,
    )
}
