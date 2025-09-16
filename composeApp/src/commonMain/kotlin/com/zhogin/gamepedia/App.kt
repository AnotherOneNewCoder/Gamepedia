package com.zhogin.gamepedia

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.MaterialTheme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.zhogin.gamepedia.navigation.FavoriteNavGraph
import com.zhogin.gamepedia.navigation.GameNavGraph
import com.zhogin.gamepedia.navigation.SearchNavGraph

@Composable
fun App() {

    MaterialTheme {
        val navHostController = rememberNavController()
        val bottomPadding = WindowInsets.statusBars.asPaddingValues().calculateBottomPadding()
        NavHost(
            navController = navHostController, startDestination = GameNavGraph.Dest.Root.route
        ) {
            listOf(
                GameNavGraph,
                SearchNavGraph,
                FavoriteNavGraph
            ).forEach {
                it.build(
                    modifier = Modifier.padding(top = bottomPadding).fillMaxSize(),
                    navHostController = navHostController,
                    navGraphBuilder = this
                )
            }
        }
    }
}