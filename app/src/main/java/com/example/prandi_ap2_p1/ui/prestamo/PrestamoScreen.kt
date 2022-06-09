@file:JvmName("PrestamoListScreenKt")

package com.example.prandi_ap2_p1.ui.prestamo

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PrestamoScreen(
    onSave: () -> Unit,
    viewModel: PrestamoViewModel = hiltViewModel()
) {

    var deudor by rememberSaveable { mutableStateOf(false) }
    var concepto by rememberSaveable { mutableStateOf(false) }
    var monto by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current
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
                    deudor = viewModel.deudor.isBlank()
                    concepto = viewModel.concepto.isBlank()
                    monto = viewModel.monto.isBlank()
                    if(!deudor && !concepto && !monto){
                        if(viewModel.monto.toFloat() > 0){
                            viewModel.Guardar()
                            onSave()
                        }else{
                            Toast.makeText(context, "El monto no puede ser negativo", Toast.LENGTH_SHORT).show()
                        }
                    }
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
                onValueChange = { viewModel.deudor = it
                                  deudor = false },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    keyboardType = KeyboardType.Text
                ),
                isError = deudor
            )

            TextObligatorio(error = deudor)

            OutlinedTextField(
                label = {
                    Text(text = "Concepto")
                },
                value = viewModel.concepto,
                onValueChange = { viewModel.concepto = it
                                  concepto = false},
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Sentences,
                    keyboardType = KeyboardType.Text
                ),
                isError = concepto
            )

            TextObligatorio(error = concepto)

            OutlinedTextField(
                label = {
                    Text(text = "Monto")
                },
                value = viewModel.monto,
                onValueChange = { viewModel.monto = it
                                monto = false},
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    keyboardType = KeyboardType.Number
                ),
                isError = monto
            )
            TextObligatorio(error = monto)
        }
    }

}

@Composable
fun TextObligatorio (error: Boolean){

    val assistiveElementText = if(error) "Error: Obligatrio" else "*Obligatorio"
    val assitiveElementColor = if(error){
        MaterialTheme.colors.error
    }else{
        MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium)
    }

    Text(
        text = assistiveElementText,
        color = assitiveElementColor,
        style = MaterialTheme.typography.caption,
        modifier = Modifier.padding(start = 16.dp)
    )
}


