package es.mnceleiro.pmdm.listagot.model.dao

import es.mnceleiro.pmdm.listagot.model.entities.GotCharacter

interface GotCharacterDao {
    fun getAll(): MutableList<GotCharacter>

    fun add(c: GotCharacter)

    fun update(c: GotCharacter)

    fun remove(id: Long)
}