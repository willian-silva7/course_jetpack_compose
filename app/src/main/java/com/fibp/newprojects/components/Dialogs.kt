package com.fibp.newprojects.components

import android.app.Dialog
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import com.fibp.newprojects.R
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

@Composable
fun MyDialog( showDialog: Boolean, email: String) {
//    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { },
            confirmButton = {},
            dismissButton = { },
            title = { Text("Atenção") },
            text = {
                Text(
                    text = buildAnnotatedString {
                        append("Bem vindo ao Aplicativo ")

                        // parte colorida (email)
                        withStyle(style = SpanStyle(color = Color.Red)) {
                            append(email)
                        }
                    },
                    textAlign = TextAlign.Center
                )
                   },
            shape = RoundedCornerShape(12),
            icon = { Icon(modifier= Modifier.size(52.dp), imageVector = Icons.Default.Info, contentDescription = null) }
        )
    }
}
