package com.zhogin.gamepedia.navigation


import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.zhogin.search.presentation.SearchScreen

object SearchNavGraph: BaseNavGraph {

    sealed class Dest(val route: String) {
        data object Root: Dest("/search-root")
        data object Search: Dest("/search")
    }

    override fun build(
        modifier: Modifier,
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(

            route = Dest.Root.route,
            startDestination = Dest.Search.route,
        ) {
            composable(route = Dest.Search.route) {
                SearchScreen(
                    modifier = modifier,
                    onClickSearchedGame = {
                        navHostController.navigate(GameNavGraph.Dest.Details.getRoute(it))
                    },
                    onBackClicked = {
                        navHostController.popBackStack()
                    }
                )
            }
        }
    }
}