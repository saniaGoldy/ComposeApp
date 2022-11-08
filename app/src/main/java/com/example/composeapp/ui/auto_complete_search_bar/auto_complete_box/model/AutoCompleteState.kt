package com.example.composeapp.ui.auto_complete_search_bar.auto_complete_box.model

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composeapp.ui.auto_complete_search_bar.auto_complete_box.model.auto_complete_item.AutoCompleteEntity
import com.example.composeapp.ui.auto_complete_search_bar.auto_complete_box.model.auto_complete_scope.AutoCompleteScope
import com.example.composeapp.ui.auto_complete_search_bar.auto_complete_box.model.auto_complete_scope.ItemSelected

class AutoCompleteState<T : AutoCompleteEntity>(private val startItems: List<T>) :
    AutoCompleteScope<T> {
    private var onItemSelectedBlock: ItemSelected<T>? = null

    fun selectItem(item: T) {
        onItemSelectedBlock?.invoke(item)
    }

    var filteredItems by mutableStateOf(startItems)
    override var isSearching by mutableStateOf(false)
    override var boxWidthPercentage by mutableStateOf(.9f)
    override var shouldWrapContentHeight by mutableStateOf(false)

    @OptIn(ExperimentalMaterial3Api::class)
    override var boxMaxHeight: Dp by mutableStateOf(TextFieldDefaults.MinHeight * 3)
    override var boxBorderStroke by mutableStateOf(BorderStroke(2.dp, Color.Black))
    override var boxShape: Shape by mutableStateOf(RoundedCornerShape(8.dp))

    override fun filter(query: String) {
        if (isSearching)
            filteredItems = startItems.filter { entity ->
                entity.filter(query)
            }
    }

    override fun onItemSelected(block: ItemSelected<T>) {
        onItemSelectedBlock = block
    }
}