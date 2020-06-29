package dev.treemecki.test.java

import org.junit.platform.runner.JUnitPlatform
import org.junit.platform.suite.api.SelectPackages
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
@SelectPackages("dev.treemecki.test.java")
class AllJavaTests {
}
