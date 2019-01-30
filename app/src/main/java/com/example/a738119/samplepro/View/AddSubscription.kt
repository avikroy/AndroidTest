package com.example.a738119.samplepro.View

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.a738119.samplepro.Extensions.showMyToast
import com.example.a738119.samplepro.Model.AddSubscriptionModel
import com.example.a738119.samplepro.PresenterInterface.AddSubscriptionImplicator
import com.example.a738119.samplepro.PresenterInterface.AddSubscriptionView
import com.example.a738119.samplepro.R
import com.example.a738119.samplepro.Utils.DBHelper

import kotlinx.android.synthetic.main.activity_add_subscription.*

class AddSubscription : AppCompatActivity(), AddSubscriptionView, View.OnClickListener {
    private lateinit var mImplicatorPresenter: AddSubscriptionImplicator
    private lateinit var mContext: Context
    private lateinit var madd_title_tv: String
    private lateinit var madd_url_tv: String
    private var subscriptionList: ArrayList<AddSubscriptionModel> =
        mutableListOf<AddSubscriptionModel>() as ArrayList<AddSubscriptionModel>
    private lateinit var dbHelper: DBHelper
    val DATABASE_VERSION = 1
    val DATABASE_NAME = "productDB"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_subscription)
        mContext = this
        dbHelper = DBHelper(this, DATABASE_NAME, null, DATABASE_VERSION)
        initView();
    }

    private fun initView() {
        mImplicatorPresenter = AddSubscriptionImplicator(this)
        add_btn.setOnClickListener(this)
        list_nav_btn.setOnClickListener(this)
        progress_group.visibility = View.GONE;
    }

    private fun OnClickOperation() {
        madd_title_tv = add_title_tv.text.toString()
        madd_url_tv = add_url_tv.text.toString()
        showMyToast(add_title_tv.text.toString())
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.add_btn -> {
                dbHelper.addRSS(AddSubscriptionModel(add_title_tv.text.toString(), add_url_tv.text.toString()))
                mImplicatorPresenter.onValidation(add_title_tv.text.toString(), add_url_tv.text.toString())

            }
            R.id.list_nav_btn -> {
                val intent: Intent
                intent = Intent(this, SubscriptionList::class.java)
                intent.putParcelableArrayListExtra("list", subscriptionList)
                startActivity(intent)
            }
        }
    }

    override fun onAddition(mSubscriptionList: ArrayList<AddSubscriptionModel>) {
        subscriptionList = mSubscriptionList

        /*val intent: Intent
        intent = Intent(this, SubscriptionList::class.java)
        intent.putParcelableArrayListExtra("list", mSubscriptionList)
        startActivity(intent)*/
    }


}

