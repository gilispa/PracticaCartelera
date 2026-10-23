package islas.gilberto.cartelera

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.firebase.auth.FirebaseAuth

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val auth = remember { FirebaseAuth.getInstance() }

    val inicio = remember {
        if (auth.currentUser != null) "peliculas" else "login"
    }

    NavHost(
        navController = navController,
        startDestination = inicio,
        modifier = modifier
    ) {
        composable("login") {
            LoginScreen(
                onLoginOk = {
                    navController.navigate("peliculas") {
                        popUpTo("login") {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                onRegistrarse = {
                    navController.navigate("registro")
                }
            )
        }

        composable("registro") {
            RegistroScreen(
                onRegistroOk = {
                    navController.navigate("peliculas") {
                        popUpTo("login") {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable("peliculas") {
            PeliculasScreen(
                correo = auth.currentUser?.email ?: "",
                onPeliculaClick = { id ->
                    navController.navigate("detalle/$id")
                },
                onCerrarSesion = {
                    auth.signOut()

                    navController.navigate("login") {
                        popUpTo("peliculas") {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(
            route = "detalle/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) { entrada ->
            val id = entrada.arguments?.getInt("id") ?: 1

            DetalleScreen(
                peliculaId = id,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}