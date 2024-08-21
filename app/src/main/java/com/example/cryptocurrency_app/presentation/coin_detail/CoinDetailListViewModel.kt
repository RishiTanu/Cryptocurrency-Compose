package com.example.cryptocurrency_app.presentation.coin_detail

import com.example.cryptocurrency_app.domain.use_cases.get_coin.GetCoinUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinDetailListViewModel @Inject constructor(
    private val getCoinUseCases: GetCoinUseCases
) {

}