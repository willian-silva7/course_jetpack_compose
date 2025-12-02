package com.fibp.newprojects.components.navigation.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.fibp.newprojects.components.MyPasswordTextField
import com.fibp.newprojects.components.MyTextField

@Composable
fun LoginScreen(navigateToDetail: (Any?) -> Unit) {
    var email:String by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val isFormValid by remember(email, password) {
        derivedStateOf {
            email.contains("@") && password.length > 4
        }
    }

    Column (Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Login", fontSize = 30.sp)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Email")
        MyTextField(user = email) {email = it}
        Spacer(modifier = Modifier.weight(0.2f))
        Text(text = "Password")
        MyPasswordTextField(password = password, onPasswordChange = {password = it}, modifier = Modifier)
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = { navigateToDetail(email) }, enabled = isFormValid) {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}