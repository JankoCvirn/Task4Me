package com.cvirn.task4me.usecase

import com.cvirn.data.repository.TaskRepositoryImpl
import com.cvirn.task4me.usecase.task.DeleteTaskUseCase
import db.Task

class DeleteTaskUseCaseImpl(
    private val taskRepositoryImpl: TaskRepositoryImpl,
) : DeleteTaskUseCase {
    override suspend fun execute(task: Task) {
        taskRepositoryImpl.deleteTask(task = task)
    }
}
