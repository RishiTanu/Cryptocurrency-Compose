package com.example.cryptocurrency_app.domain.use_cases.get_coin

import com.example.cryptocurrency_app.common.Resource
import com.example.cryptocurrency_app.data.remote.dto.toCoin
import com.example.cryptocurrency_app.data.remote.dto.toCoinDetail
import com.example.cryptocurrency_app.domain.models.Coin
import com.example.cryptocurrency_app.domain.models.CoinDetail
import com.example.cryptocurrency_app.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCases @Inject constructor(
    private val coinRepository: CoinRepository
) {

    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = coinRepository.getCoinDetail(coinId).toCoinDetail()
            emit(Resource.Success(coin))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Could not react your server. please check your internet connection"))
        }
    }
}