package misha.petshelter.services.navigation

import androidx.navigation.NavHostController
import misha.petshelter.models.AppDestination

interface AppNavigation {
    var navController: NavHostController?

    fun navigateTo(destination: AppDestination)
}