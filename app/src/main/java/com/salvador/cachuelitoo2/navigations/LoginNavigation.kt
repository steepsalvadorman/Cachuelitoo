package com.salvador.cachuelitoo2.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.salvador.cachuelitoo2.ui.app.screens.LoginScreen
import com.salvador.cachuelitoo2.ui.app.screens.SplashScreen
import com.salvador.cachuelitoo2.ui.app.viewmodels.LoginScreenViewModel
import com.salvador.cachuelitoo2.ui.app.viewmodels.SplashScreenViewModel


@Composable
fun LoginNavigation(
    loginScreenViewModel: LoginScreenViewModel,
    splashScreenViewModel: SplashScreenViewModel

) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "/"
    ) {
       composable(
           route = "/"
       ){
           SplashScreen(
               navController = navController,
               splashScreenViewModel = splashScreenViewModel
           )
       }

        composable(
            route = "/login"
        ){
            LoginScreen()
        }
    }
}