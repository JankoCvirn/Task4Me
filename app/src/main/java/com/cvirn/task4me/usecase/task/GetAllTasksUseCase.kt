package com.cvirn.task4me.usecase.task

import db.Task
import kotlinx.coroutines.flow.Flow

internal interface GetAllTasksUseCase {
    fun execute(): Flow<List<Task>>
}
