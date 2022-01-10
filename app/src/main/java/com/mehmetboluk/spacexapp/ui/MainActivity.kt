package com.mehmetboluk.spacexapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.mehmetboluk.spacexapp.R
import com.mehmetboluk.spacexapp.databinding.ActivityMainBinding
import com.mehmetboluk.spacexapp.ui.fragment.CustomDialogFragment
import com.mehmetboluk.spacexapp.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()
    val year = MutableLiveData<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        navHostFragment.findNavController()
            .addOnDestinationChangedListener {_, destination, _ ->
                when(destination.id) {
                    R.id.detailFragment ->
                        menu.findItem(R.id.imFilter).setVisible(false)
                    R.id.homeFragment ->
                        menu.findItem(R.id.imFilter).setVisible(true)
                }
            }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val dialog = CustomDialogFragment()
        dialog.show(supportFragmentManager, "customDialog")
        return super.onOptionsItemSelected(item)
    }



}