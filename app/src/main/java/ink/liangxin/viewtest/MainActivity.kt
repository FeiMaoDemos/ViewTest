package ink.liangxin.viewtest

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import ink.liangxin.demoutils.activity.activitylist.ActivityListActivity

class MainActivity : ActivityListActivity() {

	override val activityList: List<Pair<String, Class<out Activity>>> =
		listOf<Pair<String, Class<out Activity>>>(
			"View位置API测试" to ViewLocationActivity::class.java,
			"EditText测试" to EditTextActivity::class.java
		)

	/**
	 * 入口列表
	 */
	override val recyclerView: RecyclerView by lazy {
		findViewById(R.id.recycler_view)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

}