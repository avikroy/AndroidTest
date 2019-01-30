package com.example.a738119.samplepro.Adapter
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a738119.samplepro.Interface.OnListItemClickInf
import com.example.a738119.samplepro.Model.AddSubscriptionModel
import com.example.a738119.samplepro.R
import kotlinx.android.synthetic.main.recycler_item.view.*
import java.util.*

class RecyclerAdapter(val context: Context?, arrayList: ArrayList<AddSubscriptionModel>?,mInf: OnListItemClickInf) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var layoutInflater: LayoutInflater
    private var mArrayList: ArrayList<AddSubscriptionModel>
    private lateinit var view: View
    private var mContext:Context
    private var mInterface:OnListItemClickInf
    init {
        mContext = context!!
        layoutInflater = LayoutInflater.from(mContext)
        mArrayList = arrayList!!
        this.mInterface = mInf
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        view = layoutInflater.inflate(R.layout.recycler_item, p0, false)
        return MyViewHolder(view);
    }

    override fun getItemCount(): Int {
        if (mArrayList != null) return mArrayList!!.size else return 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var holder = (holder as MyViewHolder)
        holder.setData(position)
        holder.itemView.linear_vw.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                mInterface.onItemClick(position)
            }
        })
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(position: Int) {
            itemView.tv_title_item.text = mArrayList.get(position).title
            itemView.tv_url_item.text = mArrayList.get(position).url
        }
    }
}