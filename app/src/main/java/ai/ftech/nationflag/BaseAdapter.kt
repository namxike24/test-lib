package ai.ftech.nationflag

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter : RecyclerView.Adapter<BaseVH<Any>>() {
    companion object {
        const val INVALID_RESOURCE = -1
        const val INIT_VIEW_TYPE = 100
        const val LOAD_MORE_VIEW_TYPE = 101
        const val NORMAL_VIEW_TYPE = 102
    }

    var dataList: MutableList<Any> = mutableListOf()
        private set

    private lateinit var myInflater: LayoutInflater

    abstract fun getLayoutResource(viewType: Int): Int

    open fun getLayoutLoadMore() = R.layout.base_load_more_default_item

    open fun getLayoutInit() = R.layout.base_init_default_item

    abstract fun onCreateViewHolder(viewType: Int, binding: ViewDataBinding): BaseVH<*>

    abstract fun getDataAtPosition(position: Int): Any

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseVH<Any> {
        if (!::myInflater.isInitialized) {
            myInflater = LayoutInflater.from(parent.context)
        }
        val binding: ViewDataBinding

        return when (viewType) {
            INIT_VIEW_TYPE -> {
                binding = DataBindingUtil.inflate(
                    myInflater,
                    getLayoutInit(),
                    parent,
                    false
                )
                InitVH(binding) as BaseVH<Any>

            }
            LOAD_MORE_VIEW_TYPE -> {
                binding = DataBindingUtil.inflate(
                    myInflater,
                    getLayoutLoadMore(),
                    parent,
                    false
                )
                LoadMoreVH(binding) as BaseVH<Any>
            }
            else -> {
                binding = DataBindingUtil.inflate(
                    myInflater,
                    getLayoutResource(viewType),
                    parent,
                    false
                )
                val context = binding.root.context as LifecycleOwner
                binding.lifecycleOwner = context
                binding.executePendingBindings()
                onCreateViewHolder(viewType, binding) as BaseVH<Any>
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (dataList[position] is LoadMore) {
            LOAD_MORE_VIEW_TYPE
        } else {
            NORMAL_VIEW_TYPE
        }
    }

    override fun onBindViewHolder(holder: BaseVH<Any>, position: Int) {
        if (dataList[position] !is LoadMore) {
            holder.onBind(getDataAtPosition(position))
        }
    }

    override fun onBindViewHolder(
        holder: BaseVH<Any>,
        position: Int,
        payloads: List<Any>
    ) {
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position)
        } else {
            holder.onBind(getDataAtPosition(position), payloads)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    open fun resetData(dataList: List<Any>) {
        this.dataList.clear()
        this.dataList.addAll(dataList)
        notifyDataSetChanged()
    }

    fun addListItem(dataList: List<Any>) {
        val size = this.dataList.size
        this.dataList.addAll(dataList)
        notifyItemRangeInserted(size, dataList.size)
    }

    fun add(item: Any) {
        this.dataList.add(item)
        notifyItemInserted(dataList.size)
    }

    fun add(item: Any, position: Int) {
        this.dataList.add(item)
        notifyItemInserted(position)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearData() {
        this.dataList.clear()
        notifyDataSetChanged()
    }

    fun update(item: Any, position: Int) {
        dataList[position] = item
        notifyItemChanged(position)
    }

    fun removeItem(position: Int) {
        if (dataList.isNotEmpty()) {
            dataList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun removeItem(item: Any, position: Int) {
        if (dataList.isNotEmpty()) {
            dataList.remove(item)
            notifyItemRemoved(position)
        }
    }

    fun isEmpty(): Boolean {
        return dataList.isEmpty()
    }

    inner class InitVH(val binding: ViewDataBinding) : BaseVH<Init>(binding)

    inner class LoadMoreVH(val binding: ViewDataBinding) : BaseVH<LoadMore>(binding)

    class Init

    class LoadMore
}
