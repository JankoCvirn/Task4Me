package com.cvirn.task4me.components.tasklist

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cvirn.task4me.R
import com.cvirn.task4me.ui.theme.Task4Me
import com.cvirn.task4me.ui.values.LocalPaddingValues
import db.Task

@Composable
fun TaskCard(task: Task, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Card(
        modifier = modifier
            .padding(
                horizontal = LocalPaddingValues.current.large,
                vertical = LocalPaddingValues.current.medium
            )
            .semantics { }
            .clickable { onClick() },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(LocalPaddingValues.current.extraLarge)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TaskImage(
                    drawableResource = R.drawable.task_runners,
                    description = "",
                )
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(
                            horizontal = LocalPaddingValues.current.large,
                            vertical = LocalPaddingValues.current.small
                        ),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = task.name,
                        style = MaterialTheme.typography.bodyLarge,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }
            }
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
fun PreviewTaskCard() {
    Task4Me {
        TaskCard(
            task =
            Task(
                id = 100L,
                name = "My small task again and again and again and again",
            ),
            onClick = {},
        )
    }
}
