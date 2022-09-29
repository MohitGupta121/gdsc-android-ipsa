package com.finite.gdscphcet.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.finite.gdscphcet.R
import com.finite.gdscphcet.model.PastEventModel
import com.finite.gdscphcet.ui.EventDetailActivity

class PastEventsAdapter(private val contxt: Context,private val pastEventsList : MutableList<PastEventModel>) : RecyclerView.Adapter<PastEventsAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.past_event_item,parent,false)
        return EventViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val currentEvent = pastEventsList[position]
        holder.itemView.apply {
            Log.d("PRI","link ${currentEvent.thumbnaillink}")
            Glide.with(holder.itemView.context).load(currentEvent.thumbnaillink).into(holder.pastEventThumbnail)
            holder.pastEventTitle.text = currentEvent.title
            holder.pastEventDate.text = currentEvent.date
            /*holder.itemView.setOnClickListener{ view ->
                val bundle = bundleOf("pastEventId" to currentEvent.eventId)
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_eventDetailActivity,bundle)
            }*/
            holder.itemView.setOnClickListener {
                val intent = Intent(context,EventDetailActivity::class.java)
                intent.putExtra("eventId",currentEvent.eventId)
                holder.itemView.context.startActivity(intent)
            }
            holder.cardView.setOnClickListener {
                val intent = Intent(context,EventDetailActivity::class.java)
                intent.putExtra("eventId",currentEvent.eventId)
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return pastEventsList.size
    }

    inner class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val pastEventThumbnail : ImageView = itemView.findViewById(R.id.ivPastEventsImage)
        val pastEventTitle : TextView = itemView.findViewById(R.id.tvPastEventsTitle)
        val pastEventDate : TextView = itemView.findViewById(R.id.tvPastEventsDate)
        val cardView : CardView = itemView.findViewById(R.id.cvImage)
    }
}