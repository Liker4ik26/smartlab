package com.compose.medicine.smartlab.screens.analyzes.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.CategoryItemUi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryCard(
    categoryItemUi: CategoryItemUi,
    onAdd: () -> Unit,
    onRemove: () -> Unit,
    selectedCategory: Int,
) {
    FilterChip(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        selected = selectedCategory == categoryItemUi.id,
        border = FilterChipDefaults.filterChipBorder(Color.Transparent),
        shape = RoundedCornerShape(10.dp),
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Color(0xFFF5F5F9),
            selectedContainerColor = Color(0xFF1A6FEE)
        ),
        label = {
            Text(
                text = categoryItemUi.name,
                style = MaterialTheme.typography.bodyMedium,
                color = if (selectedCategory == categoryItemUi.id) Color.White else Color(
                    0xFF7E7E9A
                )
            )
        },
        onClick = {
            if (selectedCategory == categoryItemUi.id) {
                onRemove()
            } else {
                onAdd()
            }
        }
    )
}