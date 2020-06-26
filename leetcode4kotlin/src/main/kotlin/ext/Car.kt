package ext

class Car {

    companion object {
        var newCar: Car = Car()
        get() {
            print("hello modo")
            return field
        }
    }
}