package dev.treemecki.kotlin.dependencyInjection.presenter

import dev.treemecki.kotlin.dependencyInjection.dataProvider.DataProvider

class DataDecorator(val dataProvider: DataProvider, val source: String) {

    fun decorate(): String = "> $source: ${dataProvider.provide()}"

}
