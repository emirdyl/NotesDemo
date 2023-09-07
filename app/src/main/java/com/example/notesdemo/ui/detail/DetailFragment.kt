package com.example.notesdemo.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notesdemo.R
import com.example.notesdemo.databinding.FragmentAddNoteBinding
import com.example.notesdemo.databinding.FragmentDetailBinding
import com.example.notesdemo.databinding.FragmentHomeBinding
import com.example.notesdemo.ui.home.HomeFragmentDirections
import com.example.notesdemo.ui.home.HomeViewModel
import com.example.notesdemo.ui.model.Note


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    private val viewModel by viewModels<DetailViewModel>()

    private val args: DetailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi(args.note)
        binding.editButton.setOnClickListener {
            val direction= DetailFragmentDirections.actionDetailFragmentToAddNoteFragment(args.note)
            findNavController().navigate(direction)
        }
    }

    private fun setupUi(note: Note) {
        binding.detailTitleTv.text=note.title
        binding.detailDescTv.text=note.description

    }




}