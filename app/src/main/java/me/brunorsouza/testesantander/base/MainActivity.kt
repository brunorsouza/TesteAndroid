package me.brunorsouza.testesantander.base

import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import me.brunorsouza.testesantander.R

class MainActivity : AppCompatActivity() {

    val FIRST_TO_OPEN = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = Color.TRANSPARENT
        }

        setupViewPager()
        setupTabLayout()
    }

    private fun setupViewPager() {
        val adapterViewPager = PageAdapter(supportFragmentManager, this)
        viewPager.adapter = adapterViewPager
        viewPager.currentItem = FIRST_TO_OPEN
    }

    private fun setupTabLayout() {
        tabLayout.setupWithViewPager(viewPager)
    }
}
