package com.example.cryptocurrency_app.presentation.coin_detail

import com.example.cryptocurrency_app.domain.models.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coinsDetail : CoinDetail? = null,
    val error: String = ""
)