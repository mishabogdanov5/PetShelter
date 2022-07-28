package misha.petshelter.services.navigation

import androidx.navigation.NavHostController
import misha.petshelter.models.AppDestination

class AppNavigationImpl : AppNavigation {

    override var navController: NavHostController? = null

    override fun navigateTo(destination: AppDestination) {
        navController?.navigate(destination.screenName)
    }

}