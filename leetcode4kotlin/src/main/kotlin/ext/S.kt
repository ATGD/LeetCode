package ext

class S(var name: String = "", var age: Int = 1) {
    operator fun component1() = name
    operator fun component2() = age
}