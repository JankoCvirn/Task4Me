package com.cvirn.task4me.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cvirn.task4me.usecase.AddNewTaskUseCaseImpl
import com.cvirn.task4me.usecase.GetALlTasksUseCaseImpl
import db.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getALlTasksUseCaseImpl: GetALlTasksUseCaseImpl,
    private val addNewTaskUseCaseImpl: AddNewTaskUseCaseImpl,
) : ViewModel() {
    private val _allTasksFlow = MutableStateFlow<List<Task>>(emptyList())
    val allTasksFlow: StateFlow<List<Task>> = _allTasksFlow

    fun loadTaskList() {
        viewModelScope.launch {
            getALlTasksUseCaseImpl.execute().collect {
                _allTasksFlow.value = it
            }
        }
    }

    fun addNewTask() {
        viewModelScope.launch {
            addNewTaskUseCaseImpl.execute(Task(id = 100L, name = "Test 1234"))
        }
    }
}
