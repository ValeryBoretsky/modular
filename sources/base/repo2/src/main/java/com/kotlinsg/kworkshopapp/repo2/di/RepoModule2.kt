package com.kotlinsg.kworkshopapp.repo2.di

import com.kotlinsg.kworkshopapp.repo.GithubRepo2
import com.kotlinsg.kworkshopapp.repo2.GithubRepo2Impl
import dagger.Binds
import dagger.Module

@Module
interface RepoModule2 {

    @Binds fun bindsMainRepo2(impl: GithubRepo2Impl): GithubRepo2

}
