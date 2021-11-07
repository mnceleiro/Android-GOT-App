package es.mnceleiro.pmdm.listagot.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import es.mnceleiro.pmdm.listagot.activities.CharacterDetailActivity
import es.mnceleiro.pmdm.listagot.databinding.ItemCharacterListBinding
import es.mnceleiro.pmdm.listagot.model.entities.GotCharacter

class CharacterListAdapter(var characterList: List<GotCharacter>) : RecyclerView.Adapter<CharacterListAdapter.GotCharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GotCharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GotCharacterViewHolder(ItemCharacterListBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: GotCharacterViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount(): Int = characterList.size

    class GotCharacterViewHolder(private val itemBinding: ItemCharacterListBinding) : ViewHolder(itemBinding.root) {

        fun bind(character: GotCharacter) {
            itemBinding.tvCharacterName.text = character.getFullName()
            itemBinding.tvCharacterFamily.text = character.family
            itemBinding.tvCharacterTitle.text = character.title

            Picasso.get().load(character.url).into(itemBinding.ivCharacter)

            itemBinding.root.setOnClickListener {
                val intent = Intent(itemBinding.root.context, CharacterDetailActivity::class.java)

                itemBinding.root.context.startActivity(intent)
            }
        }
    }
}