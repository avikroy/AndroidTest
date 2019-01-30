package com.example.a738119.samplepro.Utils

import com.example.a738119.samplepro.Model.AddSubscriptionModel
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper

object ParseUtil {

    fun getParsedSubscriptionModel(response: String?): AddSubscriptionModel {
        var addSubscriptionModelObj: AddSubscriptionModel = AddSubscriptionModel()
        var objMapper: ObjectMapper = ObjectMapper()
        objMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        try {
            addSubscriptionModelObj = objMapper.readValue(response!!.trim(), AddSubscriptionModel::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return addSubscriptionModelObj
    }
}