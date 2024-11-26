package com.cvirn.task4me.usecase

import com.cvirn.data.repository.TaskRepositoryImpl
import com.cvirn.task4me.usecase.task.UpdateTaskUseCase
import db.Task

class UpdateTaskUseCaseImpl(
    private val taskRepositoryImpl: TaskRepositoryImpl,
) : UpdateTaskUseCase {
    override suspend fun execute(task: Task) {
        taskRepositoryImpl.updateTask(task = task)
    }
}