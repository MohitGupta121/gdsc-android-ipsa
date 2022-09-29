package com.finite.gdscphcet.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.finite.gdscphcet.databinding.FragmentAboutBinding
import com.finite.gdscphcet.ui.viewModel.AboutViewModel

class AboutFragment : Fragment() {

    private var binding : com.finite.gdscphcet.databinding.FragmentAboutBinding? = null
    private val viewModel: AboutViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentBinding = FragmentAboutBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            aboutFragment = this@AboutFragment
            aboutViewModel = viewModel
        }
        binding?.androidDev?.setOnClickListener {
            onItemClick("androidDev")
        }
        binding?.flutterDev?.setOnClickListener {
            onItemClick("flutterDev")
        }
        binding?.machinelearning?.setOnClickListener {
            onItemClick("machineLearning")
        }
        binding?.webdev?.setOnClickListener {
            onItemClick("webDev")
        }
        binding?.googleCloud?.setOnClickListener {
            onItemClick("googleCloud")
        }
        binding?.openSource?.setOnClickListener {
            onItemClick("openSource")
        }
        binding?.cloudComputing?.setOnClickListener {
            onItemClick("cloudComputing")
        }
        binding?.arVr?.setOnClickListener {
            onItemClick("AR/VR")
        }
        binding?.graphicDesign?.setOnClickListener {
            onItemClick("graphicDesigning")
        }
        binding?.muchMore?.setOnClickListener {
            onItemClick("muchMore")
        }
        binding?.learnMoreButton?.setOnClickListener {
            val url = "https://developers.google.com/community/gdsc"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }

    fun openLink(link: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(intent)
    }

    fun onItemClick(position : String){
        Toast.makeText(context, "Coming soon! ^^", Toast.LENGTH_SHORT).show()
//        val action = AboutFragmentDirections.actionAboutFragmentToTrackDetailActivity(position)
//        findNavController().navigate(action)
    }

}