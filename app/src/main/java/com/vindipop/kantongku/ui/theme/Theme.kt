package com.vindipop.kantongku.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColorScheme(
  primary = Primary,
  background = Surface,
  surface = Surface,
  error = Destructive,
  onPrimary = TextPrimary,
  onSecondary = TextPrimary,
  onBackground = TextPrimary,
  onSurface = TextPrimary,
  onError = TextPrimary,

  /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

private val LightColorPalette = lightColorScheme(
  primary = Primary,
  background = Surface,
  surface = Surface,
  error = Destructive,
  onPrimary = TextPrimary,
  onSecondary = TextPrimary,
  onBackground = TextPrimary,
  onSurface = TextPrimary,
  onError = TextPrimary,
)

@Composable
fun KantongKuTheme(
  content: @Composable () -> Unit
) {
  val colors = LightColorPalette

  MaterialTheme(
    colorScheme = colors,
    typography = Typography,
    shapes = Shapes,
    content = content
  )
}