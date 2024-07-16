package presentation.root.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Modifier
import components.navigation.TitleAppBar
import soup.compose.material.motion.animation.materialSharedAxisYIn
import soup.compose.material.motion.animation.materialSharedAxisYOut
import utils.BarsVisibility
import utils.Tabs

@Composable
internal fun TopBars(
    barsVisibility: BarsVisibility,
    selectedTab: MutableIntState,
) {
    AnimatedVisibility(
        visible = !barsVisibility.topBars.isVisible,
        enter = materialSharedAxisYIn(forward = false, slideDistance = 30),
        exit = materialSharedAxisYOut(forward = true, slideDistance = 30),
    ) {
        Column {
            TitleAppBar(title = "Harry Potter Wiki")
            TabBar(selectedTab = selectedTab)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TabBar(selectedTab: MutableIntState) {
    PrimaryTabRow(
        selectedTabIndex = selectedTab.intValue,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Tabs.entries.forEachIndexed { index, currentTab ->
            val selected = selectedTab.intValue == index
            Tab(
                selected = selected,
                onClick = { selectedTab.intValue = (index) },
                text = { Text(convertIntToString(index)) },
            )
        }
    }
}

private fun convertIntToString(id: Int): String =
    when (id) {
        0 -> "Книги"

        1 -> "Персонажи"

        else -> ""
    }
