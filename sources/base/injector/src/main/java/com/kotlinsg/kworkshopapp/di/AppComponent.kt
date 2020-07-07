package com.kotlinsg.kworkshopapp.di

import com.kotlinsg.kworkshopapp.RealApp
import com.kotlinsg.kworkshopapp.network.di.NetworkComponent
import com.kotlinsg.kworkshopapp.network.di.NetworkProvider
import com.kotlinsg.kworkshopapp.repo.di.RepoComponent
import dagger.Component
import javax.inject.Singleton


@Component(
        dependencies = [
            MainToolsProvider::class,
            NetworkProvider::class,
            RepoProvider::class,
            GithubBrowserProvider::class
        ]
)
@Singleton
interface AppComponent : ApplicationProvider {

    fun inject(app: RealApp)

    class Initializer private constructor() {
        companion object {

            fun init(app: RealApp): AppComponent {

                val mainToolsProvider = MainToolsComponent.Initializer
                        .init(app)

                val networkProvider = NetworkComponent.Initializer
                        .init(mainToolsProvider)

                val repoProvider = RepoComponent.Initializer
                        .init(mainToolsProvider, networkProvider)

                val githubBrowserProvider = GithubBrowserExportComponent.Initializer
                        .init(mainToolsProvider)

                return DaggerAppComponent.builder()
                        .mainToolsProvider(mainToolsProvider)
                        .networkProvider(networkProvider)
                        .repoProvider(repoProvider)
                        .githubBrowserProvider(githubBrowserProvider)
                        .build()
            }
        }
    }
}

