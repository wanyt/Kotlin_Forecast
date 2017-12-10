package com.kotlin.forecast.kotlin_forcast.base

import android.arch.lifecycle.Lifecycle

/**
 * Create on 2017/12/6 下午2:35
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.9
 */
interface BaseMVPContract {

    interface View {

    }

    interface Presenter<V : View> {

        fun attachLifecycle(lifecycle: Lifecycle)

        fun detachLifecycler(lifecycle: Lifecycle)

        fun attachView(view: V);

        fun detachView(view: View)


    }

}