package com.example.weathercleanarchitecture.core.di

import com.example.weathercleanarchitecture.core.data.WeatherRepository
import com.example.weathercleanarchitecture.core.domain.repository.IWeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(tourismRepository: WeatherRepository): IWeatherRepository

}