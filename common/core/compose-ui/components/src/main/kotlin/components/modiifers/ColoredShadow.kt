package components.modiifers

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp

fun Modifier.coloredShadow(color: Color) =
    drawBehind {
        val shadowColor = color.copy(alpha = 0.4f).toArgb()
        val transparentColor = color.copy(alpha = 0f).toArgb()
        val offsetX = 0.dp
        val offsetY = 0.dp
        val cornerRadius = 0.dp
        drawIntoCanvas {
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            frameworkPaint.color = transparentColor
            frameworkPaint.setShadowLayer(
                30.dp.toPx(),
                offsetX.toPx(),
                offsetY.toPx(),
                shadowColor,
            )
            it.drawRoundRect(
                0f,
                0f,
                this.size.width,
                this.size.height,
                cornerRadius.toPx(),
                cornerRadius.toPx(),
                paint,
            )
        }
    }
