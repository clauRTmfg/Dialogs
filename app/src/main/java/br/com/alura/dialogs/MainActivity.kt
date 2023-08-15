package br.com.alura.dialogs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import br.com.alura.dialogs.ui.theme.DialogsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DialogsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DialogsApp()
                }
            }
        }
    }
}

@Composable
fun DialogsApp() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val showDialog = remember { mutableStateOf(false) }

        if (showDialog.value)
            ComposableExcluirDadosNavegacao(setShowDialog = {
                showDialog.value = it
            })

        Button(onClick = {
            showDialog.value = true
        }) {
            Text("Abrir o Dialog")
        }
    }
}


@Composable
fun ComposableExcluirDadosNavegacao(
    onConfirmButton: () -> Unit = {},
    onDismissButton: () -> Unit = {},
    setShowDialog: (Boolean) -> Unit = {}
) {
    AlertDialog(
        onDismissRequest = { setShowDialog(false) },
        confirmButton = {
            TextButton(onClick = {
                onConfirmButton()
                setShowDialog(false)
            }) {
                Text("Apagar")
            }
        },
        dismissButton = {
            TextButton(onClick = {
                onDismissButton()
                setShowDialog(false)
            }) {
                Text("Cancelar")
            }
        },
        icon = { Icon(Icons.Filled.Delete, null) },
        title = { Text(text = "Apagar dados de navegação?", fontSize = 20.sp) },
        text = { Text(text = "Isso vai fazer com que seu histórico de navegação seja completamente apagado.") },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun AlertDialog(
    onDismissRequest: () -> Unit,
    confirmButton: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    dismissButton: (@Composable () -> Unit)? = null,
    icon: (@Composable () -> Unit)? = null,
    title: (@Composable () -> Unit)? = null,
    text: (@Composable () -> Unit)? = null,
): Unit {

}

