package ai.ftech.nationflag

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.ColorUtils

class DrawView constructor(
    context: Context, attrs: AttributeSet? = null) : View(context,attrs) {
    private var paint: Paint = Paint()
    private var bitmap: Bitmap? = null
    private var layer: Canvas? = null

    private var transparentPaint = Paint().apply {
        color = resources.getColor(android.R.color.transparent, null)
        xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
    }

    private var listData = listOf<DetectData>()
    private var listDetectView = mutableListOf<DetectView>()

    init {
        //configure background color
        val backgroundAlpha = 0.5
        paint.color = ColorUtils.setAlphaComponent(resources.getColor(R.color.black, null), (255 * backgroundAlpha).toInt())

        //configure hole color & mode
        transparentPaint.color = resources.getColor(android.R.color.transparent, null)
        transparentPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
    }

    override fun onDraw(canvas: Canvas?) {
        if (bitmap == null) {
            configureBitmap()
        }
        //draw background
        layer?.drawRect(0.0f, 0.0f, width.toFloat(), height.toFloat(), paint)
        if (listData.isNotEmpty()) {
            //draw transparent
            listData.forEachIndexed { index, detectData ->
                layer?.drawRect(detectData.left, detectData.top, detectData.right, detectData.bottom, transparentPaint)
            }

        }
        //draw bitmap
        canvas?.drawBitmap(bitmap!!, 0.0f, 0.0f, paint)
    }

    fun setData(listData: List<DetectData>) {
        this.listData = listData
        this.invalidate()
    }

    private fun configureBitmap() {
        //create bitmap and layer
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        layer = Canvas(bitmap!!)
    }
}