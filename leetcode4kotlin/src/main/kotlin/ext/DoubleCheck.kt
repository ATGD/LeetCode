package ext

class DoubleCheck {

    companion object {
        val instance: DoubleCheck
                by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { DoubleCheck() }

    }
}