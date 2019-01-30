package com.example.a738119.samplepro.Model
import android.os.Parcel
import android.os.Parcelable

data class AddSubscriptionModel(val title:String="",val url:String=""): Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AddSubscriptionModel> {
        override fun createFromParcel(parcel: Parcel): AddSubscriptionModel {
            return AddSubscriptionModel(parcel)
        }

        override fun newArray(size: Int): Array<AddSubscriptionModel?> {
            return arrayOfNulls(size)
        }
    }
}