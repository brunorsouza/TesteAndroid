package me.brunorsouza.testesantander.base

import android.app.ProgressDialog
import android.support.v4.app.Fragment
import me.brunorsouza.testesantander.R

abstract class BaseFragment: Fragment(), BaseView {

    private var progressDialog: ProgressDialog? = null

    override fun showLoading() {
        dismissLoading()
        progressDialog = ProgressDialog(context, ProgressDialog.THEME_DEVICE_DEFAULT_LIGHT)
        progressDialog?.setMessage(getString(R.string.loading))
        progressDialog?.setCancelable(false)

        progressDialog?.show()
    }

    override fun dismissLoading() {
        if (progressDialog != null && progressDialog!!.isShowing) {
            progressDialog?.dismiss()
        }
    }

    override fun showError(show : Boolean) {

    }

}