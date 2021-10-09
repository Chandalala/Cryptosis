package com.chandalala.cryptosis.data.repository

import com.chandalala.cryptosis.data.remote.CoinPaprikaApi
import com.chandalala.cryptosis.data.remote.dto.CoinDetailDto
import com.chandalala.cryptosis.data.remote.dto.CoinDto
import com.chandalala.cryptosis.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api:CoinPaprikaApi
):CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}