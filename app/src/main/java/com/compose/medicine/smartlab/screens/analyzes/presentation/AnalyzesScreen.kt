package com.compose.medicine.smartlab.screens.analyzes.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.compose.medicine.smartlab.R
import com.compose.medicine.smartlab.screens.analyzes.presentation.components.AnalysisCard
import com.compose.medicine.smartlab.screens.analyzes.presentation.components.CategoryCard
import com.compose.medicine.smartlab.screens.analyzes.presentation.components.NewsAndStockCard
import com.compose.medicine.smartlab.screens.analyzes.presentation.components.SearchTextField
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.AnalysisItemUi
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.NewsAndStockItemUi

@Composable
fun AnalyzesScreen(
    viewModel: AnalyzesViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    val news: List<NewsAndStockItemUi> = listOf(
        NewsAndStockItemUi(
            title = "Подготовка к вакцинации",
            description = "Комплексное обследование перед вакцинацией",
            price = "8000 ₽ ",
            image = R.drawable.man
        ),
        NewsAndStockItemUi(
            title = "Подготовка к вакцинации",
            description = "Комплексное обследование перед вакцинацией",
            price = "8000 ₽ ",
            image = R.drawable.man
        ), NewsAndStockItemUi(
            title = "Подготовка к вакцинации",
            description = "Комплексное обследование перед вакцинацией",
            price = "8000 ₽ ",
            image = R.drawable.man
        ), NewsAndStockItemUi(
            title = "Подготовка к вакцинации",
            description = "Комплексное обследование перед вакцинацией",
            price = "8000 ₽ ",
            image = R.drawable.man
        ), NewsAndStockItemUi(
            title = "Подготовка к вакцинации",
            description = "Комплексное обследование перед вакцинацией",
            price = "8000 ₽ ",
            image = R.drawable.man
        )
    )

    val analyzes: List<AnalysisItemUi> = listOf(
        AnalysisItemUi(
            titleAnalysis = "ПЦР-тест на определение РНК коронавируса стандартный",
            date = "2 дня",
            price = "1800 ₽"
        ),
        AnalysisItemUi(
            titleAnalysis = "ПЦР-тест на определение РНК коронавируса стандартный",
            date = "2 дня",
            price = "1800 ₽"
        ),
        AnalysisItemUi(
            titleAnalysis = "ПЦР-тест на определение РНК коронавируса стандартный",
            date = "2 дня",
            price = "1800 ₽"
        ),
        AnalysisItemUi(
            titleAnalysis = "ПЦР-тест на определение РНК коронавируса стандартный",
            date = "2 дня",
            price = "1800 ₽"
        ),
        AnalysisItemUi(
            titleAnalysis = "ПЦР-тест на определение РНК коронавируса стандартный",
            date = "2 дня",
            price = "1800 ₽"
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFF9F9FC)),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item {
            Spacer(modifier = Modifier.height(16.dp))
            SearchTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                text = state.search,
                hint = "Искать анализы",
                isError = false,
                onType = { viewModel.sendEvent(AnalyzesUiEvent.OnSearchInput(it)) })
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                text = "Акции и новости",
                style = MaterialTheme.typography.titleSmall,
                color = Color(0xFF939396)
            )
        }
        item {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(news) { newsItem ->
                    NewsAndStockCard(
                        title = newsItem.title,
                        description = newsItem.description,
                        price = newsItem.price,
                        image = newsItem.image
                    )
                }
            }
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                text = "Каталог анализов",
                style = MaterialTheme.typography.titleSmall,
                color = Color(0xFF939396)
            )
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CategoryCard(title = "Популярные", isEnable = true, onClick = {})
                CategoryCard(title = "Covid", isEnable = false, onClick = {})
                CategoryCard(title = "Комплексные", isEnable = false, onClick = {})
            }
        }

        items(analyzes) { analysis ->
            AnalysisCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                titleAnalysis = analysis.titleAnalysis,
                date = analysis.date,
                price = analysis.price,
                onClick = {}
            )

        }
    }
}