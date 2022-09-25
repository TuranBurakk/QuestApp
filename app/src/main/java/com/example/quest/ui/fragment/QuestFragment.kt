package com.example.quest.ui.fragment


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quest.base.BaseFragment

import com.example.quest.databinding.FragmentQuestBinding
import com.example.quest.model.Quests
import com.example.quest.ui.adapter.QuestAdapter
import com.google.firebase.firestore.FirebaseFirestore


class QuestFragment : BaseFragment<FragmentQuestBinding>(FragmentQuestBinding::inflate) {

    private val database by lazy { FirebaseFirestore.getInstance() }
    private val adapter by lazy { QuestAdapter(questList) }

    var questList = ArrayList<Quests>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()

        binding.questrv.layoutManager = LinearLayoutManager(context)
        binding.questrv.adapter = QuestAdapter(questList)

    }
    fun getData(){
        database.collection("Quest").addSnapshotListener { snapshot, error ->
            if (error != null){
                Toast.makeText(context,error.localizedMessage,Toast.LENGTH_LONG).show()
            }else{
                if (snapshot != null){
                    if(!snapshot.isEmpty){
                        val documents =snapshot.documents

                        questList.clear()

                        for (document in documents){
                            val quest = document.get("quest1") as String
                            val answera = document.get("replya1") as String
                            val answerb = document.get("replyb1") as String
                            val answerc = document.get("replyc1") as String
                            val answerd = document.get("replyd1") as String

                            val downloadquest = Quests(quest,answera,answerb,answerc,answerd)
                            println(downloadquest)
                            questList.add(downloadquest)
                        }
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }



}