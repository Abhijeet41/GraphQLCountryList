package com.abhi41.graphql.presentation.screen

import com.abhi41.graphql.domain.DetailedCountry
import com.abhi41.graphql.domain.SimpleCountry

data class CountriesState(
    val countries: List<SimpleCountry> = emptyList(),
    val isLoading: Boolean = false,
    val selectedCountry: DetailedCountry? = null
)
