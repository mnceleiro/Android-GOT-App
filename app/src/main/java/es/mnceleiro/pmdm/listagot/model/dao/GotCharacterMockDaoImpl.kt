package es.mnceleiro.pmdm.listagot.model.dao

import es.mnceleiro.pmdm.listagot.MockData
import es.mnceleiro.pmdm.listagot.model.entities.GotCharacter

class GotCharacterMockDaoImpl : GotCharacterDao {

    override fun getAll(): MutableList<GotCharacter> = MockData.characterList

    override fun add(c: GotCharacter) {
        val newId = generateNonUsedId()
        c.id = newId

        MockData.characterList.add(c)
    }

    override fun update(c: GotCharacter) {
        MockData.characterList.find { it.id == c.id }?.run {
            firstName = c.firstName
            family = c.family
            lastName = c.lastName
            title = c.title
            url = c.url
        }
    }

    override fun remove(id: Long) {
        MockData.characterList.removeAll { it.id == id }
    }

    private fun generateNonUsedId(): Long {
        var newId = 0L

        do {
            newId = generateRandomId()

        } while (MockData.characterList.find { it.id == newId } != null)

        return newId
    }


    private fun generateRandomId() = (0..Long.MAX_VALUE).random()
}