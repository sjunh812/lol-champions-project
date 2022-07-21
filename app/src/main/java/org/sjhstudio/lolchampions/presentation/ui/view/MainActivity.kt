package org.sjhstudio.lolchampions.presentation.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.sjhstudio.lolchampions.R
import org.sjhstudio.lolchampions.databinding.ActivityMainBinding
import org.sjhstudio.lolchampions.presentation.base.BaseActivity
import org.sjhstudio.lolchampions.presentation.ui.adapter.ChampionAdapter
import org.sjhstudio.lolchampions.presentation.ui.adapter.ChampionItemDecoration
import org.sjhstudio.lolchampions.presentation.ui.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel: MainViewModel by viewModels()
    private val championAdapter: ChampionAdapter by lazy {
        ChampionAdapter()
    }
    private val championItemDecoration: ChampionItemDecoration by lazy {
        ChampionItemDecoration()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind()
    }

    private fun bind() {
        with(binding) {
            vm = viewModel
            adapter = championAdapter
            itemDecoration = championItemDecoration
        }
    }
}