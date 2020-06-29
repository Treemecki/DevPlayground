package dev.treemecki.kotlin.dependencyInjection.data

import dev.treemecki.kotlin.dependencyInjection.dataProvider.DataProvider
import dev.treemecki.kotlin.dependencyInjection.dataProvider.specific.HelloDataProvider
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton
import org.kodein.di.generic.with

val constantsModule = Kodein.Module("ConstantsModule") {
    constant(tag = "AndrewConst") with "Andrew"
    constant(tag = "JohnConst") with "John"
}

val dataProviderModule = Kodein.Module("DataProviderModule") {
    bind<DataProvider>() with singleton { HelloDataProvider() }
//    bind<DataProvider>() with singleton { QuestionDataProvider() }
}
