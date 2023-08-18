package com.example.mycomponents.infastracture.di

import com.example.mycomponents.infastracture.Cache
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {


    @Provides
    @Singleton
    fun provideCache(): Cache {
        return Cache()
    }
}