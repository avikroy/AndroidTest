package com.example.a738119.samplepro.Utils

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.a738119.samplepro.Model.AddSubscriptionModel

class DBHelper(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, name, factory, version) {

    val TABLE_RSS = "products"
    val COLUMN_ID = "id"
    val COLUMN_TITLE = "productname"
    val COLUMN_URL = "quantity"
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_PRODUCTS_TABLE = ("CREATE TABLE " +
                TABLE_RSS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_TITLE
                + " TEXT," + COLUMN_URL + " TEXT" + ")")
        db?.execSQL(CREATE_PRODUCTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_RSS)
        onCreate(db)
    }

    fun addRSS(model: AddSubscriptionModel): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_TITLE, model.title)
        values.put(COLUMN_URL, model.url)
        val _success = db.insert(TABLE_RSS, null, values)
        db.close()
        Log.v("InsertedID", "$_success")
        return (Integer.parseInt("$_success") != -1)
    }

    fun getAllUsers(): String {
        var allUser: String = "";
        val db = readableDatabase
        val selectALLQuery = "SELECT * FROM $TABLE_RSS"
        val cursor = db.rawQuery(selectALLQuery, null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    var id = cursor.getString(cursor.getColumnIndex(COLUMN_ID))
                    var column_title = cursor.getString(cursor.getColumnIndex(COLUMN_TITLE))
                    var column_url = cursor.getString(cursor.getColumnIndex(COLUMN_URL))

                    allUser = "$allUser\n$id $column_title $column_url"
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        db.close()
        return allUser
    }

    fun UpdateUser(id: Int): Int {
        val db = readableDatabase
        val cv = ContentValues()
        //cv.put("Field1", "Bob") //These Fields should be your String values of actual column names
       // cv.put("Field2", "19")
        //cv.put("Field2", "Male")

        return db.update(TABLE_RSS, cv, "_id=" + id, null)
    }


    fun CheckIsDataAlreadyInDBorNot(TableName: String,dbfield: String, fieldValue: String): Boolean {
        val db = readableDatabase
        val Query = "Select * from $TableName where $dbfield = $fieldValue"
        val cursor = db.rawQuery(Query, null)
        if (cursor.getCount() <= 0) {
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }
}