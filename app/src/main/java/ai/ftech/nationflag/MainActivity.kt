package ai.ftech.nationflag

import ai.ftech.nationflag.databinding.ActivityMainBinding
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset


class MainActivity : AppCompatActivity() {
    companion object {
        const val TIMI_PACKAGE = "ai.ftech.faceattendance"
        const val APP_TESTER_PACKAGE = "dev.firebase.appdistribution"
    }

    private lateinit var binding: ActivityMainBinding

    val adapter = NationFlagAdapter().apply {
        listener = object : NationFlagAdapter.ItemListener {
            override fun onClickItem(data: NationFlag) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.DATA, data.flag)
                startActivity(intent)
            }

            override fun onClickTranslate(data: NationFlag) {
                val intent = Intent(this@MainActivity, TranslateActivity::class.java)
                intent.putExtra(TranslateActivity.DATA, data)
                startActivity(intent)
            }

        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rcvData.layoutManager = GridLayoutManager(this@MainActivity, 3)
        binding.rcvData.adapter = adapter
        adapter.resetData(getListData())
    }

    private fun getListData(): List<NationFlag> {
        val result = mutableListOf<NationFlag>()
        val json = loadJSONFromAsset()
        json?.let {
            val type = object : TypeToken<List<NationFlag>>() {}.type
            result.addAll(Gson().fromJson<List<NationFlag>>(it, type))
        }
        return result
    }

    private fun loadJSONFromAsset(): String? {
        var json: String? = null
        json = try {
            val inputStream: InputStream = this.assets.open("nation.json")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}