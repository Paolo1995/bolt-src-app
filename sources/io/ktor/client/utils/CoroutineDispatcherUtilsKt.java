package io.ktor.client.utils;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* compiled from: CoroutineDispatcherUtils.kt */
/* loaded from: classes5.dex */
public final class CoroutineDispatcherUtilsKt {
    public static final CoroutineDispatcher a(Dispatchers dispatchers, int i8, String dispatcherName) {
        Intrinsics.f(dispatchers, "<this>");
        Intrinsics.f(dispatcherName, "dispatcherName");
        return Dispatchers.b().P0(i8);
    }
}
