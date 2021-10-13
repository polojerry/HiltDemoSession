package com.samples.domain.repository

import com.samples.domain.models.News
import com.samples.domain.models.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun fetchTopHeadlines() : Resource<Flow<List<News>>>
}