package com.example.notesdemo

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.example.notesdemo.databinding.ActivityMainBinding
import com.example.notesdemo.databinding.FragmentHomeBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val menuInflater = menuInflater
//        menuInflater.inflate(R.menu.add_note, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//    }


}