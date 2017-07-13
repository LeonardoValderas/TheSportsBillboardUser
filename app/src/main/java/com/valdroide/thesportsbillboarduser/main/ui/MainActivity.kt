package com.valdroide.thesportsbillboarduser.main.ui

import android.app.Application
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.valdroide.thesportsbillboarduser.R
import com.valdroide.thesportsbillboarduser.TheSportsBillboardUserApp
import com.valdroide.thesportsbillboarduser.main.MainActivityPresenter
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainActivityView {

    @BindView(R.id.conteiner)
    internal var conteiner: ConstraintLayout? = null
    @Inject
    lateinit var presenter : MainActivityPresenter

//    init {
//        val app = application as (TheSportsBillboardUserApp) getA
//        app!!.getMainActivityComponent(this,this).inject(this)
//      //  GmailApplication.apiComponent.inject(this)
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        setupInjection();
        presenter.onRegister()
        presenter.success(false)
    }

    override fun setError(error: String) {
        Snackbar.make(findViewById(R.id.conteiner), error, Snackbar.LENGTH_LONG).show()
    }

    override fun success() {
        Snackbar.make(findViewById(R.id.conteiner), "Es sucessss", Snackbar.LENGTH_LONG).show()
    }

    fun setupInjection() {
        val app = application as TheSportsBillboardUserApp
        app.getMainActivityComponent(this,this).inject(this)
    }

    override fun onDestroy() {
        presenter.onUnRegister()
        super.onDestroy()
    }
}
