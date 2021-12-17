package es.mnceleiro.pmdm.listagot.model.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GotCharacter(
    var firstName: String,
    var lastName: String,
    var title: String,
    var family: String,
    @SerializedName("imageUrl") var url: String = ""

) : Serializable {

    var id: Long = 0

    constructor(id: Long, firstName: String, lastName: String, title: String, family: String, house: String, url: String = "")
            : this(firstName, lastName, title, family, url) {
        this.id = id
    }

    fun getFullName() = "${this.firstName} ${this.lastName}"
}
