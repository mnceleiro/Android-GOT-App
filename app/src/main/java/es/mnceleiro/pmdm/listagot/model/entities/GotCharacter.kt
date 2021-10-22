package es.mnceleiro.pmdm.listagot.model.entities

data class GotCharacter(
    var id: Long,
    var firstName: String,
    var lastName: String,
    var title: String,
    var family: String,
    var url: String = ""
) {
    fun getFullName() = "${this.firstName} ${this.lastName}"
}
