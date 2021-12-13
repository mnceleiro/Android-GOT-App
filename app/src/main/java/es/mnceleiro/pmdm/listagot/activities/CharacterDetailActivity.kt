package es.mnceleiro.pmdm.listagot.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import es.mnceleiro.pmdm.listagot.R
import es.mnceleiro.pmdm.listagot.databinding.ActivityCharacterDetailBinding

class CharacterDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_character_detail, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                Toast.makeText(this, getString(R.string.message_character_created_success), Toast.LENGTH_SHORT).show()
                finish()
                true
            }

            R.id.action_delete -> {
                val builder = AlertDialog.Builder(this)

                builder.setTitle(getString(R.string.message_character_delete))
                    .setMessage(getString(R.string.message_prompt_character_will_be_deleted))
                    .setPositiveButton(getString(R.string.action_ok)) { _, _ ->
                        Toast.makeText(this, getString(R.string.message_character_deleted), Toast.LENGTH_SHORT).show()
                        finish()
                    }.setNegativeButton(getString(R.string.action_cancel), null)
                    .show()

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}