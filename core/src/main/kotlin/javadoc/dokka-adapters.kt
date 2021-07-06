package org.jetbrains.dokka.javadoc

import com.google.inject.Binder
import com.google.inject.Inject
import org.jetbrains.dokka.*
import org.jetbrains.dokka.Formats.DefaultAnalysisComponent
import org.jetbrains.dokka.Formats.DefaultAnalysisComponentServices
import org.jetbrains.dokka.Formats.FormatDescriptor
import org.jetbrains.dokka.Formats.KotlinAsJava
import org.jetbrains.dokka.Utilities.bind
import org.jetbrains.dokka.Utilities.toType

class JavadocGenerator @Inject constructor(val configuration: DokkaConfiguration, val logger: DokkaLogger) : Generator {

    override fun buildPages(nodes: Iterable<DocumentationNode>) {
    }

    override fun buildOutlines(nodes: Iterable<DocumentationNode>) {
        // no outline could be generated separately
    }

    override fun buildSupportFiles() {
    }

    override fun buildPackageList(nodes: Iterable<DocumentationNode>) {
        // handled by javadoc itself
    }
}

class JavadocFormatDescriptor :
        FormatDescriptor,
        DefaultAnalysisComponent,
        DefaultAnalysisComponentServices by KotlinAsJava {

    override fun configureOutput(binder: Binder): Unit = with(binder) {
        bind<Generator>() toType JavadocGenerator::class
    }
}
