package es.mnceleiro.pmdm.listagot.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import es.mnceleiro.pmdm.listagot.R
import es.mnceleiro.pmdm.listagot.databinding.ActivityCharacterDetailBinding
import es.mnceleiro.pmdm.listagot.model.dao.GotCharacterDao
import es.mnceleiro.pmdm.listagot.model.dao.GotCharacterMockDaoImpl
import es.mnceleiro.pmdm.listagot.model.entities.GotCharacter

class CharacterCreateActivity : ExtendedActivity() {

    // Fields
    private lateinit var binding: ActivityCharacterDetailBinding
    private lateinit var characterDao: GotCharacterDao

    // Methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        characterDao = GotCharacterMockDaoImpl()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_character_create, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_save) {
            createNewCharacter()

        }

        return super.onOptionsItemSelected(item)
    }

    private fun createNewCharacter() {
        /* Forma I (estilo Java) */
        // createNewCharacterJavaFriendlySyntax()

        /* Forma II (con ayuda de funciones de Kotlin) */
        createNewCharacterWithKotlinFunctions()
    }

    private fun createNewCharacterJavaFriendlySyntax() {
        val character = GotCharacter(
            binding.etCharacterFirstname.text.toString(),
            binding.etCharacterLastname.text.toString(),
            binding.etCharacterHouse.text.toString(),
            binding.etCharacterTitle.text.toString(),
            binding.etCharacterFamily.text.toString()
        )

        characterDao.add(character)
    }

    private fun createNewCharacterWithKotlinFunctions() {
        characterDao.add(binding.run {
            GotCharacter(
                etCharacterFirstname.text.toString(),
                etCharacterLastname.text.toString(),
                etCharacterHouse.text.toString(),
                etCharacterTitle.text.toString(),
                etCharacterFamily.text.toString()
            )
        })
    }


}