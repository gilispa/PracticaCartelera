
package islas.gilberto.cartelera

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import islas.gilberto.cartelera.ui.theme.CarteleraTheme

@Composable
fun RegistroScreen(
    onRegistroOk: () -> Unit,
    onBack: () -> Unit
) {
    var correo by rememberSaveable { mutableStateOf("") }
    var contrasena by rememberSaveable { mutableStateOf("") }
    var confirmacion by rememberSaveable { mutableStateOf("") }
    var mensajeError by rememberSaveable { mutableStateOf("") }
    var cargando by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(
            space = 12.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Crear cuenta",
            style = MaterialTheme.typography.headlineLarge
        )

        OutlinedTextField(
            value = correo,
            onValueChange = {
                correo = it
                mensajeError = ""
            },
            label = { Text("Correo electrónico") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = contrasena,
            onValueChange = {
                contrasena = it
                mensajeError = ""
            },
            label = { Text("Contraseña") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = confirmacion,
            onValueChange = {
                confirmacion = it
                mensajeError = ""
            },
            label = { Text("Confirmar contraseña") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            modifier = Modifier.fillMaxWidth()
        )

        if (mensajeError.isNotEmpty()) {
            Text(
                text = mensajeError,
                color = MaterialTheme.colorScheme.error
            )
        }

        Button(
            onClick = {
                mensajeError = validarRegistro(
                    correo,
                    contrasena,
                    confirmacion
                )

                if (mensajeError.isEmpty() && !cargando) {
                    cargando = true

                    FirebaseAuth.getInstance()
                        .createUserWithEmailAndPassword(
                            correo.trim(),
                            contrasena
                        )
                        .addOnCompleteListener { tarea ->
                            cargando = false

                            if (tarea.isSuccessful) {
                                onRegistroOk()
                            } else {
                                mensajeError =
                                    tarea.exception?.localizedMessage
                                        ?: "Error al registrar"
                            }
                        }
                }
            },
            enabled = !cargando,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (cargando) "Registrando..." else "Registrarse")
        }

        TextButton(onClick = onBack) {
            Text("Ya tengo cuenta")
        }
    }
}

fun validarRegistro(
    correo: String,
    contrasena: String,
    confirmacion: String
): String {
    if (correo.isBlank() ||
        contrasena.isBlank() ||
        confirmacion.isBlank()
    ) {
        return "Llena todos los campos"
    }

    if (contrasena.length < 6) {
        return "La contraseña debe tener al menos 6 caracteres"
    }

    if (contrasena != confirmacion) {
        return "Las contraseñas no coinciden"
    }

    return ""
}

@Preview(showBackground = true)
@Composable
fun RegistroScreenPreview() {
    CarteleraTheme {
        RegistroScreen(
            onRegistroOk = {},
            onBack = {}
        )
    }
}
