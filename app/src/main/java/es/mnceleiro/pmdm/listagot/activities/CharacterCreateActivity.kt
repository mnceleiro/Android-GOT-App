package es.mnceleiro.pmdm.listagot.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import es.mnceleiro.pmdm.listagot.R
import es.mnceleiro.pmdm.listagot.databinding.ActivityCharacterDetailBinding
import es.mnceleiro.pmdm.listagot.model.dao.GotCharacterDao
import es.mnceleiro.pmdm.listagot.model.dao.mock.GotCharacterMockDaoImpl
import es.mnceleiro.pmdm.listagot.model.entities.GotCharacter

// TODO: refactorizar en una activity padre abstracta
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

        binding.btnSearchImageUrl.setOnClickListener {
            val url = "https://www.google.com/search?q=game+of+thrones+character&tbm=isch&oq=game+of+thrones+character&bih=955"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_character_create, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_save) {
            createNewCharacter()
            guiUtils.showToast(R.string.message_character_created_success)
            finish()
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
            binding.etCharacterTitle.text.toString(),
            binding.etCharacterFamily.text.toString(),
            binding.etCharacterUrl.text.toString()
        )

        characterDao.add(character)
    }

    private fun createNewCharacterWithKotlinFunctions() {
        characterDao.add(binding.run {
            GotCharacter(
                etCharacterFirstname.text.toString(),
                etCharacterLastname.text.toString(),
                etCharacterTitle.text.toString(),
                etCharacterFamily.text.toString(),
                etCharacterUrl.text.toString()
            )
        })
    }
}