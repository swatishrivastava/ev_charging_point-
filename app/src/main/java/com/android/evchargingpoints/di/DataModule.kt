package com.android.evchargingpoints.di

import com.android.evchargingpoints.data.ChargingPointAPI
import com.android.evchargingpoints.data.ChargingPointRepo
import com.android.evchargingpoints.domain.IRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideRepo(api: ChargingPointAPI): IRepository = ChargingPointRepo(api)
}