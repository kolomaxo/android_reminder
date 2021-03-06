package com.example.reminder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RoutineListAdapter internal constructor(context: Context)
        : RecyclerView.Adapter<RoutineListAdapter.RoutineViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var routines = emptyList<Routine>() // Cached copy of routines

    inner class RoutineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val routineItemView: TextView = itemView.findViewById(R.id.nameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoutineViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return RoutineViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RoutineViewHolder, position: Int) {
        val current = routines[position]
        holder.routineItemView.text = current.name
        holder.routineItemView.tag = current.uid
    }

    internal fun setRoutines(routines: List<Routine>) {
        this.routines = routines
        notifyDataSetChanged()
    }

    override fun getItemCount() = routines.size
}