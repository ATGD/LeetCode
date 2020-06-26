package ext

class LazyMan {
    companion object {
        private var instance: LazyMan? = null
        @Synchronized
        fun getInstance(): LazyMan? {
            if (instance == null) {
                instance = LazyMan()
            }
            return instance
        }
    }
}