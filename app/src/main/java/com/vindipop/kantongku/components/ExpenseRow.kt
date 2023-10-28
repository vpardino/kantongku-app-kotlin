package com.vindipop.kantongku.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vindipop.kantongku.models.Expense
import com.vindipop.kantongku.ui.theme.LabelSecondary
import com.vindipop.kantongku.ui.theme.Typography
import java.text.DecimalFormat
import java.time.format.DateTimeFormatter
import java.text.NumberFormat
import java.util.*

@Composable
fun ExpenseRow(expense: Expense, modifier: Modifier = Modifier) {
  Column(modifier = modifier) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      Text(
        expense.note ?: expense.category!!.name,
        style = Typography.headlineMedium,
        color = LabelSecondary
      )
      val currencyFormat = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
      val formattedAmount = currencyFormat.format(expense.amount)
      Text(
        formattedAmount,
        style = Typography.headlineMedium
      )
    }
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 6.dp),
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      CategoryBadge(category = expense.category!!)
      Text(
        expense.date.format(DateTimeFormatter.ofPattern("HH:mm")),
        style = Typography.bodyMedium,
        color = LabelSecondary
      )
    }
  }
}