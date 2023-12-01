package com.example.advancednavigation

import android.icu.text.CaseMap.Title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.advancednavigation.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val appBarConfiguration: AppBarConfiguration by lazy {
        AppBarConfiguration(navController.graph, binding.drawerLayout)
    }

    private val navHostFragment: NavHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
    }

    private val navController: NavController by lazy {
        navHostFragment.navController
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setBottomNavigation()
//        setNavigationMenu()


        binding.apply {
            setSupportActionBar(toolBar)
            navView.bringToFront()
            navView.setupWithNavController(navController)
        }

        setupActionBarWithNavController(navController, appBarConfiguration)


    }


        private fun setBottomNavigation() {
            binding.bottomNavMenu.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.nav_home -> navController.navigate(R.id.homeFragment)
                    R.id.nav_screen -> navController.navigate(R.id.screenDFragment)
                }
                true
            }
        }

    private fun setNavigationMenu() {

        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_fragmentA -> navController.navigate(R.id.settingsAFragment) 
                R.id.nav_fragmentC -> navController.navigate(R.id.settingsCFragment)
            }
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController=findNavController(R.id.fragmentContainerView)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onStart() {
        super.onStart()
        setNavigationMenu()

    }





}
