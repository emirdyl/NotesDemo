package com.example.notesdemo.ui.addnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notesdemo.R
import com.example.notesdemo.databinding.FragmentAddNoteBinding
import com.example.notesdemo.ui.model.Note


class AddNoteFragment : Fragment() {


    private lateinit var binding: FragmentAddNoteBinding

    private val viewModel by viewModels<AddNoteViewModel>()

    private val args: AddNoteFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModelEvents()
        setupUi(args.note)

    }

    private fun observeViewModelEvents() {
        viewModel.saveStateLiveData.observe(viewLifecycleOwner) { isSaved ->
            if (isSaved) {
                findNavController().navigate(R.id.action_addNoteFragment_to_homeFragment)
            } else {
                Toast.makeText(context, "Error Occurred", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun setupUi(note: Note?) {

        if (note != null) {
            binding.addTitle.setText(note.title)
            binding.addNote.setText(note.description)
            binding.saveButton.text = "Update"
            binding.saveButton.setOnClickListener {
                viewModel.updateNote(
                    note.id,
                    binding.addTitle.text.toString(),
                    binding.addNote.text.toString()
                )
            }
        } else {
            binding.saveButton.text = "Save"
            binding.saveButton.setOnClickListener {
                viewModel.saveNote(
                    binding.addTitle.text.toString(),
                    binding.addNote.text.toString()
                )
            }
        }
    }


}