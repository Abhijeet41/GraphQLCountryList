package com.abhi41.graphql

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.abhi41.graphql.presentation.screen.CountriesScreen
import com.abhi41.graphql.presentation.screen.CountriesViewModel
import com.abhi41.graphql.ui.theme.GraphQLTheme
import dagger.hilt.android.AndroidEntryPoint

//this means we want to inject dependencies from hilt in this activity
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GraphQLTheme {
                val viewmodel = hiltViewModel<CountriesViewModel>()
                val state by viewmodel.state.collectAsState()
                CountriesScreen(
                    state = state,
                    onSelectedCountry = viewmodel::selectedCountry,
                    onDismissCountryDialog = viewmodel::dismissCountryDialog
                )
            }
        }
    }
}

