package com.example.composeapp.ui.auto_complete_search_bar.auto_complete_box.model.auto_complete_item

import androidx.compose.runtime.Stable

@Stable
interface AutoCompleteEntity {
    fun filter(query: String): Boolean
}
