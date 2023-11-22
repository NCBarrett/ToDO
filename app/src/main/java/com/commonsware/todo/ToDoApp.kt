package com.commonsware.todo

import android.app.Application
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class ToDoApp : Application() {
    private val koinModule = module {
        single { ToDoRepository() }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)  // requires (Level.ERROR) to not crash on phone
            modules(koinModule)
        }
    }
}