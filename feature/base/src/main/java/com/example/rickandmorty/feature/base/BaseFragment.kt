package com.example.rickandmorty.feature.base

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    abstract val viewModel: BaseViewModel
}