package ink.liangxin.viewtest

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

/**
 * 使用Activity集合数据初始化RecyclerView列表
 *
 * @param context
 */
fun RecyclerView.initActivityList(context: Context) {
    layoutManager = LinearLayoutManager(context)
    adapter = myAdapter
    addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
}

/**
 * Activity集合
 */
private val activitys = listOf<Pair<String, Class<out Activity>>>(
    "View位置API测试" to ViewLocationActivity::class.java,
    "EditText测试" to EditTextActivity::class.java
)

/**
 * 用来填充Activity集合数据的Adapter
 */
private val myAdapter by lazy {
    MyAdapter()
}

private class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(TextView(parent.context).apply {
            layoutParams =
                RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, 200)
            gravity = Gravity.CENTER
        })

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        (holder.itemView as TextView).text = activitys[position].first
        holder.itemView.setOnClickListener {
            activitys[position].second.open(holder.itemView.context as Activity)
        }
    }

    override fun getItemCount() = activitys.size

}

private class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)