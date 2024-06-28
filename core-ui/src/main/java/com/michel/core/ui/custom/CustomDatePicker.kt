package com.michel.core.ui.custom

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.michel.core.ui.R
import com.michel.core.ui.theme.TodoAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDatePicker(
    modifier: Modifier = Modifier,
    datePickerState: DatePickerState,
    onConfirm: (Long) -> Unit,
    onDismiss: () -> Unit
){
    DatePickerDialog(
        onDismissRequest = {
            onDismiss()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirm(
                        datePickerState.selectedDateMillis ?: datePickerState.displayedMonthMillis
                    )
                }
            ) {
                Text(
                    text = stringResource(id = R.string.acceptUpperCase),
                    color = TodoAppTheme.color.blue,
                    style = TodoAppTheme.typography.button
                )
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismiss()
                }
            ) {
                Text(
                    text = stringResource(id = R.string.cancelUpperCase),
                    color = TodoAppTheme.color.blue,
                    style = TodoAppTheme.typography.button
                )
            }
        },
        colors = DatePickerDefaults.colors(
            containerColor = TodoAppTheme.color.backSecondary
        ),
        modifier = modifier
    ) {
        DatePicker(
            state = datePickerState,
            colors = DatePickerDefaults.colors(
                todayContentColor = TodoAppTheme.color.primary,
                selectedDayContentColor = TodoAppTheme.color.elevated,
                selectedDayContainerColor = TodoAppTheme.color.blue,
                todayDateBorderColor = Color.Transparent,
                dayContentColor = TodoAppTheme.color.primary,
                titleContentColor = TodoAppTheme.color.primary,
                headlineContentColor = TodoAppTheme.color.primary,
                weekdayContentColor = TodoAppTheme.color.tertiary,
                navigationContentColor = TodoAppTheme.color.primary,
                yearContentColor = TodoAppTheme.color.primary,
                selectedYearContentColor = TodoAppTheme.color.elevated,
                selectedYearContainerColor = TodoAppTheme.color.blue,
                disabledSelectedYearContainerColor = TodoAppTheme.color.red
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
private fun CustomDatePickerPreview() {
    val date = 1718919593456
    val datePickerState = rememberDatePickerState(date)

    TodoAppTheme{
        CustomDatePicker(
          datePickerState = datePickerState,
          onConfirm = { },
          onDismiss = { }
        )
    }
}