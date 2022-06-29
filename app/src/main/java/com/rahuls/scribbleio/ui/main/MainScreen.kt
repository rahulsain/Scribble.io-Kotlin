package com.rahuls.scribbleio.ui.main

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rahuls.scribbleio.ui.main.group.CreateGroup
import com.rahuls.scribbleio.ui.main.group.JoinGroup
import com.rahuls.scribbleio.ui.nav.NAV_CREATE_GROUP
import com.rahuls.scribbleio.ui.nav.NAV_JOIN_GROUP
import com.rahuls.scribbleio.ui.nav.NAV_SPLASH

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NAV_SPLASH){
        composable(NAV_SPLASH) { Splash(navController) }
        composable(NAV_CREATE_GROUP) { CreateGroup(hiltViewModel()) }
        composable(NAV_JOIN_GROUP) { JoinGroup(hiltViewModel()) }
    }
}