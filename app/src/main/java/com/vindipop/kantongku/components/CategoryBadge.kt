package com.vindipop.kantongku.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vindipop.kantongku.models.Category
import com.vindipop.kantongku.ui.theme.Shapes
import com.vindipop.kantongku.ui.theme.Typography
import com.vindipop.kantongku.ui.theme.LabelSecondary

val softGreen = Color(150, 200, 150)

@Composable
fun CategoryBadge(category: Category, modifier: Modifier = Modifier) {
  Surface(
    shape = Shapes.large,
    color = category.color.copy(alpha = 0.25f),
    modifier = modifier,
  ) {
    Text(
      category.name,
      color = softGreen,
      style = Typography.bodySmall,
      modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
    )
  }
}