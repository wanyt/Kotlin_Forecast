package com.kotlin.forecast.kotlin_forcast.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Create on 2017/12/6 下午3:11
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.9
 */
abstract class BaseMVPActivity<V : BaseMVPContract.View, P : BaseMVPContract.Presenter<V>> : AppCompatActivity(), BaseMVPContract.View {

    open var presenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (presenter == null) {
            presenter = initPresenter()
        }

        presenter!!.attachLifecycle(lifecycle)

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.detachLifecycler(lifecycle)
    }

    abstract fun initPresenter(): P


}