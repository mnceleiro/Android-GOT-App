package es.mnceleiro.pmdm.listagot

import android.media.CamcorderProfile.getAll
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.mnceleiro.pmdm.listagot.databinding.ActivityMainBinding
import es.mnceleiro.pmdm.listagot.model.dao.GotCharacterDaoImpl
import androidx.recyclerview.widget.DividerItemDecoration




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "GOT Characters"

        val rvCharacterList: RecyclerView = binding.rvCharacterList
        val layoutManager = LinearLayoutManager(this)
        val adapter = CharacterListAdapter(GotCharacterDaoImpl().getAll())
        val dividerItemDecoration = DividerItemDecoration(rvCharacterList.context, layoutManager.orientation)

        rvCharacterList.adapter = adapter
        rvCharacterList.layoutManager = layoutManager
        rvCharacterList.addItemDecoration(dividerItemDecoration)
    }
}