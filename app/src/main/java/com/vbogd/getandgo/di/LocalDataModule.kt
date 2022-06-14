package com.vbogd.getandgo.di

import com.vbogd.getandgo.data.OrderRepositoryImpl
import com.vbogd.getandgo.data.local.OrderLocalDataSource
import com.vbogd.getandgo.data.local.OrderTestData
import com.vbogd.getandgo.domain.OrderRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataModule {

    @Binds
    abstract fun bindOrderDataSource(
        orderData: OrderTestData
    ): OrderLocalDataSource

    @Binds
    abstract fun bindOrderRepository(
        repository: OrderRepositoryImpl
    ): OrderRepository

}