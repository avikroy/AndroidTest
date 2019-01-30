package com.example.a738119.samplepro.PresenterInterface

import com.example.a738119.samplepro.Model.AddSubscriptionModel
import kotlinx.android.synthetic.main.activity_add_subscription.*
import java.util.*

class AddSubscriptionImplicator(var view:AddSubscriptionView?) : AddSubscriptionInterface {
    private var mSubscriptionList: ArrayList<AddSubscriptionModel> = ArrayList()
    override fun onValidation(title: String, url: String) {
        if(isValidate(title,url)){
            var mObj = AddSubscriptionModel(title,url)
            mSubscriptionList.add(mObj)
        }
            view?.onAddition(mSubscriptionList)

    }

    private fun isValidate(title: String, url: String):Boolean{
        if(title.isNullOrEmpty()) return false
        else if (url.isNullOrEmpty()) return false
        else return true
    }

}