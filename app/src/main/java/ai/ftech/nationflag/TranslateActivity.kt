package ai.ftech.nationflag

import ai.ftech.nationflag.databinding.ActivityTranslateBinding
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class TranslateActivity : AppCompatActivity() {
    companion object {
        const val DATA = "DATA"
    }

    private lateinit var binding: ActivityTranslateBinding


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTranslateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = intent.getSerializableExtra(DATA) as NationFlag
        with(binding) {
            val url = "https://translate.google.com.vn/?sl=vi&tl=en&text=" + data.nameVi + "&op=translate"
            wvTranslate.settings.javaScriptEnabled = true
            wvTranslate.loadUrl(url)
        }

    }
}