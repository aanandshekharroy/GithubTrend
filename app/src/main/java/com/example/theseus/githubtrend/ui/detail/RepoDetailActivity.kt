package com.example.theseus.githubtrend.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.theseus.githubtrend.R
import com.example.theseus.githubtrend.data.api.model.TrendingAPIResponse.RepoItem
import com.example.theseus.githubtrend.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.toast


class RepoDetailActivity : BaseActivity() {
    lateinit var mRepo: RepoItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        mRepo = intent.getParcelableExtra("repo")
        setupViews()
    }

    private fun setupViews() {
        Glide.with(this)
            .load(mRepo.owner.avatarUrl)
            .into(avatar_url)
        owner_name.text = mRepo.owner.login
        repo_description.text = mRepo.description
        supportActionBar?.let {
            it.title = mRepo.name
        }
        github_url.setOnClickListener {
            openRepoLinkInBrowser()
        }
    }
    /*
    * Check if intent can be handled by any app in the phone. If so, launch it
    * */
    private fun openRepoLinkInBrowser() {
        val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(mRepo.owner.htmlUrl))
        if (webIntent.resolveActivity(packageManager) != null) {
            startActivity(webIntent)
        } else {
            toast(R.string.cant_launch_url)
        }
    }
}
