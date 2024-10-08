package com.example.cryptocurrency_app.domain.models

import com.example.cryptocurrency_app.data.remote.dto.TagList
import com.example.cryptocurrency_app.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<TagList>,
    val teams: List<TeamMember>
)