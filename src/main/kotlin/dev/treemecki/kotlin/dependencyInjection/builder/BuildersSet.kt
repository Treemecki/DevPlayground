package dev.treemecki.kotlin.dependencyInjection.builder

import dev.treemecki.kotlin.dependencyInjection.data.constantsModule
import dev.treemecki.kotlin.dependencyInjection.data.dataProviderModule
import dev.treemecki.kotlin.dependencyInjection.presenter.DataDecorator
import org.kodein.di.Kodein
import org.kodein.di.generic.instance
import org.kodein.di.newInstance

val diContainer = Kodein {
    import(constantsModule)
    import(dataProviderModule)
}

fun buildDataDecorator(nameTag: String): DataDecorator {
    val dataDecorator: DataDecorator by diContainer.newInstance {
        DataDecorator(
            instance(),
            instance(tag = nameTag)
        )
    }
    return dataDecorator
}
