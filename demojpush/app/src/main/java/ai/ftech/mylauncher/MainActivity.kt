package ai.ftech.mylauncher

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ai.ftech.mylauncher.databinding.ActivityMainBinding
import android.os.Handler
import android.os.Looper


class MainActivity : AppCompatActivity() {
    companion object {
        const val TIMI_PACKAGE = "ai.ftech.faceattendance"
        const val APP_TESTER_PACKAGE = "dev.firebase.appdistribution"
    }

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivAppTester.setOnClickListener {
            openApp(APP_TESTER_PACKAGE)
        }
        binding.tvAppTester.setOnClickListener {
            openApp(APP_TESTER_PACKAGE)
        }
        binding.ivAppTimi.setOnClickListener {
            openApp(TIMI_PACKAGE)
        }
        binding.tvAppTimi.setOnClickListener {
            openApp(TIMI_PACKAGE)
        }

        Handler(Looper.getMainLooper()).postDelayed({
            openApp(TIMI_PACKAGE)
        }, 2000)
    }

    override fun onResume() {
        super.onResume()
    }

    private fun openApp(packageName: String) {
        try {
            val launchIntent = packageManager.getLaunchIntentForPackage(packageName)
            launchIntent?.let {
                launchIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                launchIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(launchIntent)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}