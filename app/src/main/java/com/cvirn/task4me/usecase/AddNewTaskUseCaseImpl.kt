package com.cvirn.task4me.usecase

import com.cvirn.data.repository.TaskRepositoryImpl
import com.cvirn.task4me.usecase.task.AddNewTaskUseCase
import db.Task

class AddNewTaskUseCaseImpl(
    private val taskRepositoryImpl: TaskRepositoryImpl,
) : AddNewTaskUseCase {
    override suspend fun execute(task: Task) {
        taskRepositoryImpl.addTask(task = task)
    }
}
