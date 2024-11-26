package com.cvirn.task4me.usecase

import com.cvirn.data.repository.TaskRepositoryImpl
import com.cvirn.task4me.usecase.task.GetAllTasksUseCase
import db.Task
import kotlinx.coroutines.flow.Flow

class GetALlTasksUseCaseImpl(
    private val taskRepositoryImpl: TaskRepositoryImpl,
) : GetAllTasksUseCase {
    override fun execute(): Flow<List<Task>> = taskRepositoryImpl.getAllTasks()
}
