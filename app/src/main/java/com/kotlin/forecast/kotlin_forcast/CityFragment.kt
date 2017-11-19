package com.kotlin.forecast.kotlin_forcast

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.util.ArrayMap
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.forecast.kotlin_forcast.model.DataManager
import kotlinx.android.synthetic.main.fragment_city.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

/**
 * Create on 2017/10/24 下午11:20
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.9
 */
class CityFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater?.inflate(R.layout.fragment_city, container, false)
        return inflate
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tv_txt.setText("abcdddd")

        getForecastInfo()
    }

    private fun getForecastInfo() {
        val arrayMap = ArrayMap<String, String>()
        arrayMap.put("location", "北京")
        arrayMap.put("key", "726096547ed942a3947b1e22c2c7b6ee")
        arrayMap.put("unit", "m")

        val forecast = DataManager.getForecast(arrayMap)
        forecast.enqueue(object : retrofit2.Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
//                val toString = response.toString()
//                response?.body()?.string()
                Log.d("abc>", response?.body()?.string())
            }

            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
//                val toString = response.toString()
                Log.d("abcd>", t.toString())
            }
        })

        val abc = "chen"
        val abcd = "wang"


        tv_txt.setOnClickListener({ tv_txt.text = "wangyunti" })

        tv_txt.setOnClickListener(View.OnClickListener(){

        })


    }

}


