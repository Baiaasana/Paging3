package com.example.apiwithpaging3.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiwithpaging3.adapters.PersonAdapter
import com.example.apiwithpaging3.adapters.PersonLoadStateAdapter
import com.example.apiwithpaging3.databinding.ActivityMainBinding
import com.example.apiwithpaging3.network.RetrofitClient
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var personAdapter: PersonAdapter
    private lateinit var viewModel: PersonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewModel()
        setupList()
        observers()
    }

    private fun setupList() {
        personAdapter = PersonAdapter()
        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = personAdapter.withLoadStateHeaderAndFooter(
                header = PersonLoadStateAdapter { personAdapter.retry() },
                footer = PersonLoadStateAdapter { personAdapter.retry() }
            )
            setHasFixedSize(true)
        }
    }

    private fun setupViewModel() {
        val factory = PersonViewModelFactory(RetrofitClient.getPersonInfo())
        viewModel = ViewModelProvider(this, factory)[PersonViewModel::class.java]
    }

    private fun observers() {
        lifecycleScope.launch {
            viewModel.persons.collectLatest { pagedData ->
                personAdapter.submitData(pagedData)
            }
        }
    }
}
