package es.mnceleiro.pmdm.listagot.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog
import es.mnceleiro.pmdm.listagot.R

class AlertDialogUtils(val context: Context) {

    fun showBasicMessageDialog(message: String, title: String = "") {
        val builder = AlertDialog.Builder(context)

        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton(R.string.action_ok, null)

        val dialog = builder.create()
        dialog.show()
    }
}