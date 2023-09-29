package ai.ftech.nationflag

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView

@SuppressLint("ViewConstructor")
class DetectView constructor(
    context: Context, val position: Int
) : RelativeLayout(context) {

    var listener: Listener? = null

    private lateinit var root: RelativeLayout
    private lateinit var tvPosition: TextView
    private lateinit var ivTopLeft: AppCompatImageView
    private lateinit var ivTopRight: AppCompatImageView
    private lateinit var ivBottomLeft: AppCompatImageView
    private lateinit var ivBottomRight: AppCompatImageView

    init {
        LayoutInflater.from(context).inflate(R.layout.detect_view_layout, this, true)
        initView()
    }

    private fun initView() {
        root = findViewById(R.id.root)
        tvPosition = findViewById(R.id.tvPosition)
        ivTopLeft = findViewById(R.id.ivTopLeft)
        ivTopRight = findViewById(R.id.ivTopRight)
        ivBottomLeft = findViewById(R.id.ivBottomLeft)
        ivBottomRight = findViewById(R.id.ivBottomRight)
        tvPosition.text = position.toString()
        root.setOnSafeClick {
            listener?.onClick()
        }
    }

    fun select(selected: Boolean) {
        this.isSelected = selected
        if (isSelected) {
            tvPosition.gone()
            ivTopLeft.show()
            ivTopRight.show()
            ivBottomLeft.show()
            ivBottomRight.show()
        } else {
            tvPosition.show()
            ivTopLeft.hide()
            ivTopRight.hide()
            ivBottomLeft.hide()
            ivBottomRight.hide()
        }
    }

    interface Listener {
        fun onClick()
    }

}