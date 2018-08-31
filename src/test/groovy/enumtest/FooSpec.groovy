package enumtest

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class FooSpec extends Specification implements DomainUnitTest<Foo> {

    void "test something"() {
        expect: "Valid to start"
        domain.validate()
        when: "assign a enum"
        domain.type = FooType.ONE
        then: "still valid"
        domain.validate()

        when: "Attempt to set field back to null"
        domain.type = null

        then: "no exception thrown"
        noExceptionThrown()
        /*
        But there is:
            java.lang.ExceptionInInitializerError at enumtest.FooSpec.test something(FooSpec.groovy:12)
            Caused by: groovy.lang.GroovyRuntimeException: Could not find matching constructor for: enumtest.FooType(java.lang.String, java.lang.Integer, java.lang.String)
        */
    }
}
