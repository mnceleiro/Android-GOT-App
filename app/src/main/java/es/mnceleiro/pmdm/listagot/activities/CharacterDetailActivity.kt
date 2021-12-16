package es.mnceleiro.pmdm.listagot.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import es.mnceleiro.pmdm.listagot.R
import es.mnceleiro.pmdm.listagot.databinding.ActivityCharacterDetailBinding
import es.mnceleiro.pmdm.listagot.model.dao.GotCharacterDao
import es.mnceleiro.pmdm.listagot.model.dao.mock.GotCharacterMockDaoImpl
import es.mnceleiro.pmdm.listagot.model.entities.GotCharacter
import android.content.Intent
import android.net.Uri
import android.view.View

// TODO: refactorizar en una activity padre abstracta
// TODO: refactorizar onbackpressed
class CharacterDetailActivity : AppCompatActivity() {

    companion object {
        const val BUNDLE_DATA_CHARACTER = "character"
    }

    private lateinit var binding: ActivityCharacterDetailBinding
    private var activityMenu: Menu? = null
    private lateinit var characterDao: GotCharacterDao

    private lateinit var character: GotCharacter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        characterDao = GotCharacterMockDaoImpl()
        character = intent.getSerializableExtra(BUNDLE_DATA_CHARACTER) as GotCharacter

        // Show the data in the screen
        title = character.getFullName()
        setContentNonEditable()
        fillCharacterData()

        binding.btnSearchImageUrl.setOnClickListener {
            val url = "https://www.google.com/search?q=game+of+thrones+character&tbm=isch&oq=game+of+thrones+character&bih=955"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
    }

    private fun fillCharacterData() {
        binding.run {
            etCharacterFirstname.setText(character.firstName)
            etCharacterLastname.setText(character.lastName)
            etCharacterTitle.setText(character.title)
            etCharacterFamily.setText(character.family)
            etCharacterUrl.setText(character.url)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_character_detail, menu)
        activityMenu = menu

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.action_edit -> {
                setContentEditable()
                true
            }

            R.id.action_update -> {
                val character = GotCharacter(
                    character.id,
                    binding.etCharacterFirstname.text.toString(),
                    binding.etCharacterLastname.text.toString(),
                    binding.etCharacterHouse.text.toString(),
                    binding.etCharacterTitle.text.toString(),
                    binding.etCharacterFamily.text.toString(),
                    binding.etCharacterUrl.text.toString()
                )

                characterDao.update(character)

                Toast.makeText(this, getString(R.string.message_character_updated_success), Toast.LENGTH_SHORT).show()
                finish()
                true
            }

            R.id.action_cancel -> {
                setContentNonEditable()

                // Undo changes (fill old character data in the textfields)
                fillCharacterData()
                true
            }

            R.id.action_delete -> {
                val builder = AlertDialog.Builder(this)

                builder.setTitle(getString(R.string.message_character_delete))
                    .setMessage(getString(R.string.message_prompt_character_will_be_deleted))
                    .setPositiveButton(getString(R.string.action_ok)) { _, _ ->
                        characterDao.remove(character.id)
                        Toast.makeText(this, getString(R.string.message_character_deleted), Toast.LENGTH_SHORT).show()
                        finish()
                    }.setNegativeButton(getString(R.string.action_cancel), null)
                    .show()

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setContentEditable() {
        activityMenu?.apply {
            findItem(R.id.action_edit).isVisible = false
            findItem(R.id.action_delete).isVisible = false
            findItem(R.id.action_update).isVisible = true
            findItem(R.id.action_cancel).isVisible = true
        }

        binding.apply {
            etCharacterFirstname.isEnabled = true
            etCharacterLastname.isEnabled = true
            etCharacterFamily.isEnabled = true
            etCharacterHouse.isEnabled = true
            etCharacterTitle.isEnabled = true
            etCharacterUrl.isEnabled = true
            btnSearchImageUrl.visibility = View.VISIBLE
        }
    }

    private fun setContentNonEditable() {
        activityMenu?.apply {
            findItem(R.id.action_edit).isVisible = true
            findItem(R.id.action_delete).isVisible = true
            findItem(R.id.action_update).isVisible = false
            findItem(R.id.action_cancel).isVisible = false
        }

        binding.apply {
            etCharacterFirstname.isEnabled = false
            etCharacterLastname.isEnabled = false
            etCharacterFamily.isEnabled = false
            etCharacterHouse.isEnabled = false
            etCharacterTitle.isEnabled = false
            etCharacterUrl.isEnabled = false
            btnSearchImageUrl.visibility = View.GONE
        }
    }
}