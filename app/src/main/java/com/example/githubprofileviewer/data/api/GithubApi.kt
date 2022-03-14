package com.example.githubprofileviewer.data.api

import com.example.githubprofileviewer.data.model.GithubUserProfile
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    @GET("users/{userName}")
    fun getUserProfile(@Path("userName") userName: String): Single<GithubUserProfile>
}