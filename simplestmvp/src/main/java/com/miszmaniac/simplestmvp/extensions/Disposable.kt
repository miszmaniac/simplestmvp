package com.getresponse.rooms2.extensions

import android.view.View
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference
import java.util.*

interface DisposableRegistrants {
    fun registerDisposable(disposable: Disposable)
}

fun Disposable.register(registrants: DisposableRegistrants): Disposable {
    registrants.registerDisposable(this)
    return this
}

val bindMap: WeakHashMap<View, WeakReference<Disposable>> = WeakHashMap()

fun Disposable.bind(view: View): Disposable {
    bindMap[view]?.get()?.dispose()
    bindMap[view] = WeakReference(this)
    return this
}
