package com.example.cryptocurrency_app.presentation

sealed class Screen(val route: String) {
    object CoinListScreen : Screen("coin_list_screen")
    object CoinListDetailScreen : Screen("coin_list_detail")
}