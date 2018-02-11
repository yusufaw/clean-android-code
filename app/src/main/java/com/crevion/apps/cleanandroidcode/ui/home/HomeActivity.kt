package com.crevion.apps.cleanandroidcode.ui.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.crevion.apps.cleanandroidcode.BaseApp
import com.crevion.apps.cleanandroidcode.R
import com.crevion.apps.cleanandroidcode.models.CityListData
import com.crevion.apps.cleanandroidcode.models.CityListResponse
import com.crevion.apps.cleanandroidcode.models.User
import com.crevion.apps.cleanandroidcode.networking.Service
import com.crevion.apps.cleanandroidcode.preferences.PreferencesUtil
import javax.inject.Inject

/**
 * Created by yusufaw on 2/9/18.
 */

class HomeActivity : BaseApp(), HomeView {

    private var recyclerView: RecyclerView? = null
    @Inject
    lateinit var service: Service
    @Inject
    lateinit var preferencesUtil: PreferencesUtil
    private var progressBar: ProgressBar? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        deps.inject(this)
        preferencesUtil.putUserLogin(User("xxx", "Yusuf Aji", "Wibowow", "ucupper@gmail.com", "oke"))
        renderView()
        init()

        val homePresenter = HomePresenter(service!!, this)
        homePresenter.getCityList()
    }

    fun renderView() {
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.list)
        progressBar = findViewById(R.id.progress)
    }

    private fun init() {
        recyclerView!!.layoutManager = LinearLayoutManager(this)
    }

    override fun showWait() {
        progressBar!!.visibility = View.VISIBLE
    }

    override fun removeWait() {
        progressBar!!.visibility = View.GONE
    }

    override fun onFailure(appErrorMessage: String) {

    }

    override fun geCityListSuccess(cityListResponse: CityListResponse) {
        val homeAdapter = HomeAdapter(applicationContext, cityListResponse.data,
                object : HomeAdapter.OnItemClickListener {
                    override fun onClick(cityListData: CityListData) {
                        Toast.makeText(applicationContext, cityListData.name, Toast.LENGTH_LONG)
                    }
                })

        recyclerView!!.adapter = homeAdapter
        Toast.makeText(this, preferencesUtil.getUserLogin().firstName, Toast.LENGTH_LONG).show()
    }
}