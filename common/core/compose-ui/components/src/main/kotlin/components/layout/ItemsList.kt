package components.layout

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import components.image.CustomImage
import components.modiifers.coloredShadow

private const val ASPECT_RATIO = 9f / 14f

@Composable
fun ItemsList(
    text: String,
    modifier: Modifier = Modifier,
    image: String? = null,
    onClick: () -> Unit,
) {
    ClickableScaleColumn(
        onClick = onClick,
        modifier = modifier,
    ) {
        CustomImage(
            imageUrl = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(ASPECT_RATIO)
                .coloredShadow(Color.Black)
                .padding(10.dp)
                .clip(RoundedCornerShape(14.dp)),
        )
        Text(text, textAlign = TextAlign.Center)
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewItemsList() {
    ItemsList(text = "Some Test Text", onClick = {})
}
