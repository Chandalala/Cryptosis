package com.chandalala.cryptosis.domain.usecase.coin


import com.chandalala.cryptosis.common.Resource
import com.chandalala.cryptosis.data.remote.dto.toCoinDetail
import com.chandalala.cryptosis.domain.model.CoinDetail
import com.chandalala.cryptosis.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinUseCase @Inject constructor(
    private val repository: CoinRepository
){

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {


            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))



        }
        catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?:"An unexpected error has occurred"))

        }
        catch (e: IOException){
            emit(Resource.Error(e.localizedMessage ?:"An unexpected error has occurred"))
        }
    }
}