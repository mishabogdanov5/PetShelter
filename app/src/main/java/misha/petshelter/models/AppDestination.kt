package misha.petshelter.models

import misha.petshelter.ui.theme.AUTH_SCREEN
import misha.petshelter.ui.theme.MAIN_SCREEN

sealed class AppDestination(
    val screenName: String
) {
    object AuthScreen: AppDestination(AUTH_SCREEN)
    object MainScreen: AppDestination(MAIN_SCREEN)
}
