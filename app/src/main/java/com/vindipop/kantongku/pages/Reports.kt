package com.vindipop.kantongku.pages

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.vindipop.kantongku.R
import com.vindipop.kantongku.components.ReportPage
import com.vindipop.kantongku.models.Recurrence
import com.vindipop.kantongku.ui.theme.TopAppBarBackground
import com.vindipop.kantongku.viewmodels.ReportsViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun Reports(vm: ReportsViewModel = viewModel()) {
  val uiState = vm.uiState.collectAsState().value

  val recurrences = listOf(
    Recurrence.Weekly,
    Recurrence.Monthly,
    Recurrence.Yearly
  )

  Scaffold(
    topBar = {
      MediumTopAppBar(
        title = { Text("Reports") },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
          containerColor = TopAppBarBackground
        ),
        actions = {
          IconButton(onClick = vm::openRecurrenceMenu) {
            Icon(
              painterResource(id = R.drawable.ic_today),
              contentDescription = "Change recurrence"
            )
          }
          DropdownMenu(
            expanded = uiState.recurrenceMenuOpened,
            onDismissRequest = vm::closeRecurrenceMenu
          ) {
            recurrences.forEach { recurrence ->
              DropdownMenuItem(text = { Text(recurrence.name) }, onClick = {
                vm.setRecurrence(recurrence)
                vm.closeRecurrenceMenu()
              })
            }
          }
        }
      )
    },
    content = { innerPadding ->
      val numOfPages = when (uiState.recurrence) {
        Recurrence.Weekly -> 53
        Recurrence.Monthly -> 12
        Recurrence.Yearly -> 1
        else -> 53
      }
      HorizontalPager(count = numOfPages, reverseLayout = true) { page ->
        ReportPage(innerPadding, page, uiState.recurrence)
      }
    }
  )
}