package presentation.root.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import utils.Tabs

@Composable
internal fun NavigationGraph(
    selectedTab: Int,
    navController: NavController,
) {
    LaunchedEffect(selectedTab) {
        when (selectedTab) {
            0 ->
                navController.navigate(Tabs.Books) {
                    popUpTo(Tabs.Characters) {
                        saveState = true
                        inclusive = true
                    }

                    launchSingleTop = true
                    restoreState = true
                }

            1 ->
                navController.navigate(Tabs.Characters) {
                    popUpTo(Tabs.Books) {
                        saveState = true
                        inclusive = true
                    }

                    launchSingleTop = true
                    restoreState = true
                }
        }
    }
}
