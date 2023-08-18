package com.example.mycomponents.infastracture.navigation.navigationGraph

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun BottomNavGraph(navController: NavHostController) {

//    NavHost(
//        navController = navController,
//        startDestination = BottomNavBarScreen.Home.route,
//        route = HOME_GRAPH_ROUTE
//    ) {

//        composable(route = BottomNavBarScreen.Home.route) {
//
//
//            val index = remember { navController.previousBackStackEntry?.savedStateHandle?.get<Int>("index") }
//            val viewModel: HomeViewModel = hiltViewModel()
//            if (index != null)
//                viewModel.setSelectedIndex(index)
//
//            val screenState = viewModel.homeScreenState.value
//
//            HomeScreen(
//                navController = navController,
//                screenState = screenState,
//                onItemSelected = viewModel::setSelectedIndex
//            )
//        }
//
//        composable(route = BottomNavBarScreen.FlykkMe.route) {
//            FlykkMeScreen()
//        }
//
//        composable(route = BottomNavBarScreen.FlykkIt.route) {
//            FlykkItScreen(navController = navController)
//        }
//
//        composable(route = BottomNavBarScreen.ScanQr.route) {
//            ScanQrScreen(navController = navController)
//        }
//
//        composable(route = FlykkItScreen.AddNewScreen.route) {
//            AddNewOptionsScreen(navController = navController)
//        }
//
//        composable(route = FlykkItScreen.EditBeneficiaryScreen.route) {
//
//            val viewModel = it.sharedViewModel<EditBeneficiaryViewModel>(navController = navController)
//            val beneficiary =  navController.previousBackStackEntry?.savedStateHandle?.get<com.isignthis.flykk.data.dto.flykkit.BankAccount>("beneficiary")
//            if (beneficiary != null) {
//                viewModel.setSelectedBeneficiary(beneficiary)
//            }
//            navController.previousBackStackEntry?.savedStateHandle?.remove<com.isignthis.flykk.data.dto.flykkit.BankAccount>("beneficiary")
//
//            EditBeneficiaryScreen(
//                navController = navController,
//                screenState = viewModel.screenState.value,
//                onEvent = viewModel::onEvent,
//                uiEventFlow = viewModel.uiEventFlow
//            )
//        }



  //  }
}