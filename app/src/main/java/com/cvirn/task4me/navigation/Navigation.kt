package com.cvirn.task4me.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cvirn.task4me.screen.CreateTaskScreen
import com.cvirn.task4me.screen.HomeScreen
import com.cvirn.task4me.screen.UpdateTaskScreen
import com.google.gson.Gson
import db.Task

@Suppress("ktlint:standard:function-naming")
@Composable
fun AppNavigation(padding: PaddingValues) {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationRoute.HOME) {
        composable(NavigationRoute.HOME) {
            HomeScreen(
                onNavigateToCreate = { navController.navigate(NavigationRoute.CREATE) },
                onNavigateToUpdate = { task ->
                    val taskJson = task?.let { Gson().toJson(it) }
                    navController.navigate("${NavigationRoute.UPDATE}/$taskJson")
                }
            )
        }
        composable(NavigationRoute.CREATE)
        {
            CreateTaskScreen(onNavigateBack = { navController.popBackStack() })
        }

        composable(
            "${NavigationRoute.UPDATE}/{${NavigationRoute.UPDATE_PARAM}}",
            arguments = listOf(navArgument(NavigationRoute.UPDATE_PARAM) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val taskJson = backStackEntry.arguments?.getString(NavigationRoute.UPDATE_PARAM)
            val task = taskJson?.let {
                Gson().fromJson(it, Task::class.java)
            }
            task?.let {
                UpdateTaskScreen(task = task, onNavigateBack = { navController.popBackStack() })
            }
        }
    }
}

private object NavigationRoute {
    const val HOME: String = "home"
    const val CREATE: String = "createTask"
    const val UPDATE: String = "updateTask"
    const val UPDATE_PARAM: String = "taskJson"
}
