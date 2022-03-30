package com.example.githubprofileviewer.ui

import androidx.lifecycle.ViewModel
import com.example.githubprofileviewer.data.GithubRepository
import com.example.githubprofileviewer.data.model.GithubUserProfile
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val githubRepository: GithubRepository
): ViewModel() {
    val compositeDisposable = CompositeDisposable()

    fun getUserProfile(userName: String): Single<GithubUserProfile> = githubRepository.getUserProfile(userName)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

}