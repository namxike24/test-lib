package ai.ftech.nationflag


import ai.ftech.nationflag.databinding.NationFlagItemBinding
import androidx.databinding.ViewDataBinding

class NationFlagAdapter : BaseAdapter() {


    var listener: ItemListener? = null

    override fun getLayoutResource(viewType: Int): Int = R.layout.nation_flag_item

    override fun onCreateViewHolder(viewType: Int, binding: ViewDataBinding): BaseVH<*> {
        return DataVH(binding)
    }

    override fun getDataAtPosition(position: Int) = dataList[position] as NationFlag

    inner class DataVH(binding: ViewDataBinding) : BaseVH<NationFlag>(binding) {
        private val viewBinding = binding as NationFlagItemBinding

        init {
            viewBinding.llRoot.setOnSafeClick {
                listener?.onClickItem(dataList[adapterPosition] as NationFlag)
            }
            viewBinding.ivTranslate.setOnSafeClick {
                listener?.onClickTranslate(dataList[adapterPosition] as NationFlag)
            }
        }

        override fun onBind(data: NationFlag) {
            super.onBind(data)
            with(viewBinding) {
                val imgId: Int = getApplication().resources.getIdentifier(data.flag, "drawable", getApplication().packageName)
                ivFlag.setImageResource(imgId)
                tvName.text = String.format("%s - %s", data.nameVi, data.nameEn)
            }
        }

    }



    interface ItemListener {
        fun onClickItem(data: NationFlag)
        fun onClickTranslate(data: NationFlag)
    }
}
