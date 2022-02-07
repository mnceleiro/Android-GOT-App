package es.mnceleiro.pmdm.listagot.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import es.mnceleiro.pmdm.listagot.R
import es.mnceleiro.pmdm.listagot.activities.CharacterDetailActivity
import es.mnceleiro.pmdm.listagot.databinding.ItemCharacterListBinding
import es.mnceleiro.pmdm.listagot.listeners.OnItemClickListener
import es.mnceleiro.pmdm.listagot.model.entities.GotCharacter

class CharacterListAdapter(
    private var characterList: List<GotCharacter>,
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<CharacterListAdapter.GotCharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GotCharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCharacterListBinding.inflate(layoutInflater, parent, false)

        return GotCharacterViewHolder(binding, onItemClickListener)
    }

    override fun onBindViewHolder(holder: GotCharacterViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount(): Int = characterList.size

    class GotCharacterViewHolder(
        private val itemBinding: ItemCharacterListBinding,
        private val onItemClickListener: OnItemClickListener
    ) : ViewHolder(itemBinding.root) {

        fun bind(character: GotCharacter) {
            itemBinding.tvCharacterName.text = character.getFullName()
            itemBinding.tvCharacterFamily.text = character.family
            itemBinding.tvCharacterTitle.text = character.title

            showImageFromUrl(character.url)

            itemBinding.root.setOnClickListener {
                onItemClickListener.onItemClick(adapterPosition)
            }
        }

        private fun showImageFromUrl(url: String) {
            try {
                Picasso.get().isLoggingEnabled = true
                Picasso.get().load(url)
                    .placeholder(R.drawable.ic_baseline_downloading_48)     // placeholder while downloading the real image from the internet
                    .into(itemBinding.ivCharacter)

            } catch (e: Exception) {
                itemBinding.ivCharacter.setImageDrawable(AppCompatResources.getDrawable(
                        itemBinding.root.context,
                        R.drawable.ic_baseline_image_not_supported_24
                ))
            }
        }
    }
}