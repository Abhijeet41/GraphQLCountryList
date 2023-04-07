package com.abhi41.graphql.data

import com.abhi41.CountriesQuery
import com.abhi41.CountryQuery
import com.abhi41.graphql.domain.CountryClient
import com.abhi41.graphql.domain.DetailedCountry
import com.abhi41.graphql.domain.SimpleCountry
import com.apollographql.apollo3.ApolloClient

class ApolloCountryClient(
    private val apolloClient: ApolloClient
) : CountryClient {

    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries?.map {
                it.toSimpleCountry()
            } ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country?.toDetailedCountry()
    }
}