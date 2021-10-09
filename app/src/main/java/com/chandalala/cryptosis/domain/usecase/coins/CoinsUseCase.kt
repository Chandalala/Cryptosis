package com.chandalala.cryptosis.domain.usecase.coins

import com.chandalala.cryptosis.common.Resource
import com.chandalala.cryptosis.data.remote.dto.toCoin
import com.chandalala.cryptosis.domain.model.Coin
import com.chandalala.cryptosis.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinsUseCase @Inject constructor(
    private val repository: CoinRepository
){

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {

            emit(Resource.Loading())
            val  coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))


        }
        catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?:"An unexpected error has occurred"))

        }
        catch (e: IOException){
            emit(Resource.Error(e.localizedMessage ?:"An unexpected error has occurred"))
        }
    }
}