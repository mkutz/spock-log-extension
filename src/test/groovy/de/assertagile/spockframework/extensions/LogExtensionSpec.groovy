package de.assertagile.spockframework.extensions

import spock.lang.Specification

class LogExtensionSpec extends Specification {

    def "This is just a test"() {
        expect: "this is what we expect"
        true

        and: "this also"
        true
    }
}