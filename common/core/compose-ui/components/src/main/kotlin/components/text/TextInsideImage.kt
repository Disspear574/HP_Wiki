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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.disspear574.components.R

private const val cornerRadius = 20f

@Composable
fun TextInsideImage(
    image: String? = null,
    text: String,
) {
    val accentColor = MaterialTheme.colorScheme.primaryContainer

    Box(
        contentAlignment = Alignment.BottomCenter,
    ) {
        AsyncImage(
            model = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            placeholder = painterResource(id = R.drawable.preview_image),
            modifier = Modifier
                .fillMaxWidth(),
        )
        Text(
            text = text,
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier
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


@Preview
@Composable
private fun PreviewTextInsideImage() {
    TextInsideImage(text = "Some test text")
}