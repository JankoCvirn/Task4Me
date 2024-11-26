package com.cvirn.data.repository

import db.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getAllTasks(): Flow<List<Task>>

    fun addTask(task: Task)

    fun deleteTask(task: Task)

    fun updateTask(task: Task)
}
