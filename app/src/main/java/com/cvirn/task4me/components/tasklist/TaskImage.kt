/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cvirn.task4me.components.tasklist

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cvirn.task4me.R

@Composable
fun TaskImage(
    drawableResource: Int,
    description: String,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(48.dp),
        painter = painterResource(id = drawableResource),
        contentDescription = description,
    )
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
fun PreviewTaskImage() {
    TaskImage(
        drawableResource = R.drawable.task_runners,
        description = "",
    )
}
