package com.example.composeapp.ui.auto_complete_search_bar

import androidx.compose.runtime.Stable
import com.example.composeapp.ui.auto_complete_search_bar.auto_complete_box.model.auto_complete_item.AutoCompleteEntity

@Stable
interface ValueAutoCompleteEntity<T> : AutoCompleteEntity {
    val value: T
}