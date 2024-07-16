package presentation.root

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import components.layout.CenteredColumn
import presentation.root.ui.NavigationGraph
import presentation.root.ui.RootNavHost
import presentation.root.ui.TopBars
import theme.HPTheme
import utils.rememberBarVisibility

@Composable
fun RootScreen() {
    val navController = rememberNavController()
    val selectedTab = remember { mutableIntStateOf(0) }
    val barsVisibility = rememberBarVisibility()

    HPTheme {
        Scaffold(
            topBar = { TopBars(barsVisibility, selectedTab) },
        ) { padding ->
            val p = if (!barsVisibility.topBars.isVisible) padding.calculateTopPadding() else 0.dp
            val animatedPadding by animateDpAsState(p, label = "")
            CenteredColumn(
                topPadding = animatedPadding,
            ) {
                RootNavHost(
                    navController = navController,
                    barsVisibility = barsVisibility,
                )
                if (barsVisibility.showTabs.isVisible) {
                    NavigationGraph(
                        selectedTab = selectedTab.intValue,
                        navController = navController,
                    )
                }
            }
        }
    }
}
