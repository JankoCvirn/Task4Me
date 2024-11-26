package com.cvirn.task4me.screen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.cvirn.task4me.components.button.Task4meFloatingAction
import com.cvirn.task4me.components.tasklist.TaskCard
import com.cvirn.task4me.ui.theme.Task4Me
import com.cvirn.task4me.ui.values.LocalPaddingValues
import com.cvirn.task4me.viewmodel.HomeViewModel
import db.Task
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(onNavigateToCreate: () -> Unit, onNavigateToUpdate: (Task?) -> Unit) {
    val homeViewModel: HomeViewModel = koinViewModel()
    val taskList by homeViewModel.allTasksFlow.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        homeViewModel.loadTaskList()
    }
    HomeScreenContent(
        taskList = taskList,
        onNavigateToCreate = onNavigateToCreate,
        onNavigateToUpdate = onNavigateToUpdate
    )
}

@Composable
fun HomeScreenContent(
    taskList: List<Task>,
    onNavigateToCreate: () -> Unit,
    onNavigateToUpdate: (Task?) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.padding(LocalPaddingValues.current.small),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(taskList) {
                TaskCard(it, onClick = { onNavigateToUpdate(it) })
            }
        }
        Task4meFloatingAction(
            onClick = { onNavigateToCreate() },
            modifier =
            Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            icon = Icons.Default.Add,
            contentDescription = "Favorite",
        )
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
fun PreviewHomeScreenContent() {
    Task4Me {
        HomeScreenContent(
            taskList =
            listOf(
                Task(id = 11L, name = "Small task"),
                Task(id = 12L, name = "Small task 2"),
                Task(id = 13L, name = "Small task 3"),
                Task(id = 14L, name = "Small task 4"),
            ), {}, {}
        )
    }
}
