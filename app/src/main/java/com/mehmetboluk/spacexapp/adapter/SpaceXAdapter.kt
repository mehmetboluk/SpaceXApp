package com.mehmetboluk.spacexapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mehmetboluk.spacexapp.R
import com.mehmetboluk.spacexapp.service.model.LaunchModel
import com.mehmetboluk.spacexapp.service.model.LaunchModelItem
import kotlinx.android.synthetic.main.recycle_row_column.view.*

class SpaceXAdapter : RecyclerView.Adapter<SpaceXAdapter.SpaceViewHolder>() {
    inner class SpaceViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    val diffCallBack = object : DiffUtil.ItemCallback<LaunchModelItem>() {
        override fun areItemsTheSame(oldItem: LaunchModelItem, newItem: LaunchModelItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: LaunchModelItem, newItem: LaunchModelItem): Boolean {
            return  oldItem.flight_number == newItem.flight_number
        }
    }

    val differ = AsyncListDiffer(this,diffCallBack)
    fun submitList(list: ArrayList<LaunchModelItem>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpaceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recycle_row_column, parent, false)
        return SpaceViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpaceViewHolder, position: Int) {
        val launch = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(launch.links.mission_patch_small).into(ivMissionPatch)
            tvMissionName.text = launch.mission_name
            tvLaunchYear.text = launch.launch_year
            tvRocketName.text = launch.rocket.rocket_name
            setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundleOf("item" to launch))

            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}