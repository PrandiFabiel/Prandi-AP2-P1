@file:JvmName("PrestamoListScreenKt")

package com.example.prandi_ap2_p1.ui.prestamo

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun nameRegistro(
    onSave: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Registro") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onSave()
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Save, contentDescription = "New")
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier.padding(10.dp)) {

            OutlinedTextField(
                label = {
                    Text(text = "algo")
                },
                value = "",
                onValueChange = { },
                modifier = Modifier.fillMaxWidth(),

            )
        }
    }

}