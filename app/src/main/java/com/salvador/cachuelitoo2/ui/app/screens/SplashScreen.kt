package com.salvador.cachuelitoo2.ui.app.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.salvador.cachuelitoo2.ui.app.viewmodels.SplashScreenViewModel
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    navController: NavHostController,
    splashScreenViewModel: SplashScreenViewModel
)
{
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center,
    ){
        Text(text = "Bienvenido a la app, cargando...")
    }

    LaunchedEffect(Unit) {
        delay(2000L)
        navController.navigate("/login"){
            popUpTo("/"){ inclusive = true }
        }
    }

}