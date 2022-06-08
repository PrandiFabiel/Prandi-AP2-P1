package com.example.prandi_ap2_p1.ui.prestamo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.prandi_ap2_p1.model.Prestamo

@Composable
fun PrestamoListScreen(
    onNavigateToRegistro: () -> Unit,
    viewModel: PrestamoViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "List") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onNavigateToRegistro()
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Nuevo")
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier.padding(it)) {
            val listaPrestamos = viewModel.prestamos.collectAsState(initial = emptyList())
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(listaPrestamos.value) { prestamo ->
                    PrestamoRow(prestamo)
                }
            }
        }
    }

}


@Composable
fun PrestamoRow(prestamo: Prestamo) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                enabled = true,
                onClick = { })
    )

    {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(25.dp)) {
            Text(
                text = prestamo.deudor,
            )
            Text(
                text = "$"+prestamo.monto.toString(),
            )
        }
        Text(
            text = prestamo.concepto,
        )

    }

}
