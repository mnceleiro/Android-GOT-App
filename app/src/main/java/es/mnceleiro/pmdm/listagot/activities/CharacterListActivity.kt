package es.mnceleiro.pmdm.listagot.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.mnceleiro.pmdm.listagot.App
import es.mnceleiro.pmdm.listagot.R
import es.mnceleiro.pmdm.listagot.adapters.CharacterListAdapter
import es.mnceleiro.pmdm.listagot.databinding.ActivityCharacterListBinding
import es.mnceleiro.pmdm.listagot.model.dao.GotCharacterDao
import es.mnceleiro.pmdm.listagot.model.dao.GotCharacterMockDaoImpl
import es.mnceleiro.pmdm.listagot.model.entities.GotCharacter


class CharacterListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterListBinding
    private lateinit var characterList: MutableList<GotCharacter>
    private lateinit var characterDao: GotCharacterDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View binding
        binding = ActivityCharacterListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the ActionBar title to "GOT Characters"
        title = getString(R.string.label_character_list)

        // Get the data from the mock database
        characterDao = GotCharacterMockDaoImpl()
        characterList = characterDao.getAll()

        // Create RecyclerView related objects
        val rvCharacterList: RecyclerView = binding.rvCharacterList
        val layoutManager = LinearLayoutManager(this)
        val adapter = CharacterListAdapter(characterList)
        val dividerItemDecoration = DividerItemDecoration(rvCharacterList.context, layoutManager.orientation)

        // Assign all objects to the RecyclerView
        rvCharacterList.adapter = adapter
        rvCharacterList.layoutManager = layoutManager
        rvCharacterList.addItemDecoration(dividerItemDecoration)

        // Listeners
        binding.btnCharacterAdd.setOnClickListener {
            val intent = Intent(this, CharacterCreateActivity::class.java)
            startActivity(intent)
        }
    }
}