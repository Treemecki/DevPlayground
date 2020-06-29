package dev.treemecki.test.kotlin

import org.junit.platform.runner.JUnitPlatform
import org.junit.platform.suite.api.SelectPackages
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
@SelectPackages("dev.treemecki.test.kotlin")
class AllKotlinTests {
}
