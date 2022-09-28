package com.example.quest.ui.fragment

import android.os.Bundle
import android.view.View
import com.example.quest.base.BaseFragment
import com.example.quest.databinding.FragmentResultsBinding


class ResultsFragment : BaseFragment<FragmentResultsBinding>(FragmentResultsBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val scor = ResultsFragmentArgs.fromBundle(it).conclusion
            val negative = ResultsFragmentArgs.fromBundle(it).negative
            binding.score.text = "doğru : ${scor} " + "yanlış : ${negative}"
        }


    }

}