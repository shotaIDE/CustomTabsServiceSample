package com.ide.shota.customtabsservicesample

class Rate(
        rate: Int
) {
    var isViewable: Boolean = true
        private set

    init {
        isViewable = rate == 0
    }
}
