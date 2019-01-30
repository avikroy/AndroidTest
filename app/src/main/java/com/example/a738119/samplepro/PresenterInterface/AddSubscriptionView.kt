package  com.example.a738119.samplepro.PresenterInterface

import com.example.a738119.samplepro.Model.AddSubscriptionModel
import java.util.*


interface AddSubscriptionView {
    fun onAddition(mSubscriptionList: ArrayList<AddSubscriptionModel>)
}