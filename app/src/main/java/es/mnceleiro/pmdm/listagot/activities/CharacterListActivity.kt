package es.mnceleiro.pmdm.listagot.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DividerItemDecoration
import es.mnceleiro.pmdm.listagot.R
import es.mnceleiro.pmdm.listagot.model.dao.GotCharacterDaoImpl
import es.mnceleiro.pmdm.listagot.adapters.CharacterListAdapter
import es.mnceleiro.pmdm.listagot.databinding.ActivityCharacterListBinding


class CharacterListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View binding
        binding = ActivityCharacterListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the ActionBar title to "GOT Characters"
        title = "GOT Characters"

        val characterGotList = GotCharacterDaoImpl().getAll()

        // Create RecyclerView related objects
        val rvCharacterList: RecyclerView = binding.rvCharacterList
        val layoutManager = LinearLayoutManager(this)
        val adapter = CharacterListAdapter(characterGotList)
        val dividerItemDecoration = DividerItemDecoration(rvCharacterList.context, layoutManager.orientation)

        // Assign all objects to the RecyclerView
        rvCharacterList.adapter = adapter
        rvCharacterList.layoutManager = layoutManager
        rvCharacterList.addItemDecoration(dividerItemDecoration)

        // Listeners
        binding.btnCharacterAdd.setOnClickListener {
            val intent = Intent(this, CharacterDetailActivity::class.java)
            startActivity(intent)
        }
    }
}