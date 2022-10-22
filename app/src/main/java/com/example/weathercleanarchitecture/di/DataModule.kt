package com.example.weathercleanarchitecture.di

import com.example.data.repository.UserRepositoryImpl
import com.example.data.storage.UserStorage
import com.example.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {
    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}