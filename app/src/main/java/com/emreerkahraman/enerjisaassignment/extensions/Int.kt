package com.emreerkahraman.enerjisaassignment.extensions

import android.content.res.Resources

val Int.toPx get() = (this * Resources.getSystem().displayMetrics.density).toInt()

val Int.toDp get() = (this / Resources.getSystem().displayMetrics.density).toInt()