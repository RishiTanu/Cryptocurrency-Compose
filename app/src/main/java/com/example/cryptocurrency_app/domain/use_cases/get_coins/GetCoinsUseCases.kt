package com.example.cryptocurrency_app.domain.use_cases.get_coins

import com.example.cryptocurrency_app.common.Resource
import com.example.cryptocurrency_app.data.remote.dto.toCoin
import com.example.cryptocurrency_app.domain.models.Coin
import com.example.cryptocurrency_app.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCases @Inject constructor(
    private val coinRepository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = coinRepository.getCoin().map { it.toCoin() }
            emit(Resource.Success(coins))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Could not react your server. please check your internet connection"))
        }
    }
}