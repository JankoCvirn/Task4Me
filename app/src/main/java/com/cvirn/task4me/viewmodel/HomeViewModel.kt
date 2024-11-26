package com.cvirn.task4me.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cvirn.task4me.usecase.AddNewTaskUseCaseImpl
import com.cvirn.task4me.usecase.GetALlTasksUseCaseImpl
import db.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getALlTasksUseCaseImpl: GetALlTasksUseCaseImpl,
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
}
