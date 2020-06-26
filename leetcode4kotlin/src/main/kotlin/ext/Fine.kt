package ext

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class TT {
    var funn: (property: KProperty<*>, oldValue: Int, newValue: Int) -> Unit =
        { property, oldValue, newValue -> print("$property $oldValue $newValue") }
    var value: Int by Delegates.observable(1, funn)
}
