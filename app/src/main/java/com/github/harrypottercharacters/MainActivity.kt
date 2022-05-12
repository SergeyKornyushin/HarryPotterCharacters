package com.github.harrypottercharacters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.github.harrypottercharacters.databinding.ActivityMainBinding
import com.github.harrypottercharacters.fragments.FavoritesFragment
import com.github.harrypottercharacters.fragments.FragmentSwitcher
import com.github.harrypottercharacters.fragments.SearchFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.fragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.favoritesFragment, R.id.searchFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.bottomNavView.setupWithNavController(navController)
    }
}