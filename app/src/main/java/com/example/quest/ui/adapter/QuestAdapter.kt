package com.example.quest.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quest.R
import com.example.quest.databinding.QuestRecRowBinding
import com.example.quest.model.Quests
import kotlinx.coroutines.delay

class QuestAdapter(val list: List<Quests> , private val itemListener: QuestClickListener): RecyclerView.Adapter<QuestAdapter.QuestHolder>() {

    class QuestHolder(val binding: QuestRecRowBinding) : RecyclerView.ViewHolder(binding.root) {



    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestHolder {
        val view = LayoutInflater.from(parent.context)
        return QuestHolder(QuestRecRowBinding.inflate(view, parent, false))
    }

    override fun onBindViewHolder(holder: QuestHolder, position: Int) {

        holder.binding.Quest.text = list[position].quest1
        holder.binding.AnswerA.text = list[position].replya1
        holder.binding.AnswerB.text = list[position].replyb1
        holder.binding.AnswerC.text = list[position].replyc1
        holder.binding.AnswerD.text = list[position].replyd1

        onClick(holder.binding.AnswerA,holder.binding.AnswerB,holder.binding.AnswerC,
            holder.binding.AnswerD,position,list[position].truereply)
        onClick(holder.binding.AnswerB,holder.binding.AnswerA,holder.binding.AnswerC,
            holder.binding.AnswerD,position,list[position].truereply)
        onClick(holder.binding.AnswerC,holder.binding.AnswerB,holder.binding.AnswerA,
            holder.binding.AnswerD,position,list[position].truereply)
        onClick(holder.binding.AnswerD,holder.binding.AnswerB,holder.binding.AnswerC,
            holder.binding.AnswerA,position,list[position].truereply)


    }


    override fun getItemCount(): Int {
        return list.size
    }
    fun onClick(textView: TextView,textView1: TextView,textView2: TextView,textView3: TextView,
                position: Int, reply : String?){
        textView.setOnClickListener {
                notClick(textView)
                notClick(textView1)
                notClick(textView2)
                notClick(textView3)
            if (textView.text != list[position].truereply) {
                textView.setBackgroundResource(R.drawable.buttonbgred)
            } else {
                textView.setBackgroundResource(R.drawable.buttonbggreen)
            }

            itemListener.questClick(position)
        }
    }
    fun notClick(textView: TextView){
        textView.isClickable = false
    }
}