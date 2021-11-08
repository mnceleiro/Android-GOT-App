package es.mnceleiro.pmdm.listagot.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DividerItemDecoration
import es.mnceleiro.pmdm.listagot.databinding.ActivityMainBinding
import es.mnceleiro.pmdm.listagot.model.dao.GotCharacterDaoImpl
import es.mnceleiro.pmdm.listagot.adapters.CharacterListAdapter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "GOT Characters"

        val characterGotList = GotCharacterDaoImpl().getAll()

        val rvCharacterList: RecyclerView = binding.rvCharacterList

        val layoutManager = LinearLayoutManager(this)

        val adapter = CharacterListAdapter(characterGotList)

        val dividerItemDecoration = DividerItemDecoration(
            rvCharacterList.context,
            layoutManager.orientation
        )

        rvCharacterList.addItemDecoration(dividerItemDecoration)

        rvCharacterList.adapter = adapter
        rvCharacterList.layoutManager = layoutManager
    }
}