package by.yarik.meet_me_simply.app

import android.app.Application
import by.yarik.meet_me_simply.R
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class MeetMeSimplyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Comfortaa-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build())
    }
}