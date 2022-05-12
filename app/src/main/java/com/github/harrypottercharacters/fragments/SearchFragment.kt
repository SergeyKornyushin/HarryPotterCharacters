package com.github.harrypottercharacters.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.github.harrypottercharacters.api.RetrofitInstance
import com.github.harrypottercharacters.databinding.FragmentSearchBinding
import com.github.harrypottercharacters.presentation.HPCharAdapter
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val hpCharAdapter = HPCharAdapter()
        binding.rvSearch.adapter = hpCharAdapter

        lifecycleScope.launchWhenCreated {
            binding.pbDownload.isVisible = true
            val response = try {
                RetrofitInstance.api.getCharacter()
            } catch (e: IOException){
                Log.e("test4", "IOException: $e")
                binding.pbDownload.isVisible = false
                return@launchWhenCreated
            } catch (e: HttpException){
                Log.e("test4", "IOException: $e")
                binding.pbDownload.isVisible = false
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null){
                hpCharAdapter.characters = response.body()!!
            } else {
                Log.e("test4", "Response not successful")
            }
            binding.pbDownload.isVisible = false
        }
    }
}