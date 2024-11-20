package com.cvirn.task4me.di

import com.cvirn.task4me.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule =
    module {
        viewModel { HomeViewModel() }
    }
