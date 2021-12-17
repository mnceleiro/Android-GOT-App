package es.mnceleiro.pmdm.listagot.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.mnceleiro.pmdm.listagot.R
import es.mnceleiro.pmdm.listagot.adapters.CharacterListAdapter
import es.mnceleiro.pmdm.listagot.databinding.ActivityCharacterListBinding
import es.mnceleiro.pmdm.listagot.model.dao.GotCharacterDao
import es.mnceleiro.pmdm.listagot.model.dao.mock.GotCharacterMockDaoImpl
import es.mnceleiro.pmdm.listagot.model.dao.restapi.GotCharacterRestApiDaoImpl
import es.mnceleiro.pmdm.listagot.model.dao.restapi.RetrofitClient
import es.mnceleiro.pmdm.listagot.model.entities.GotCharacter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CharacterListActivity : AppCompatActivity() {

    private lateinit var adapter: CharacterListAdapter
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
        val dividerItemDecoration = DividerItemDecoration(rvCharacterList.context, layoutManager.orientation)

        // Assign all objects to the RecyclerView
        rvCharacterList.addItemDecoration(dividerItemDecoration)
        rvCharacterList.layoutManager = layoutManager

        // Listeners
        binding.btnCharacterAdd.setOnClickListener {
            val intent = Intent(this, CharacterCreateActivity::class.java)
            startActivity(intent)
        }

        val call: Call<List<GotCharacter>> = RetrofitClient.retrofitService.getAllCharacters()
        call.enqueue(object: Callback<List<GotCharacter>> {
            override fun onResponse(p0: Call<List<GotCharacter>>, p1: Response<List<GotCharacter>>) {
                Log.d("RETROFIT", "RETROFIT")
                characterList = p1.body() as MutableList<GotCharacter>
                adapter = CharacterListAdapter(characterList)
                rvCharacterList.adapter = adapter
            }

            override fun onFailure(p0: Call<List<GotCharacter>>, p1: Throwable) {
                Log.e("RETROFIT", p1.stackTraceToString())
            }
        })

    }

    override fun onResume() {
        super.onResume()

        // If no elements in the list, hide the recyclerview and show a message
        showLayoutOnTheScreen()
    }

    private fun showLayoutOnTheScreen() {
        if (characterList.size == 0) showLayoutNoElements()
        else showLayoutWithElements()
    }

    private fun showLayoutWithElements() {
        binding.layoutCharacterEmptyList.visibility = View.GONE
        binding.rvCharacterList.visibility = View.VISIBLE
    }

    private fun showLayoutNoElements() {
        binding.layoutCharacterEmptyList.visibility = View.VISIBLE
        binding.rvCharacterList.visibility = View.GONE
    }
}