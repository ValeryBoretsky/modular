package com.kotlinsg.kworkshopapp.repo

import com.kotlinsg.kworkshopapp.GithubProject

interface GithubRepo2 {
    fun getSampleProject(onResult: (GithubProject) -> Unit, onError: (Throwable) -> Unit)
}
