package com.example.myapplication


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        message.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toMessages))
        favoutire.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toFavourites))
        account.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toAccount))
        settting.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toSettings))
        faq.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toFaq))
    }

}
