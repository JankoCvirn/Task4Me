package com.cvirn.task4me.usecase.task

import db.Task

internal interface UpdateTaskUseCase {
    suspend fun execute(task: Task)
}