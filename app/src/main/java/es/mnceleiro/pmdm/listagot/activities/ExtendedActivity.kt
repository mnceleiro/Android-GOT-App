package es.mnceleiro.pmdm.listagot.activities

import androidx.appcompat.app.AppCompatActivity
import es.mnceleiro.pmdm.listagot.utils.GuiUtils

abstract class ExtendedActivity : AppCompatActivity() {

    protected val guiUtils: GuiUtils by lazy { GuiUtils.initialize(this) }

    companion object {
        lateinit var TAG_ACTIVITY_MAIN: String
    }

    init {
        TAG_ACTIVITY_MAIN = this::class.java.simpleName
    }
}