package com.cvirn.task4me.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cvirn.task4me.screen.CreateTaskScreen
import com.cvirn.task4me.screen.HomeScreen
import com.cvirn.task4me.screen.UpdateTaskScreen

@Suppress("ktlint:standard:function-naming")
@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onNavigateToCreate = { navController.navigate("createTask") },
                onNavigateToUpdate = {navController.navigate("updateTask")}
            )
        }
        composable("createTask") {
            CreateTaskScreen(onNavigateBack = { navController.popBackStack() })
        }
        composable("updateTask") {
            UpdateTaskScreen(onNavigateBack = { navController.popBackStack() })
        }
    }
}
