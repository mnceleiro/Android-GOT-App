package es.mnceleiro.pmdm.listagot

import android.app.Application
import es.mnceleiro.pmdm.listagot.model.dao.GotCharacterMockDaoImpl
import es.mnceleiro.pmdm.listagot.model.entities.GotCharacter

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // Relleno la lista de personajes cuando se inicia la app
        MockData.fillMockData()
    }
}