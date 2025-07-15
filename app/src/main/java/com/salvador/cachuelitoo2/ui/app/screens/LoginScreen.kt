package com.salvador.cachuelitoo2.ui.app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lint.kotlin.metadata.Visibility
import com.salvador.cachuelitoo2.R
import com.salvador.cachuelitoo2.ui.app.viewmodels.LoginScreenViewModel


@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen(
        viewModel = LoginScreenViewModel()
    )
}


@Composable
fun LoginScreen(
    viewModel: LoginScreenViewModel
){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize()

    ){
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,

        ){
            Image(
                painter = painterResource(id = R.drawable.top_background1),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start),
                contentDescription = "Logo Cachuelitoo",
            )
            Text(
               text = "Bienvenido\n otra vez",
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
                fontWeight = FontWeight.Bold
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Correo electrónico") },
                placeholder = { Text("ejemplo@correo.com") },
                singleLine = true,
                leadingIcon = {
                            Icon(
                                painterResource(R.drawable.email),
                                contentDescription = "Ícono de correo"
                            )


                },
                keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                modifier = Modifier.fillMaxWidth().padding(start = 50.dp, end = 50.dp)
                )


            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Contraseña") },
                placeholder = { Text("Tu contraseña") },
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                leadingIcon = {
                        Icon(
                            painterResource(R.drawable.password),
                            contentDescription = "Ícono de contraseña"
                        )
                },
                trailingIcon = {
                    IconButton(
                        onClick = {passwordVisible = !passwordVisible}
                    ) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            contentDescription = if (passwordVisible) "Ocultar contraseña" else "Mostrar contraseña"
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier.fillMaxWidth().padding(start = 50.dp, end = 50.dp)
            )
            OutlinedButton(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 20.dp),
                content = {
                    Text(
                        text = "ENTRAR",
                        color = Color(0xFF000000),
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0xFFEA6D35)
                )

            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 80.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                OutlinedButton(
                    onClick = {},
                    content = {
                        Text(
                            text = "Facebook",
                            color = Color(0xFF3B608C),
                            fontWeight = FontWeight.Bold
                        )

                        Icon(
                            painterResource(R.drawable.facebook),
                            contentDescription = "Facebook",
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }

                )

                OutlinedButton(
                    onClick = {},
                    content = {
                        Text(
                            text = "Google",
                            color = Color(0xFF3B608C),
                            fontWeight = FontWeight.Bold
                        )

                        Icon(
                            painterResource(R.drawable.google),
                            contentDescription = "Google",
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }

                )


            }

        }
    }


}