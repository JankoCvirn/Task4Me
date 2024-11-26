package com.cvirn.task4me.usecase.task

import db.Task

internal interface AddNewTaskUseCase {
    suspend fun execute(task: Task)
}
