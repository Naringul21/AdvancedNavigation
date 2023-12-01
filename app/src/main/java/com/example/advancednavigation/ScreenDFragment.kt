package com.example.advancednavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.advancednavigation.databinding.FragmentScreenDBinding

class ScreenDFragment : Fragment() {
    private lateinit var binding: FragmentScreenDBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=FragmentScreenDBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewPager()
    }

    private fun setViewPager(){
        val adapter= ViewPagerAdapter((childFragmentManager))

        adapter.addFragment(EFragment(),"Tab1")
        adapter.addFragment(FFragment(),"Tab2")

        binding.viewpager.adapter=adapter
        binding.tabLayout.setupWithViewPager(binding.viewpager)

    }
}