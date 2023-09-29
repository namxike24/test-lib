package ai.ftech.nationflag

import ai.ftech.nationflag.databinding.ActivityDetailBinding
import ai.ftech.nationflag.databinding.ActivityMainBinding
import ai.ftech.testlib.TestLibExample
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset


class DetailActivity : AppCompatActivity() {
    companion object {
        const val DATA = "DATA"
    }

    private lateinit var binding: ActivityDetailBinding


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = intent.getStringExtra(DATA)?:""
        with(binding){
            val imgId: Int = ai.ftech.nationflag.getApplication().resources.getIdentifier(data, "drawable", ai.ftech.nationflag.getApplication().packageName)
            ivFlag.setImageResource(imgId)
        }

        val test = TestLibExample()

    }
}