package com.example.githubprofileviewer.data

import com.example.githubprofileviewer.data.api.GithubApi
import com.example.githubprofileviewer.data.model.GithubUserProfile
import io.reactivex.Single
import javax.inject.Inject

class GithubRepository @Inject constructor(
    private val githubApi: GithubApi
) {
    fun getUserProfile(userName: String): Single<GithubUserProfile> = githubApi.getUserProfile(userName)
}