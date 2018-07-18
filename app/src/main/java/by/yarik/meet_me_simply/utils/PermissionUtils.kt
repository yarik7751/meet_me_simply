package by.yarik.meet_me_simply.utils

import android.content.pm.PackageManager

object PermissionUtils {

    fun isAllPermissionsGranted(grantResults: IntArray): Boolean {
        for(i in 0 until grantResults.size) {
            if(grantResults[i] != PackageManager.PERMISSION_GRANTED) return false
        }
        return true
    }
}