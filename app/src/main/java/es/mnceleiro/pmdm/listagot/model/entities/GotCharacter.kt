package es.mnceleiro.pmdm.listagot.model.entities

data class GotCharacter(
    var firstName: String,
    var lastName: String,
    var title: String,
    var family: String,
    var house: String,
    var url: String = ""
) {
    var id: Long = 0

    constructor(id: Long, firstName: String, lastName: String, title: String, family: String, house: String, url: String = "")
            : this(firstName, lastName, title, family, house, url) {
        this.id = id
    }

    fun getFullName() = "${this.firstName} ${this.lastName}"
}
