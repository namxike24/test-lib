package ai.ftech.nationflag

import ai.ftech.nationflag.databinding.ActivityDrawViewBinding
import ai.ftech.nationflag.databinding.ActivityMainBinding
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset


class DrawViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDrawViewBinding
    private val listDetectView = mutableListOf<DetectView>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrawViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val view = DrawView(this@DrawViewActivity)
        binding.root.addView(view)

        listDetectView.clear()
        val listData = mutableListOf<DetectData>()
        listData.add(DetectData(100f, 50f, 600f, 200f))
        listData.add(DetectData(100f, 250f, 600f, 350f))

        view.setData(listData)
        listData.forEachIndexed { index, detectData ->
            val detectView = DetectView(this@DrawViewActivity, index).apply {
                listener = object : DetectView.Listener {
                    override fun onClick() {
                        select(position)
                    }
                }
            }
            listDetectView.add(detectView)
            binding.root.addView(detectView)
            detectView.updateLayoutParams<ViewGroup.LayoutParams> {
                detectView.x = detectData.left
                detectView.y = detectData.top
                width = (detectData.right - detectData.left).toInt()
                height = (detectData.bottom - detectData.top).toInt()
            }
        }
    }

    private fun select(position: Int) {
        listDetectView.forEachIndexed { index, detectView ->
            detectView.select(position == index)
        }
    }

}