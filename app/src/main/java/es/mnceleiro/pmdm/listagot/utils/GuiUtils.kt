package es.mnceleiro.pmdm.listagot.utils

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import es.mnceleiro.pmdm.listagot.R

class GuiUtils(val context: Context) {

    companion object {
        fun initialize(context: Context) = GuiUtils(context)
    }

    fun showBasicMessageDialog(message: String, title: String = "") {
        val builder = AlertDialog.Builder(context)

        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton(R.string.action_ok, null)

        val dialog = builder.create()
        dialog.show()
    }

    fun showToast(messageResource: Int) {
        Toast.makeText(context, messageResource, Toast.LENGTH_SHORT).show()
    }
}