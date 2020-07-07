package com.kotlinsg.kworkshopapp.repo2.di

import com.kotlinsg.kworkshopapp.di.MainToolsProvider
import com.kotlinsg.kworkshopapp.di.RepoProvider2
import com.kotlinsg.kworkshopapp.network.di.NetworkProvider
import dagger.Component

@Component(
        dependencies = [MainToolsProvider::class, NetworkProvider::class],
        modules = [RepoModule2::class])
interface RepoComponent2 : RepoProvider2 {
    class Initializer private constructor() {
        companion object {

            fun init(
                    mainToolsProvider: MainToolsProvider,
                    networkProvider: NetworkProvider
            ): RepoProvider2 {
                return DaggerRepoComponent2.builder()
                        .mainToolsProvider(mainToolsProvider)
                        .networkProvider(networkProvider)
                        .build()
            }
        }
    }
}
