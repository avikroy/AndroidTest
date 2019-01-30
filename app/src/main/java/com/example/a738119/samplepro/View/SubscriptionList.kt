package com.example.a738119.samplepro.View

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.a738119.samplepro.Adapter.RecyclerAdapter
import com.example.a738119.samplepro.ApiCall.GithubApiService
import com.example.a738119.samplepro.ApiCall.RetrofitClient
import com.example.a738119.samplepro.Extensions.showMyToast
import com.example.a738119.samplepro.Interface.OnListItemClickInf
import com.example.a738119.samplepro.Interface.PhillipPayBase
import com.example.a738119.samplepro.Model.AddSubscriptionModel
import com.example.a738119.samplepro.R
import kotlinx.android.synthetic.main.subscription_list.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class SubscriptionList : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var subscriptionList: ArrayList<AddSubscriptionModel>
    private lateinit var context: Context
    private lateinit var mService: GithubApiService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.subscription_list)
        context = this
        initView()
    }
    private fun initView() {
        subscriptionList = intent.getParcelableArrayListExtra("list")
        linearLayoutManager = LinearLayoutManager(this)
        subscription_rv.layoutManager = linearLayoutManager
        //subscription_rv.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        subscription_rv.adapter = RecyclerAdapter(context, subscriptionList,object : OnListItemClickInf{
            override fun onItemClick(position: Int) {
                    showMyToast(subscriptionList.get(position).title!!)
            }
        })
        mService = RetrofitClient.getGitHubApiService()
        fetchServices()
    }

    fun fetchServices(){
        mService.updateBadgeCount("","").enqueue(object : Callback<PhillipPayBase> {
            override fun onResponse(call: Call<PhillipPayBase>, response: Response<PhillipPayBase>) {
                var mPhillipPayBase: PhillipPayBase = response.body()!!
                mPhillipPayBase.let {
                    //mPhillipPayBase.createdDate
                }
            }
            override fun onFailure(call: Call<PhillipPayBase>, t: Throwable) {
                showMyToast("error")
            }
        })
    }
}