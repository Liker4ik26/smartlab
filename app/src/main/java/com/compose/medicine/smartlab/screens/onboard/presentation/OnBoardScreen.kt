package com.compose.medicine.smartlab.screens.onboard.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.compose.medicine.smartlab.R
import com.compose.medicine.smartlab.screens.onboard.presentation.models.OnBoardingPage
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.launch

@Destination
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomeScreen(navigator: OnBoardScreenNavigation) {
    val pages = listOf(OnBoardingPage.First, OnBoardingPage.Second, OnBoardingPage.Third)
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) { 3 }

    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            state = pagerState,
            userScrollEnabled = true,
            reverseLayout = false,
            contentPadding = PaddingValues(0.dp),
            pageSize = PageSize.Fill,
            flingBehavior = PagerDefaults.flingBehavior(state = pagerState),
            pageNestedScrollConnection = PagerDefaults.pageNestedScrollConnection(
                Orientation.Horizontal
            ),
            pageContent = { position ->
                OnBoardScreen(
                    onBoardingPage = pages[position],
                    pagerState = pagerState,
                    navigateToSignIn = navigator::navigateToSignIn
                )
            }
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardScreen(
    viewModel: OnBoardViewModel = hiltViewModel(),
    onBoardingPage: OnBoardingPage,
    pagerState: PagerState,
    navigateToSignIn: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                OnBoardUiEffect.NavigateToSignIn -> navigateToSignIn()
            }

        }
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            TextButton(onClick = {
                coroutineScope.launch {
                    if (pagerState.currentPage != 2) {
                        pagerState.scrollToPage(pagerState.currentPage + 1)
                    } else {
                        viewModel.sendEvent(OnBoardUiEvent.OnNavigateToSignIn)
                    }
                }
            }) {
                Text(
                    text = stringResource(onBoardingPage.buttonUp),
                    color = Color(0xff57A9FF),
                    style = MaterialTheme.typography.labelMedium
                )
            }
            Image(
                painter = painterResource(id = R.drawable.plus), contentDescription = null,
                modifier = Modifier.size(height = 164.dp, width = 168.dp)
            )
        }
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = stringResource(onBoardingPage.title),
            color = Color(0xff00B712),
            style = MaterialTheme.typography.labelMedium
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = stringResource(onBoardingPage.description),
            textAlign = TextAlign.Center,
            color = Color(0xff939396),
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.height(60.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            repeat(3) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color(0xff57A9FF) else Color.White
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .border(1.dp, Color(0xff57A9FF), shape = CircleShape)
                        .size(12.dp),
                )

            }
        }
        Spacer(modifier = Modifier.height(60.dp))
        Image(
            modifier = Modifier.size(height = 220.dp, width = 360.dp),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(60.dp))
    }
}