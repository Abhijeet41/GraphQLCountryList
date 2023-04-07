package com.abhi41.graphql.data

import com.abhi41.CountriesQuery
import com.abhi41.CountryQuery
import com.abhi41.graphql.domain.DetailedCountry
import com.abhi41.graphql.domain.SimpleCountry

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry{
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No Capital",
        currency = currency ?: "No Currency",
        languages = languages.mapNotNull { it.name },
        continent = continent.name
    )
}

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry{
    return SimpleCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No Capital",
    )
}