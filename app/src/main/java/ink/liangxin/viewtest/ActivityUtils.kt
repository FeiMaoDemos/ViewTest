package ink.liangxin.viewtest

import android.app.Activity
import android.content.Intent

/**
 * 启动Activity
 *
 * @param activity 当前Activity
 */
fun Class<out Activity>.open(activity: Activity) {
    activity.startActivity(
        Intent(
            activity, this
        )
    )
}