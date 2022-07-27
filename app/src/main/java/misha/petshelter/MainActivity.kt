package misha.petshelter

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import misha.petshelter.models.AppDestination
import misha.petshelter.services.localStorage.UserStorage
import misha.petshelter.services.navigation.AppNavigation
import misha.petshelter.ui.theme.AUTH_GRAPH
import misha.petshelter.ui.theme.MAIN_GRAPH
import misha.petshelter.ui.views.login.LoginView
import misha.petshelter.ui.views.main.MainView
import misha.petshelter.viewModels.LoginViewModel
import misha.petshelter.viewModels.RegisterViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var storage: UserStorage

    @Inject
    lateinit var navigation: AppNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val startGraph = when(storage.getTokens()) {
            null -> AUTH_GRAPH
            else -> MAIN_GRAPH
        }

        setContent {
            val navController = rememberNavController()
            navigation.navController = navController

            NavHost(navController = navController, startDestination = startGraph) {

                navigation(startDestination = AppDestination.AuthScreen.screenName,
                    route = AUTH_GRAPH) {

                    composable(route = AppDestination.AuthScreen.screenName) {
                        val loginViewModel = hiltViewModel<LoginViewModel>()
                        val registerViewModel = hiltViewModel<RegisterViewModel>()

                        LoginView(loginViewModel, registerViewModel)
                    }
                }

                navigation(startDestination = AppDestination.MainScreen.screenName,
                    route = MAIN_GRAPH) {

                    composable(route = AppDestination.MainScreen.screenName) {
                        MainView()
                    }
                }
            }
        }

    }

}




