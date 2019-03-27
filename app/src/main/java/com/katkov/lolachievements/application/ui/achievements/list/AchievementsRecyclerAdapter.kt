package com.katkov.lolachievements.application.ui.achievements.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.katkov.lolachievements.R
import com.katkov.lolachievements.domain.model.AchievementModel

class AchievementsRecyclerAdapter : RecyclerView.Adapter<AchievementsViewHolder>() {

    private var achievements = listOf<AchievementModel>()

    fun setData(achievements: List<AchievementModel>) {
        this.achievements = achievements
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievementsViewHolder {
        return AchievementsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_achievement,
                parent,
                false))
    }

    override fun getItemCount() = achievements.size

    override fun onBindViewHolder(holder: AchievementsViewHolder, position: Int) =
        holder.bind(this.achievements[position])
}