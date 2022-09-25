package com.example.quest.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quest.databinding.QuestRecRowBinding
import com.example.quest.model.Quests

class QuestAdapter(val list: List<Quests> ): RecyclerView.Adapter<QuestAdapter.QuestHolder>() {

    class QuestHolder(val binding : QuestRecRowBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(quest : Quests){
            binding.apply {
                Quest.text = quest.Quest
                AnswerA.text = quest.AnswerA
                AnswerB.text = quest.AnswerB
                AnswerC.text = quest.AnswerC
                AnswerD.text = quest.AnswerD
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestHolder {
      val view = LayoutInflater.from(parent.context)
        return QuestHolder(QuestRecRowBinding.inflate(view,parent,false))
    }

    override fun onBindViewHolder(holder: QuestHolder, position: Int) {
       holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}