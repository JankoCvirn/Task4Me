package com.cvirn.task4me.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cvirn.task4me.usecase.AddNewTaskUseCaseImpl
import com.cvirn.task4me.usecase.DeleteTaskUseCaseImpl
import com.cvirn.task4me.usecase.UpdateTaskUseCaseImpl
import db.Task
import kotlinx.coroutines.launch

class TaskViewModel(
    private val addNewTaskUseCaseImpl: AddNewTaskUseCaseImpl,
    private val updateTaskUseCaseImpl: UpdateTaskUseCaseImpl,
    private val deleteTaskUseCaseImpl: DeleteTaskUseCaseImpl
) : ViewModel() {

    fun addNewTask(task: Task) {
        viewModelScope.launch {
            addNewTaskUseCaseImpl.execute(task)
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            updateTaskUseCaseImpl.execute(task = task)
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            deleteTaskUseCaseImpl.execute(task = task)
        }
    }
}
