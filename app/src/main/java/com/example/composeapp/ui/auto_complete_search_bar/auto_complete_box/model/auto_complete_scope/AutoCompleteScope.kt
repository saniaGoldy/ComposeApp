package com.example.composeapp.ui.auto_complete_search_bar.auto_complete_box.model.auto_complete_scope

import androidx.compose.runtime.Stable
import com.example.composeapp.ui.auto_complete_search_bar.auto_complete_box.model.auto_complete_item.AutoCompleteEntity

typealias ItemSelected<T> = (T) -> Unit

@Stable
interface AutoCompleteScope<T : AutoCompleteEntity> : AutoCompleteDesignScope {
    var isSearching: Boolean
    fun filter(query: String)
    fun onItemSelected(block: ItemSelected<T> = {})
}
