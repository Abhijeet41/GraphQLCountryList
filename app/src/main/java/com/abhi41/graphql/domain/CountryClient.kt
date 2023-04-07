package com.abhi41.graphql.domain

import com.abhi41.CountryQuery

interface CountryClient {

    suspend fun getCountries(): List<SimpleCountry>

    suspend fun getCountry(code: String): DetailedCountry?

}