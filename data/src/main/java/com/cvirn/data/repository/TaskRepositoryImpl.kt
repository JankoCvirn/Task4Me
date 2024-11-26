package com.cvirn.data.repository

import app.cash.sqldelight.coroutines.asFlow
import db.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import sqldelight.db.Database

class TaskRepositoryImpl(
    database: Database,
) : TaskRepository {
    private val taskQueries = database.taskQueries

    override fun getAllTasks(): Flow<List<Task>> =
        taskQueries.selectAllTasks().asFlow().map {
            it.executeAsList()
        }

    override fun addTask(task: Task) {
        taskQueries.insertTask(name = task.name, id = null)
    }

    override fun deleteTask(task: Task) {
        taskQueries.deleteTask(id = task.id)
    }

    override fun updateTask(task: Task) {
        taskQueries.updateTask(name = task.name, id = task.id)
    }
}
