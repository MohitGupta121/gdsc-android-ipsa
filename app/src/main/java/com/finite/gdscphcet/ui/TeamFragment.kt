package com.finite.gdscphcet.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.finite.gdscphcet.R
import com.finite.gdscphcet.databinding.FragmentTeamBinding

class TeamFragment : Fragment() {

    private var binding : FragmentTeamBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentBinding = FragmentTeamBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            teamFragment = this@TeamFragment
        }

        Glide.with(this).load(getString(R.string.rishabh)).centerCrop().into(binding!!.piRishabh)
        Glide.with(this).load(getString(R.string.parth)).centerCrop().into(binding!!.piParth)
        Glide.with(this).load(getString(R.string.vedant)).centerCrop().into(binding!!.piVedant)
        Glide.with(this).load(getString(R.string.sakshi)).centerCrop().into(binding!!.piSakshi)
        Glide.with(this).load(getString(R.string.prathamesh)).centerCrop().into(binding!!.piPrathamesh)
        Glide.with(this).load(getString(R.string.khusbhu)).centerCrop().into(binding!!.pikhusbhu)
        Glide.with(this).load(getString(R.string.aryan)).centerCrop().into(binding!!.piAryan)
        Glide.with(this).load(getString(R.string.khushnuma)).centerCrop().into(binding!!.piKhushnuma)
        Glide.with(this).load(getString(R.string.shreya)).centerCrop().into(binding!!.piShreya)
        Glide.with(this).load(getString(R.string.bhavesh)).centerCrop().into(binding!!.piBhavesh)
        Glide.with(this).load(getString(R.string.neha)).centerCrop().into(binding!!.piNeha)
        Glide.with(this).load(getString(R.string.sohan)).centerCrop().into(binding!!.piSohan)
        Glide.with(this).load(getString(R.string.anuj)).centerCrop().into(binding!!.piAnuj)
        Glide.with(this).load(getString(R.string.ishika)).centerCrop().into(binding!!.piIshika)
        Glide.with(this).load(getString(R.string.aakash)).centerCrop().into(binding!!.piAakash)
    }

    fun openLink(link: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(intent)
    }





}