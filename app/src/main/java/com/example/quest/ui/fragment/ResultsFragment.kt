package com.example.quest.ui.fragment

import android.os.Bundle
import android.view.View
import com.example.quest.base.BaseFragment
import com.example.quest.databinding.FragmentResultsBinding


class ResultsFragment : BaseFragment<FragmentResultsBinding>(FragmentResultsBinding::inflate) {
    private var scor : Int = 1
    private var negative : Int = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            scor = ResultsFragmentArgs.fromBundle(it).conclusion
            negative = ResultsFragmentArgs.fromBundle(it).negative
        }
        binding.score.text = "doğru : ${scor} yanlış : ${negative}"

    }

}