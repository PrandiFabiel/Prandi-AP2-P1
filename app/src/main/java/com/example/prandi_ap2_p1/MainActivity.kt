package com.example.prandi_ap2_p1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.prandi_ap2_p1.ui.registroConsultaP1.nameConsulta
import com.example.prandi_ap2_p1.ui.registroConsultaP1.nameRegistro
import com.example.prandi_ap2_p1.ui.theme.PrandiAP2P1Theme
import com.example.prandi_ap2_p1.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParcialApp()
        }
    }
}

@Composable
fun ParcialApp(
) {
    PrandiAP2P1Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navHostController = rememberNavController( )

            NavHost(navController = navHostController, startDestination = Screen.nameConsulta.route){
                composable(route = Screen.nameConsulta.route ){
                    nameConsulta(
                        onNavigateToRegistro =  {navHostController.navigate(Screen.nameRegistro.route)}
                    )
                }
                composable(route = Screen.nameRegistro.route ){
                    nameRegistro(onSave = {navHostController.navigateUp()})
                }

            }
        }
    }
}
