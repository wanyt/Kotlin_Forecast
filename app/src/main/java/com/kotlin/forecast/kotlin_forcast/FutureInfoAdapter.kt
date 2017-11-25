package com.kotlin.forecast.kotlin_forcast

import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.kotlin.forecast.kotlin_forcast.model.bean.FutureInfo
import kotlinx.android.synthetic.main.item_future_info.view.*


/**
 * Create on 2017/11/25 下午2:55
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.9
 */
class FutureInfoAdapter(val activity: FragmentActivity, val list: ArrayList<FutureInfo>) : RecyclerView.Adapter<FutureInfoAdapter.ViewHolder>() {

    var layoutInflater: LayoutInflater

    init {
        layoutInflater = LayoutInflater.from(activity)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        if (holder is ViewHolder) {
            val info = list.get(position)
            holder.setItemView(info)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val inflate = layoutInflater.inflate(R.layout.item_future_info, null)
        return ViewHolder(inflate)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setItemView(info: FutureInfo) {
            itemView.tvWeekNo.text = info.week
            itemView.tvTmpRange.text = info.tmpRange
            Glide.with(itemView)
                    .load(info.icUrl)
                    .into(itemView.ivIcon)
        }

    }

}