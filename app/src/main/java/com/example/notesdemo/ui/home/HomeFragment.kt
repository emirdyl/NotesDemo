package com.example.notesdemo.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesdemo.R
import com.example.notesdemo.databinding.FragmentHomeBinding
import com.example.notesdemo.ui.adapter.NoteRecyclerAdapter


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private var adapter: NoteRecyclerAdapter? = null

    private val viewModel by viewModels<HomeViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        setRecyclerView()
        viewModel.getAllNotes()
        observeViewModelEvents()

        binding.addButton.setOnClickListener {
            val direction=HomeFragmentDirections.actionHomeFragmentToAddNoteFragment()
            findNavController().navigate(direction)
        }

        binding.addNewNote.setOnClickListener {
            val direction=HomeFragmentDirections.actionHomeFragmentToAddNoteFragment()
            findNavController().navigate(direction)
        }


    }

    private fun observeViewModelEvents() {

        viewModel.allNotesLiveData.observe(viewLifecycleOwner) { notList ->
            if (notList.isEmpty()) {
                binding.recyclerView.isVisible = false
                binding.linearLayout.isVisible = true


            } else {
                binding.recyclerView.isVisible = true
                binding.linearLayout.isVisible = false
                adapter?.submitList(notList)

            }
        }
    }

    private fun setRecyclerView() {
        adapter = NoteRecyclerAdapter{
            val direction = HomeFragmentDirections.actionHomeFragmentToDetailFragment(it)
            findNavController().navigate(direction)
        }
        binding.recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adapter
    }




}