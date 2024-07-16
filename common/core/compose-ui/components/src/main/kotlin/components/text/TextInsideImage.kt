package components.text

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

private val cornerRadius = 20f

@Composable
fun TextInsideImage(
    image: String,
    text: String,
) {
    val accentColor = MaterialTheme.colorScheme.primaryContainer

    Box(
        contentAlignment = Alignment.BottomCenter,
    ) {
        AsyncImage(
            model = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier =
                Modifier
                    .fillMaxWidth(),
        )
        Text(
            text = text,
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
            modifier =
                Modifier
                    .width(250.dp)
                    .padding(bottom = 20.dp)
                    .drawBehind {
                        drawRoundRect(
                            accentColor.copy(alpha = 0.9f),
                            cornerRadius = CornerRadius(cornerRadius, cornerRadius),
                        )
                    },
        )
    }
}
