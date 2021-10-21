package es.mnceleiro.pmdm.listagot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import es.mnceleiro.pmdm.listagot.databinding.ItemCharacterListBinding
import es.mnceleiro.pmdm.listagot.model.entities.GotCharacter
import java.lang.System.load

class CharacterListAdapter(var characterList: List<GotCharacter>) : RecyclerView.Adapter<CharacterListAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CharacterViewHolder(ItemCharacterListBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount(): Int = characterList.size

    class CharacterViewHolder(private val itemBinding: ItemCharacterListBinding) : ViewHolder(itemBinding.root) {
        fun bind(character: GotCharacter) {
            itemBinding.tvCharacterName.text = character.getFullName()
            itemBinding.tvCharacterFamily.text = character.family
            itemBinding.tvCharacterTitle.text = character.title
            Picasso.get().load(character.url).into(itemBinding.ivCharacter)
        }
    }
}