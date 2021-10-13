package com.samples.domain.usecases

interface BaseUseCase<in Params, out T> {
    suspend operator fun invoke(params: Params): T
}