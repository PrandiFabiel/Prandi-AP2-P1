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
import androidx.hilt.navigation.compose.hiltViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PrestamoScreen(
    onSave: () -> Unit,
    viewModel: PrestamoViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Registro Prestamos") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onSave()
                    viewModel.Guardar()
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
                    Text(text = "Deudor")
                },
                value = viewModel.deudor,
                onValueChange = { viewModel.deudor = it },
                modifier = Modifier.fillMaxWidth(),

            )

            OutlinedTextField(
                label = {
                    Text(text = "Concepto")
                },
                value = viewModel.concepto,
                onValueChange = { viewModel.concepto = it },
                modifier = Modifier.fillMaxWidth(),
            )

            OutlinedTextField(
                label = {
                    Text(text = "Monto")
                },
                value = viewModel.monto,
                onValueChange = { viewModel.monto = it },
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }

}