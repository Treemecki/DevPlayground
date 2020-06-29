package dev.treemecki.kotlin.dependencyInjection.dataProvider.specific

import dev.treemecki.kotlin.dependencyInjection.dataProvider.DataProvider

class HelloDataProvider : DataProvider {

    override fun provide(): String = "Hello"

}
