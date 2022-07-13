package ink.liangxin.viewtest

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    /**
     * Activity集合
     */
    private val activitys = listOf<Pair<String, Class<out Activity>>>(
        "View位置API测试" to ViewLocationActivity::class.java
    )

    /**
     * 入口列表
     */
    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.recycler_view)
    }

    private val adapter by lazy {
        MyAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }

    inner class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            MyViewHolder(TextView(this@MainActivity).apply {
                layoutParams =
                    RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, 200)
                gravity = Gravity.CENTER
            })

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            (holder.itemView as TextView).text = activitys[position].first
            holder.itemView.setOnClickListener {
                activitys[position].second.open(this@MainActivity)
            }
        }

        override fun getItemCount() = activitys.size

    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}