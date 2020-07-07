package com.kotlinsg.kworkshopapp.repo2

import com.kotlinsg.kworkshopapp.GithubProject
import com.kotlinsg.kworkshopapp.di.Logger
import com.kotlinsg.kworkshopapp.network.NetworkClient
import com.kotlinsg.kworkshopapp.repo.GithubRepo2
import javax.inject.Inject

class GithubRepo2Impl @Inject constructor(
        val client: NetworkClient,
        val logger: Logger
) : GithubRepo2 {

    override fun getSampleProject(onResult: (GithubProject) -> Unit, onError: (Throwable) -> Unit) {
        logger.d("requested  project 2")
        client.requestProject("kotlinsg/KWorkshopApp", onResult, onError)
    }

}
