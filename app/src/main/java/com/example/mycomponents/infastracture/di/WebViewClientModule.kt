package com.example.mycomponents.infastracture.di


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object WebViewClientModule {

//    @Provides
//    fun provideTopUpWebViewClient(getTransactionDetailsUseCase: GetTransactionDetailsUseCase): TopUpWebViewClient {
//        return TopUpWebViewClient(getTransactionDetailsUseCase)
//    }


}