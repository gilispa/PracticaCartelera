package islas.gilberto.cartelera

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login",
        modifier = modifier
    ) {

        // Pantalla de inicio de sesión
        composable("login") {
            LoginScreen(
                onLoginOk = {
                    navController.navigate("peliculas") {
                        popUpTo("login") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        // Pantalla con la lista de películas
        composable("peliculas") {
            PeliculasScreen(
                onPeliculaClick = { id ->
                    navController.navigate("detalle/$id")
                }
            )
        }

        // Pantalla de detalles
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
