package enumtest

class Foo {
    FooType type

    static constraints = {
        type nullable: true
    }
}


enum FooType {
    ONE('One'),
    TWO('Two')

    String displayName

    private FooType(String displayName) {
        this.displayName = displayName
    }

    String getKey() {
        name()
    }

    String toString() {
        displayName
    }
}