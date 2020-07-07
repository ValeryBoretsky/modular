package com.kotlinsg.kworkshopapp.github

import com.kotlinsg.kworkshopapp.GithubProject
import com.kotlinsg.kworkshopapp.repo.GithubRepo
import com.kotlinsg.kworkshopapp.repo.GithubRepo2
import javax.inject.Inject


interface GithubUseCase {
    fun loadInfoFromGithub(onLoaded: (GithubProject) -> Unit, onError: (Throwable) -> Unit)
    fun loadInfoFromGithub2(onLoaded: (GithubProject) -> Unit, onError: (Throwable) -> Unit)
}

class GithubUseCaseImpl @Inject constructor(
        val repo: GithubRepo,
        val repo2: GithubRepo2
) : GithubUseCase {

    override fun loadInfoFromGithub(onLoaded: (GithubProject) -> Unit, onError: (Throwable) -> Unit) {
        repo.getSampleProject(onLoaded, onError)
    }

    override fun loadInfoFromGithub2(onLoaded: (GithubProject) -> Unit, onError: (Throwable) -> Unit) {
        repo2.getSampleProject(onLoaded, onError)
    }
}
