package com.chandalala.cryptosis.domain.repository

import com.chandalala.cryptosis.data.remote.dto.CoinDetailDto
import com.chandalala.cryptosis.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins():List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}