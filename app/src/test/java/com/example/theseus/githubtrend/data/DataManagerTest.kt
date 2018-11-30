package com.example.theseus.githubtrend.data

import com.example.theseus.githubtrend.data.api.APIManager
import com.example.theseus.githubtrend.data.api.IAPIManager
import com.example.theseus.githubtrend.data.api.model.TrendingAPIResponse.GithubTrendingRepoResponse
import io.reactivex.Single
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when` as _when
class DataManagerTest{
    @Mock
    lateinit var mAPIManager: IAPIManager
    @InjectMocks
    lateinit var mDataManager: DataManager
    @Mock
    lateinit var mGithubTrendingRepoResponse: GithubTrendingRepoResponse
    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
    }
    @Test
    fun whenFetchDataCalled_CallDelegatedToAPIManager(){
        //given
        _when(mAPIManager.fetchTrendingAndroidRepos())
            .thenReturn(Single.just(mGithubTrendingRepoResponse))
        //when
        mDataManager.fetchTrendingAndroidRepos()
        //then
        verify(mAPIManager).fetchTrendingAndroidRepos()
    }
}