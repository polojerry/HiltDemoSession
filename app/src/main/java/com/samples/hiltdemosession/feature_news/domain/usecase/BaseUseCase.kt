package com.samples.hiltdemosession.feature_news.domain.usecase

interface BaseUseCase<in Params, out T> {
    suspend operator fun invoke(params: Params): T
}