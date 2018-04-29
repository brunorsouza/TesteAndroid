package me.brunorsouza.testesantander.base

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import me.brunorsouza.testesantander.R
import me.brunorsouza.testesantander.contact.ContactFragment
import me.brunorsouza.testesantander.investment.InvestmentFragment

class PageAdapter(fragmentManager: FragmentManager, private val context: Context):
        FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment? {
        return when(position) {
            0 -> InvestmentFragment()
            else -> ContactFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> context.getString(R.string.investment)
            else -> context.getString(R.string.contact)
        }
    }
}