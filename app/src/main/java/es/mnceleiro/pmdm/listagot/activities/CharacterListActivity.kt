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
import es.mnceleiro.pmdm.listagot.listeners.OnItemClickListener
import es.mnceleiro.pmdm.listagot.model.dao.GotCharacterDao
import es.mnceleiro.pmdm.listagot.model.dao.mock.GotCharacterMockDaoImpl
import es.mnceleiro.pmdm.listagot.model.dao.restapi.GotCharacterRestApiDaoImpl
import es.mnceleiro.pmdm.listagot.model.dao.restapi.RetrofitClient
import es.mnceleiro.pmdm.listagot.model.entities.GotCharacter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CharacterListActivity : ExtendedActivity(), OnItemClickListener {

    private lateinit var adapter: CharacterListAdapter
    private lateinit var binding: ActivityCharacterListBinding
    private var characterList: List<GotCharacter> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View binding
        binding = ActivityCharacterListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the ActionBar title to "GOT Characters"
        title = getString(R.string.label_character_list)

        // Create RecyclerView related objects
        setUpRecyclerView()

        // Listeners
        binding.btnCharacterAdd.setOnClickListener {
            val intent = Intent(this, CharacterCreateActivity::class.java)
            startActivity(intent)
        }

        // Async call to get the characters
        val call: Call<List<GotCharacter>> = RetrofitClient.retrofitService.getAllCharacters()
        call.enqueue(object: Callback<List<GotCharacter>> {
            override fun onResponse(p0: Call<List<GotCharacter>>, p1: Response<List<GotCharacter>>) {
                characterList = p1.body()!!
                adapter.setData(characterList)

                showLayoutOnTheScreen()

                adapter.notifyItemRangeInserted(0, characterList.size)
            }

            override fun onFailure(p0: Call<List<GotCharacter>>, p1: Throwable) {
                Log.e(TAG_ACTIVITY_MAIN, p1.stackTraceToString())
                showErrorLoadingCharacters()

                showLayoutOnTheScreen()
            }

            private fun showErrorLoadingCharacters() = guiUtils.showBasicMessageDialog(getString(
                R.string.message_error_loading_characters),
                getString(R.string.title_error_loading_characters
            ))
        })
    }

    override fun onResume() {
        super.onResume()

        // TODO: fix
        // If no elements in the list, hide the recyclerview and show a message
        //showLayoutOnTheScreen()
    }

    private fun setUpRecyclerView() {
        val rvCharacterList: RecyclerView = binding.rvCharacterList
        val layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(rvCharacterList.context, layoutManager.orientation)
        adapter = CharacterListAdapter(characterList, this@CharacterListActivity)

        // Assign all objects to the RecyclerView
        rvCharacterList.addItemDecoration(dividerItemDecoration)
        rvCharacterList.layoutManager = layoutManager
        rvCharacterList.adapter = adapter
    }

    private fun showLayoutOnTheScreen() {
        if (characterList.isEmpty()) showLayoutNoElements()
        else showLayoutWithElements()
    }

    private fun showLayoutWithElements() {
        binding.layoutCharacterEmptyList.visibility = View.GONE
        binding.rvCharacterList.visibility = View.VISIBLE
        binding.layoutCharacterLoadingScreen.visibility = View.GONE
    }

    private fun showLayoutNoElements() {
        binding.layoutCharacterEmptyList.visibility = View.VISIBLE
        binding.rvCharacterList.visibility = View.GONE
        binding.layoutCharacterLoadingScreen.visibility = View.GONE
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, CharacterDetailActivity::class.java)
        intent.putExtra(CharacterDetailActivity.BUNDLE_DATA_CHARACTER, characterList[position])
        startActivity(intent)
    }

    override fun onItemLongClick(position: Int) {}
}