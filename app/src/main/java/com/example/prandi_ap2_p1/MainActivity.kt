package com.example.prandi_ap2_p1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.prandi_ap2_p1.ui.prestamo.PrestamoListScreen
import com.example.prandi_ap2_p1.ui.prestamo.PrestamoScreen
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
                    PrestamoListScreen(
                        onNavigateToRegistro =  {navHostController.navigate(Screen.nameRegistro.route)}
                    )
                }
                composable(route = Screen.nameRegistro.route ){
                    PrestamoScreen(onSave = {navHostController.navigateUp()})
                }

            }
        }
    }
}
