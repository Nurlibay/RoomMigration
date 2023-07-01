package uz.nurlibaydev.roommigration.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.nurlibaydev.roommigration.database.MainDao
import uz.nurlibaydev.roommigration.database.MainDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMainDatabase(@ApplicationContext context: Context): MainDatabase {
        return MainDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideMainDao(database: MainDatabase): MainDao {
        return database.userDao()
    }
}