package com.example.notesdemo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesdemo.databinding.ItemNoteBinding
import com.example.notesdemo.ui.model.Note


class NoteRecyclerAdapter(val onItemClicked: ((Note) -> Unit)?) :
    RecyclerView.Adapter<NoteRecyclerAdapter.RecyclerViewHolder>() {

    private var noteList: List<Note> = emptyList()

    class RecyclerViewHolder(
        private val binding: ItemNoteBinding,
        private val onItemClicked: ((Note) -> Unit)? = null,
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            with(note) {
                binding.apply {

                    titleTv.text = title

                    root.setOnClickListener{
                        onItemClicked?.invoke(note)
                    }
                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return RecyclerViewHolder(
            ItemNoteBinding.inflate(inflater, parent, false),
            onItemClicked
        )
    }

    override fun getItemCount() = noteList.size


    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(noteList[position])
    }


    fun submitList(list: List<Note>) {
        noteList = list
        notifyDataSetChanged()
    }
}