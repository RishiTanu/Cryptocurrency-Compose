package com.example.cryptocurrency_app.domain.repository

import com.example.cryptocurrency_app.data.remote.dto.CoinDetailDto
import com.example.cryptocurrency_app.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoin() : List<CoinDto>

    suspend fun getCoinDetail(coinId:String) : CoinDetailDto
}