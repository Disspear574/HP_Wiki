package theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val hpColorScheme =
    darkColorScheme(
        primary = primaryColor,
        secondary = secondaryColor,
        tertiary = tertiaryColor,
        errorContainer = errorColor,
        background = backgroundColor,
        primaryContainer = backgroundColor,
        surface = backgroundColor,
    )

@Composable
fun HPTheme(
    content:
        @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = hpColorScheme,
        content = content,
    )
}
