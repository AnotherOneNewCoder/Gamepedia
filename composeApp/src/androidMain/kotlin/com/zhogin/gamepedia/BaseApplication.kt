package com.zhogin.gamepedia

import android.app.Application
import com.zhogin.gamepedia.di.initKoin
import org.koin.dsl.module

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin{
            it.modules(
                module {
                    single { this@BaseApplication.applicationContext }
                }
            )
        }
    }
}