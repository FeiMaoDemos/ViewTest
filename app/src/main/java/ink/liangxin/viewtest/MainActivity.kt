package ink.liangxin.viewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    /**
     * 入口列表
     */
    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.recycler_view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.initActivityList(this)
    }

}