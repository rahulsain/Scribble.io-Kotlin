package com.rahuls.scribbleio.di

import android.content.Context
import com.rahuls.scribbleio.data.AppPreferences
import com.rahuls.scribbleio.data.RandomWordsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppPreferences(@ApplicationContext context: Context) = AppPreferences(context)

    @Provides
    @Singleton
    fun provideRandomWordsApi(): RandomWordsApi = RandomWordsApi.invoke()

}