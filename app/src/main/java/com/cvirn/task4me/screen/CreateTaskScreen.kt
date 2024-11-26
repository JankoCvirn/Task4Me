package com.cvirn.task4me.screen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cvirn.task4me.R
import com.cvirn.task4me.components.createtask.EnterTextField
import com.cvirn.task4me.ui.theme.Task4Me
import com.cvirn.task4me.ui.values.LocalPaddingValues
import com.cvirn.task4me.viewmodel.TaskViewModel
import db.Task
import org.koin.androidx.compose.koinViewModel

@Composable
fun CreateTaskScreen(onNavigateBack: () -> Boolean) {
    val taskViewModel: TaskViewModel = koinViewModel()
    var inputText by remember { mutableStateOf("") }

    CreateTaskContent(
        inputText = inputText,
        onTextChange = { inputText = it },
        onSubmit = { taskName ->
            taskViewModel.addNewTask(Task(id = 100L, name = taskName))
            onNavigateBack()
        }
    )
}

@Composable
fun CreateTaskContent(
    inputText: String,
    onTextChange: (String) -> Unit,
    onSubmit: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EnterTextField(
            text = inputText,
            onTextChange = onTextChange,
            placeholder = stringResource(R.string.hint_create_task)
        )

        Spacer(modifier = Modifier.height(LocalPaddingValues.current.large))

        Button(onClick = { onSubmit(inputText) }) {
            Text(text = stringResource(R.string.action_create))
        }
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(
    uiMode = UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
@Composable
fun PreviewCreateTaskScreen() {
    Task4Me  {
        CreateTaskContent(inputText = "Demo",{},{})
    }
}

