package com.cvirn.task4me.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Suppress("ktlint:standard:function-naming")
@Composable
fun AppNavigation()  {
    val navController: NavHostController = rememberNavController()
}
