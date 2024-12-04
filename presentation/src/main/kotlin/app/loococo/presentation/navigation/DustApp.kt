package app.loococo.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.loococo.presentation.theme.DustTheme
import app.loococo.presentation.theme.White

@Composable
fun DustApp() {
    DustTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            containerColor = White,
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                DustNavHost()
            }
        }
    }
}