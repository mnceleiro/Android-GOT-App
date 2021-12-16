package es.mnceleiro.pmdm.listagot

import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // Relleno la lista de personajes cuando se inicia la app
        MockData.fillMockData()
    }
}