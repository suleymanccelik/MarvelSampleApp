package com.suleymancelik.marvelapp.list

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.mvrx.*
import com.suleymancelik.marvelapp.common.ui.BaseFragment
import com.suleymancelik.marvelapp.common.ui.binding.viewBinding
import com.suleymancelik.marvelapp.core.network.NetworkHelper
import com.suleymancelik.marvelapp.list.databinding.FragmentCharacterListBinding
import com.suleymancelik.marvelapp.list.ui.CharacterDataSource
import com.suleymancelik.marvelapp.list.ui.CharacterListEpoxyController
import javax.inject.Inject

class CharacterListFragment : BaseFragment(R.layout.fragment_character_list) {

    @Inject
    lateinit var mNetworkHelper: NetworkHelper

    private val mCharacterListViewModel: CharacterListViewModel by fragmentViewModel()
    private val mCharacterListViewBinding by viewBinding(FragmentCharacterListBinding::bind)
    private lateinit var mPagedListController: CharacterListEpoxyController
    private lateinit var mPageConfig: PagedList.Config

    private var mInflaterContext: Context? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mInflaterContext = view.context
        mCharacterListViewBinding.moviesRv.layoutManager = LinearLayoutManager(mInflaterContext, RecyclerView.VERTICAL, false)
        mPagedListController = CharacterListEpoxyController()
        mCharacterListViewBinding.moviesRv.adapter = mPagedListController.adapter

        mPageConfig = PagedList.Config.Builder()
            .setInitialLoadSizeHint(30)
            .setPageSize(30)
            .build()

        mCharacterListViewModel.fetchCharacterList()
    }

    override fun invalidate(): Unit =
        withState(mCharacterListViewModel) { state: CharacterListState ->
            when (state.characterListState) {
                is Uninitialized -> {
                    mPagedListController.error = null
                    mPagedListController.isLoading = true
                }
                is Loading -> {
                    mPagedListController.error = null
                    mPagedListController.isLoading = true
                }
                is Success -> {
                    if (state.characterList?.characterListResults?.isNullOrEmpty() == false) {
                        val pagedStrings = PagedList.Builder(
                            CharacterDataSource(state.characterList.characterListResults), mPageConfig)
                            .setInitialKey(0)
                            .setNotifyExecutor(ContextCompat.getMainExecutor(mInflaterContext!!))
                            .setFetchExecutor(ContextCompat.getMainExecutor(mInflaterContext!!))
                            .build()


                        mPagedListController.error = null
                        mPagedListController.isLoading = false
                        mPagedListController.submitList(pagedStrings)
                    }
                }
                is Fail -> {
                    mPagedListController.error = null
                    mPagedListController.isLoading = false
                }
            }
        }

}