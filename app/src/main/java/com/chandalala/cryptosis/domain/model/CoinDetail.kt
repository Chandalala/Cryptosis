package com.chandalala.cryptosis.domain.model

import com.chandalala.cryptosis.data.remote.dto.*

data class CoinDetail(
    val id: String,
    val is_active: Boolean,
    val description: String,
    val name: String,
    val rank: Int,
    val symbol: String,
    val tags: List<String>,
    val teamMember: List<TeamMember>,

    )

