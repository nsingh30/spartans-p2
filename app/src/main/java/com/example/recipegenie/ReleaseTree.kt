package com.example.recipegenie

    import android.util.Log
    import com.google.firebase.crashlytics.ktx.crashlytics
    import com.google.firebase.ktx.Firebase
    import org.jetbrains.annotations.NotNull
    import timber.log.Timber


class ReleaseTree: @NotNull Timber.Tree() {

        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            StaticObject.isDebugMode
            if(priority == Log.ERROR || priority == Log.WARN){
                var crashlytics = Firebase.crashlytics
                crashlytics.log("my custom log message")
            }
        }
    }
