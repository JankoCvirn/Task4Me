package com.cvirn.task4me.di

import com.cvirn.task4me.usecase.AddNewTaskUseCaseImpl
import com.cvirn.task4me.usecase.DeleteTaskUseCaseImpl
import com.cvirn.task4me.usecase.GetALlTasksUseCaseImpl
import com.cvirn.task4me.usecase.UpdateTaskUseCaseImpl
import com.cvirn.task4me.viewmodel.HomeViewModel
import com.cvirn.task4me.viewmodel.TaskViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule =
    module {
        single { GetALlTasksUseCaseImpl(get()) }
        single { AddNewTaskUseCaseImpl(get()) }
        single { UpdateTaskUseCaseImpl(get()) }
        single { DeleteTaskUseCaseImpl(get()) }

        viewModel { HomeViewModel(get()) }
        viewModel { TaskViewModel(get(), get(), get()) }
    }
