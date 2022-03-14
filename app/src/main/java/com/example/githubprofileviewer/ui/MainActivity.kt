package com.example.githubprofileviewer.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import coil.load
import coil.transform.CircleCropTransformation
import com.example.githubprofileviewer.R
import com.example.githubprofileviewer.data.model.GithubUserProfile
import com.example.githubprofileviewer.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { DataBindingUtil.setContentView(this, R.layout.activity_main) }
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) = with(binding) {
        super.onCreate(savedInstanceState)

        buttonSearch.setOnClickListener {
            mainViewModel.getUserProfile(searchView.text.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { profile ->
                    setData(profile)
                }
        }
    }

    private fun setData(profile: GithubUserProfile) = with(binding) {
        imageUserAvatar.load(profile.avatarUrl) {
            crossfade(true)
            transformations(CircleCropTransformation())
        }
        textUserName.text = profile.name
        textUserNickName.text = profile.login
    }
}