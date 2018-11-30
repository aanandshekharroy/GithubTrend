package com.example.theseus.githubtrend.ui.main

import com.example.theseus.githubtrend.data.DataManager
import com.example.theseus.githubtrend.data.api.model.TrendingAPIResponse.GithubTrendingRepoResponse
import com.example.theseus.githubtrend.data.api.model.TrendingAPIResponse.RepoItem
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Test
import org.mockito.*
import org.mockito.Mockito.*
import retrofit2.HttpException
import retrofit2.Response
import org.mockito.Mockito.`when` as _when

class MainPresenterTest {
    @Mock
    lateinit var mDataManager: DataManager

    @Mock
    lateinit var mGithubTrendingRepoResponse: GithubTrendingRepoResponse

    @Mock
    lateinit var mRepoList: List<RepoItem>
    @Mock
    lateinit var mCompositeDisposable: CompositeDisposable
    @Mock
    lateinit var mMainActivity: IMainView

    @Spy
    @InjectMocks
    lateinit var mMainPresenter: MainPresenter<IMainView>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mMainPresenter.view = mMainActivity
        _when(mDataManager.fetchTrendingAndroidRepos())
            .thenReturn(Single.just(mGithubTrendingRepoResponse))
    }

    @Test
    fun whenFetchTrendingAndroidReposCalled_DataIsFetchedUsingDataManager() {
        //when
        mMainPresenter.fetchTrendingAndroidRepos()
        //verify
        verify(mDataManager).fetchTrendingAndroidRepos()
    }

    @Test
    fun whenPresenterAttached_FetchDataFromTheNetwork(){
        //when
        mMainPresenter.onAttach(mMainActivity)
        //verify
        verify(mDataManager).fetchTrendingAndroidRepos()
    }

    @Test
    fun showProgressDialog_WhenFetchingBegins(){
        //when
        mMainPresenter.onAttach(mMainActivity)
        //then
        verify(mMainActivity).showProgressDialog()
    }

    @Test
    fun hideProgressBar_WhenDataFetchedSuccessfully(){
        //given
        _when(mDataManager.fetchTrendingAndroidRepos())
            .thenReturn(Single.just(mGithubTrendingRepoResponse))
        //when
        mMainPresenter.fetchTrendingAndroidRepos()
        //then
        verify(mMainActivity).hideProgressDialog()

    }

    @Test
    fun hideProgressBar_WhenDataFetchingFails(){
        //given
        _when(mDataManager.fetchTrendingAndroidRepos())
            .thenReturn(Single.error(HttpException(Response.error<String>(500, ResponseBody.create(MediaType.parse("application/json"),"")))))
        //when
        mMainPresenter.fetchTrendingAndroidRepos()
        //then
        verify(mMainActivity).hideProgressDialog()

    }

    @Test
    fun showErrorView_WhenDataFetchingFails(){
        //given
        _when(mDataManager.fetchTrendingAndroidRepos())
            .thenReturn(Single.error(HttpException(Response.error<String>(500, ResponseBody.create(MediaType.parse("application/json"),"")))))
        //when
        mMainPresenter.fetchTrendingAndroidRepos()
        //then
        verify(mMainActivity).showErrorViews()
    }

    @Test
    fun hideErrorView_WhenDataFetchingSucceeds(){
        //given
        _when(mDataManager.fetchTrendingAndroidRepos())
            .thenReturn(Single.just(mGithubTrendingRepoResponse))
        //when
        mMainPresenter.fetchTrendingAndroidRepos()
        //then
        verify(mMainActivity).hideErrorViews()
    }

    @Test
    fun populateRepoList_WhenNetworkCallSucceeds(){
        //given
        _when(mDataManager.fetchTrendingAndroidRepos())
            .thenReturn(Single.just(mGithubTrendingRepoResponse))
        _when(mGithubTrendingRepoResponse.items).thenReturn(mRepoList)
        //when
        mMainPresenter.fetchTrendingAndroidRepos()
        //then
        verify(mMainActivity).populateRepoList(mRepoList)
    }

    @Test
    fun disposeSubscription_WhenPresenterDetached(){
        //when
        mMainPresenter.onDetach()
        //verify
        mCompositeDisposable.dispose()
    }
}