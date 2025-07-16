package com.salvador.cachuelitoo2.ui.app.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salvador.cachuelitoo2.R


@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Color(0xFFE5F6FD))
    ) {
        TopBackgroundImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),

        ) {
            WelcomeText()
            EmailTextField(email) { email = it }
            PasswordTextField(password, passwordVisible, { password = it }) { passwordVisible = it }
            LoginButton()
        }
        SocialLoginButtons()
    }
}


@Composable
fun TopBackgroundImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.background_new),
        modifier = modifier,
        contentDescription = "Logo Cachuelitoo",
        contentScale = ContentScale.Crop
    )
}

@Composable
fun WelcomeText() {
    Text(
        text = "Bienvenido\notra vez",
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        letterSpacing = 1.sp,
        lineHeight = 35.sp,
        color = Color(0xFF1C5D99)
    )
}

@Composable
fun EmailTextField(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Correo electrónico", fontSize = 14.sp) },
        placeholder = { Text("ejemplo@correo.com") },
        singleLine = true,
        leadingIcon = {
            Icon(
                painterResource(R.drawable.email),
                contentDescription = "Ícono de correo"
            )
        },
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFF1C5D99),
            unfocusedBorderColor = Color(0xFFB0BEC5)
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    )
}

@Composable
fun PasswordTextField(value: String, visible: Boolean, onValueChange: (String) -> Unit, onVisibilityChange: (Boolean) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Contraseña") },
        placeholder = { Text("Tu contraseña") },
        singleLine = true,
        visualTransformation = if (visible) VisualTransformation.None else PasswordVisualTransformation(),
        leadingIcon = {
            Icon(
                painterResource(R.drawable.password),
                contentDescription = "Ícono de contraseña"
            )
        },
        trailingIcon = {
            IconButton(onClick = { onVisibilityChange(!visible) }) {
                Icon(
                    imageVector = if (visible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                    contentDescription = if (visible) "Ocultar contraseña" else "Mostrar contraseña"
                )
            }
        },
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFF1C5D99),
            unfocusedBorderColor = Color(0xFFB0BEC5)
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    )
}

@Composable
fun LoginButton() {
    OutlinedButton(
        onClick = {},
        modifier = Modifier
            .padding(top = 20.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFF1600D),
            contentColor = Color.White
        )
    ) {
        Text(
            text = "ENTRAR",
            color = Color(0xFF1E1E1E),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun SocialLoginButtons() {
    Row(
        modifier = Modifier
            .background(Color(0xFFE5F6FD))
            .padding(all = 50.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        SocialButton("Facebook", R.drawable.facebook, modifier = Modifier.weight(1f).shadow(4.dp, RoundedCornerShape(24.dp), clip = true))
        Spacer(modifier = Modifier.width(12.dp))
        SocialButton("Google", R.drawable.google, modifier = Modifier.weight(1f).shadow(4.dp, RoundedCornerShape(24.dp), clip = true))
    }
}

@Composable
fun SocialButton(text: String, iconRes: Int, modifier: Modifier = Modifier) {
    OutlinedButton(
        onClick = {},
        modifier = modifier,
        border = BorderStroke(1.dp, Color(0xFF1C5D99)),
        colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.White)
    ) {
        Text(
            text = text,
            color = Color(0xFF3B608C),
            fontWeight = FontWeight.Bold
        )
        Icon(
            painterResource(id = iconRes),
            contentDescription = text,
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}
