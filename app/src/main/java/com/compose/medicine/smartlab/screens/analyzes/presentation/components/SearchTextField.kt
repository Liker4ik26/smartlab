package com.compose.medicine.smartlab.screens.analyzes.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.compose.medicine.smartlab.R
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.AnalysisItemUi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: () -> Unit,
    active: Boolean,
    onActiveChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    onClickCancel: () -> Unit,
    hint: String,
    analyzes: List<AnalysisItemUi>
) {
    SearchBar(
        modifier = modifier.border(
            1.dp,
            color = Color(0xFFEBEBEB),
            RoundedCornerShape(10.dp)
        ),
        query = query,
        onQueryChange = { onQueryChange(it) },
        onSearch = { onSearch() },
        active = active,
        onActiveChange = { onActiveChange(it) },
        placeholder = { BodyTextFieldHint(text = hint) },
        shape = RoundedCornerShape(10),
        tonalElevation = 0.dp,
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = null
            )
        },
        trailingIcon = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    modifier = Modifier.clickable { onClickCancel() },
                    painter = painterResource(id = R.drawable.cancel),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(16.dp))
                if (active)
                    Text(
                        modifier = Modifier.clickable { onBack() },
                        text = "Отменить",
                        color = Color(0xFF1A6FEE),
                        style = MaterialTheme.typography.bodySmall,
                        textAlign = TextAlign.Right
                    )
            }
        },
        colors = SearchBarDefaults.colors(
            containerColor = Color(0xFFF5F5F9),
            dividerColor = Color(0xFFFF4F4F4)
        )
    ) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(analyzes) { analysis ->
                SearchCard(
                    analysis = analysis,
                    request = query,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 12.dp)
                )
            }
        }
    }
}