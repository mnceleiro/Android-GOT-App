package es.mnceleiro.pmdm.listagot.model.dao

import es.mnceleiro.pmdm.listagot.model.entities.GotCharacter

interface GotCharacterDao {
    fun getAll(): List<GotCharacter>
}