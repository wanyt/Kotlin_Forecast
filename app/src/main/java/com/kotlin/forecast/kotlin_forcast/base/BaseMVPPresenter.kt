package com.kotlin.forecast.kotlin_forcast.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver

/**
 * Create on 2017/12/6 下午3:04
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.9
 */
open interface BaseMVPPresenter<V : BaseMVPContract.View> : BaseMVPContract.Presenter<V>, LifecycleObserver {

    override fun attachLifecycle(lifecycle: Lifecycle) {
        lifecycle.addObserver(this)
    }

    override fun detachLifecycler(lifecycle: Lifecycle) {
        lifecycle.removeObserver(this)
    }

    var view: V?

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView(view: BaseMVPContract.View) {
        this.view = null
    }

}