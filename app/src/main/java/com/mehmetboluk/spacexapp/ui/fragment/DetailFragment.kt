package com.mehmetboluk.spacexapp.ui.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.mehmetboluk.spacexapp.R
import com.mehmetboluk.spacexapp.databinding.FragmentDetailBinding
import com.mehmetboluk.spacexapp.service.model.LaunchModelItem


class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            with(it.get("item") as LaunchModelItem){
                Glide.with(this@DetailFragment).load(this.links.mission_patch).into(binding.imageView)
                binding.tvMissionNameDetail.text = this.mission_name
                binding.tvDateDetail.text = this.launch_year
                binding.tvRocketNameDetail.text = this.rocket.rocket_name
                binding.tvLaunchSite.text = this.launch_site.site_name_long
                binding.tvLinkArticle.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(this.links.article_link.toString()))
                    startActivity(intent)
                }
                binding.tvDetails.text = "Detail: ${this.details}"
            }
        }


    }

}