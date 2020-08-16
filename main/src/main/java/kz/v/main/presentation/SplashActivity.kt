package kz.v.main.presentation

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kz.v.main.presentation.ui.MainActivity
import timber.log.Timber

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.i("onCreate")
        super.onCreate(savedInstanceState)
        navigateToMainScreen()
    }

    private fun navigateToMainScreen() {
        Timber.i("navigateToMainScreen")
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
//            AuthActivity.newIntent(context = applicationContext)
            finish()
        }, 1000.toLong())
    }
}