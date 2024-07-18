package components.layout

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private const val MINIMAL_SCALE_FACTOR = 0.95F
private const val ANIMATION_DURATION = 200

@Composable
fun ClickableScaleColumn(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    var selected by remember { mutableStateOf(false) }

    val sizeScale by animateFloatAsState(
        targetValue = if (selected) MINIMAL_SCALE_FACTOR else 1f,
        animationSpec = tween(durationMillis = ANIMATION_DURATION),
        label = "Scale Effect",
    )

    CenteredColumn(
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 10.dp)
            .pointerInput(Unit) {
                while (true) {
                    awaitPointerEventScope {
                        awaitFirstDown(false)
                        selected = true
                        waitForUpOrCancellation()
                        selected = false
                    }
                }
            }
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick,
            )
            .scale(sizeScale)
            .then(modifier),
        content = content,
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewClickableScaleColumn() {
    ClickableScaleColumn(onClick = {}) {
        ItemsList(text = "Preview some content", onClick = {})
    }
}