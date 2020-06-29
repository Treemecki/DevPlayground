package dev.treemecki.kotlin.dependencyInjection.dataProvider.specific

import dev.treemecki.kotlin.dependencyInjection.dataProvider.DataProvider

class QuestionDataProvider : DataProvider {

    override fun provide(): String = "How are you?"

}
