package com.cvirn.task4me.usecase.task

import db.Task

interface DeleteTaskUseCase {
    suspend fun execute(task: Task)
}
