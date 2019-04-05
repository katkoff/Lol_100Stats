package com.katkov.lolachievements.application.ui.achievements.list

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.katkov.lolachievements.domain.model.AchievementModel
import kotlinx.android.synthetic.main.item_achievement.view.*

class AchievementsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(achievement: AchievementModel) {
        Glide
            .with(itemView.context)
            .load(Uri.parse(achievement.iconUrl))
            .into(itemView.imageView_achievementIcon)

        itemView.textView_achievementTitle.text = achievement.title
        itemView.textView_achievementDescription.text = achievement.description

        itemView.seekBar_achievement.progress = achievement.progress
        itemView.seekBar_achievement.max = achievement.progressMax
    }
}