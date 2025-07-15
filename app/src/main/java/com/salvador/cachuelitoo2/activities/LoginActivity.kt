package com.salvador.cachuelitoo2.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.salvador.cachuelitoo2.navigations.LoginNavigation
import com.salvador.cachuelitoo2.ui.app.viewmodels.LoginScreenViewModel
import com.salvador.cachuelitoo2.ui.app.viewmodels.SplashScreenViewModel
import com.salvador.cachuelitoo2.ui.theme.Cachuelitoo2Theme


class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Cachuelitoo2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
                {
                    val loginViewModel = LoginScreenViewModel()
                    val splashScreenViewModel = SplashScreenViewModel()
                    LoginNavigation(
                         loginScreenViewModel = loginViewModel,
                        splashScreenViewModel = splashScreenViewModel

                    )
                }
            }
        }
    }
}

