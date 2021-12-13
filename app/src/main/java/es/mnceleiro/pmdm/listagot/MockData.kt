package es.mnceleiro.pmdm.listagot

import es.mnceleiro.pmdm.listagot.model.entities.GotCharacter
import java.util.*
import kotlin.collections.ArrayList

object MockData {

    lateinit var characterList: MutableList<GotCharacter>

    fun fillMockData() {
        // Relleno la lista con datos mock (si prefieres, puedes hacer la lista con ArrayList en lugar de MutableList, mas familiar con Java)
        characterList = mutableListOf(
            GotCharacter(1, "Daenerys", "Targaryen", "Targaryen", "Mother of Dragons", "House Targaryen", "https://thronesapi.com/assets/images/daenerys.jpg"),
            GotCharacter(2,"Samwell", "Tarly", "Tarly", "Maester", "House Tarly", "https://thronesapi.com/assets/images/sam.jpg"),
            GotCharacter(3,"Arya", "Stark", "Stark", "No One", "House Stark", "https://thronesapi.com/assets/images/arya-stark.jpg"),
            GotCharacter(4,"Brienne", "Tarth", "Tarth", "Briene of Tarth", "Tarth", "https://thronesapi.com/assets/images/brienne-tarth.jpeg")
        )
    }
}