package es.mnceleiro.pmdm.listagot.model.dao

import es.mnceleiro.pmdm.listagot.model.entities.GotCharacter

class GotCharacterDaoImpl : GotCharacterDao {

    override fun getAll(): List<GotCharacter> {
        val gotCharacterList: List<GotCharacter> = listOf(
            GotCharacter(0,"Daenerys", "Targaryen", "Mother of Dragons", "House Targaryen", "https://thronesapi.com/assets/images/daenerys.jpg"),
            GotCharacter(0,"Samwell", "Tarly", "Maester", "House Tarly", "https://thronesapi.com/assets/images/sam.jpg"),
            GotCharacter(0,"Arya", "Stark", "No One", "House Stark", "https://thronesapi.com/assets/images/arya-stark.jpg"),
            GotCharacter(0,"Brienne", "Tarth", "Briene of Tarth", "Tarth", "https://thronesapi.com/assets/images/brienne-tarth.jpeg")
        )

        return gotCharacterList
    }
}