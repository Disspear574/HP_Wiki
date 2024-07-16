package components.layout

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import components.modiifers.coloredShadow

@Composable
fun ItemsList(
    image: String,
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    ClickableScaleColumn(
        onClick = onClick,
        modifier = modifier,
    ) {
        AsyncImage(
            model = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .padding(10.dp)
                    .coloredShadow(Color.Black)
                    .clip(RoundedCornerShape(14.dp)),
        )
        Text(text, textAlign = TextAlign.Center)
    }
}
