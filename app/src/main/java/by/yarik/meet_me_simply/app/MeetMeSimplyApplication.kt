package by.yarik.meet_me_simply.app

import android.app.Application
import by.yarik.meet_me_simply.R
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump

class MeetMeSimplyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ViewPump.init(ViewPump.builder()
                .addInterceptor(CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/Comfortaa-Regular.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build())
    }
}