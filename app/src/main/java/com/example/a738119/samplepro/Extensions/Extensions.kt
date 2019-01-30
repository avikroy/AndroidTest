package com.example.a738119.samplepro.Extensions

import android.app.Activity
import android.content.Context
import android.widget.Toast


fun Activity.showMyToast(msg:String){
    Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
}


fun Context.showMyToast(msg:String){
    Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
}