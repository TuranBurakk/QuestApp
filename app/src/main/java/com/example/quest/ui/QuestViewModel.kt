package com.example.quest.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quest.model.Quests
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query


class QuestViewModel : ViewModel() {

    private val database by lazy { FirebaseFirestore.getInstance() }

    private var _data: MutableLiveData<List<Quests>> = MutableLiveData()

    val data: LiveData<List<Quests>> = _data

    init {
        getData()
    }
    fun getData(){
        val quest = arrayListOf<Quests>()
        database.collection("Quest").orderBy("truereply",Query.Direction.DESCENDING).get().
        addOnSuccessListener { documents ->
            for (document in documents){
               quest.add(document.toObject(Quests :: class.java))
            }
            _data.value = quest
        }
    }


}