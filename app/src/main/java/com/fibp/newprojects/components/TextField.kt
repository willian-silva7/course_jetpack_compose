package com.fibp.newprojects.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun MyTextField(user: String, onUserChange: (String) -> Unit) {
    TextField(value = user, onValueChange = { onUserChange(it) },
        placeholder = { Text("Digite o Email") },
        singleLine = true,
        label = { Text(text = "Digite o Email") }
    )
}

@Composable
fun MyPasswordTextField(
    password: String,
    onPasswordChange: (String) -> Unit,
    modifier: Modifier
) {
    var passwordHidden by remember { mutableStateOf(true) }

    TextField(
        value = password,
        singleLine = true,
        onValueChange = { onPasswordChange(it) },
        placeholder = { Text(text = "Digite a senha") },
        label = { Text(text = "Introduza a senha") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            /*Text(
                text = if (passwordHidden) "Mostrar" else "Ocultar",
                modifier = modifier.clickable { passwordHidden = !passwordHidden }
            )*/
            Icon(
                painter = if (passwordHidden) painterResource(id = com.fibp.newprojects.R.drawable.ic_eye) else painterResource(id = com.fibp.newprojects.R.drawable.ic_close),
                contentDescription = "",
                modifier = modifier.clickable { passwordHidden = !passwordHidden }
            )
        }
    )
}