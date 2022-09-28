package com.example.quest.ui.fragment


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.quest.base.BaseFragment
import com.example.quest.databinding.FragmentQuestBinding
import com.example.quest.ui.QuestViewModel
import com.example.quest.ui.adapter.QuestAdapter
import com.example.quest.ui.adapter.QuestClickListener


class QuestFragment : BaseFragment<FragmentQuestBinding>(FragmentQuestBinding::inflate), QuestClickListener{

    private val viewmodel by viewModels<QuestViewModel>()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       viewmodel.data.observe(viewLifecycleOwner
       ) {

           val adapter = QuestAdapter(it,this)
           binding.questrv.adapter = adapter
           adapter.notifyDataSetChanged()


       }
        (activity as AppCompatActivity).supportActionBar?.title = "Quest"
        binding.button.setOnClickListener {
            findNavController().navigate(QuestFragmentDirections.actionQuestFragmentToResultsFragment(10,0))
        }
    }

    override fun questClick(position: Int) {

        binding.questrv.scrollToPosition(position+1)
    }


}