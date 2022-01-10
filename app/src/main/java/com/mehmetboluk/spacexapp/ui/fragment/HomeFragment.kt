package com.mehmetboluk.spacexapp.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.mehmetboluk.spacexapp.R
import com.mehmetboluk.spacexapp.adapter.SpaceXAdapter
import com.mehmetboluk.spacexapp.databinding.FragmentHomeBinding
import com.mehmetboluk.spacexapp.ui.MainActivity
import com.mehmetboluk.spacexapp.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var spaceXAdapter: SpaceXAdapter
    private val viewModel : MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        viewModel.makeApiCallFilter()
        viewModel.apiResponse.observe(requireActivity(), Observer {
            Timber.tag("response").e(it.toString())
            if (it.isEmpty()){
                Snackbar.make(view, "There is any launch in this year", Snackbar.LENGTH_LONG).show()
                Toast.makeText(requireContext(), "There is any launch in this year", Toast.LENGTH_LONG).show()
            }
            spaceXAdapter.submitList(it)
            Handler().postDelayed({
                binding.rvSpacexRecycler.scrollToPosition(0)
            }, 1)
            binding.progressBar.visibility = View.GONE
            binding.tvPlease.visibility = View.GONE
        })

        (activity as MainActivity).year.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it == ""){
                    viewModel.makeApiCallFilter()
                }else{
                    viewModel.makeApiCallFilter(it.toInt())
                }
            }
            Timber.tag("year").d(it.toString())
        })


    }

    private fun setupRecyclerView() = binding.rvSpacexRecycler.apply {
        spaceXAdapter = SpaceXAdapter()
        adapter = spaceXAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }
}