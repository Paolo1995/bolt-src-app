package io.ktor.util;

import j$.util.DesugarCollections;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Cache.kt */
/* loaded from: classes5.dex */
public final class CacheKt {
    public static final <K, V> Map<K, V> a(Function1<? super K, ? extends V> supplier, Function1<? super V, Unit> close, int i8) {
        Intrinsics.f(supplier, "supplier");
        Intrinsics.f(close, "close");
        Map<K, V> synchronizedMap = DesugarCollections.synchronizedMap(new LRUCache(supplier, close, i8));
        Intrinsics.e(synchronizedMap, "synchronizedMap(LRUCache…upplier, close, maxSize))");
        return synchronizedMap;
    }
}
