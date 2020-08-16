package kz.v.main.presentation.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import kz.v.main.R
import kz.v.ui_components.base.BaseActivity
import timber.log.Timber

class MainActivity : BaseActivity(R.layout.activity_main) {

    companion object {
        fun newIntent(context: Context?) = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        Timber.i("onCreate")
        super.onCreate(savedInstanceState, persistentState)
    }
}