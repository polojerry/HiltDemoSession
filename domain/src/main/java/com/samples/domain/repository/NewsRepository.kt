package com.samples.domain.repository

import com.samples.domain.model.News
import com.samples.domain.model.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun fetchTopHeadlines() : Flow<Resource<List<News>>>
}