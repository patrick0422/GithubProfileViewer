package com.example.githubprofileviewer.ui

import androidx.lifecycle.ViewModel
import com.example.githubprofileviewer.data.api.GithubApi
import com.example.githubprofileviewer.data.model.GithubUserProfile
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Single
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val githubApi: GithubApi
): ViewModel() {

    fun getUserProfile(userName: String): Single<GithubUserProfile> = githubApi.getUserProfile(userName)
}