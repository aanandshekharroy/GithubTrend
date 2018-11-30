package com.example.theseus.githubtrend.data.api

import com.example.theseus.githubtrend.data.api.model.TrendingAPIResponse.GithubTrendingRepoResponse
import io.reactivex.Single
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when` as _when

class APIManagerTest {

    @Mock
    lateinit var mAPIService: APIService
    @InjectMocks
    lateinit var mAPIManager: APIManager
    @Mock
    lateinit var mGithubTrendingRepoResponse: GithubTrendingRepoResponse
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }
    @Test
    fun whenFetchNetworkCalled_CallDelegatedToAPIService(){
        //given
        _when(mAPIService.fetchTrendingAndroidReposFromGithub())
            .thenReturn(Single.just(mGithubTrendingRepoResponse))
        //when
        mAPIManager.fetchTrendingAndroidRepos()
        //verify
        verify(mAPIService).fetchTrendingAndroidReposFromGithub()
    }
}