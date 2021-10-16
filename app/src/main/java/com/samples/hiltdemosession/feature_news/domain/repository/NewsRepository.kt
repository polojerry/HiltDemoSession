package com.samples.hiltdemosession.feature_news.domain.repository

import com.samples.hiltdemosession.feature_news.domain.model.News
import com.samples.hiltdemosession.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun fetchTopHeadlines() : Flow<Resource<List<News>>>
}