package io.ktor.util.collections;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CopyOnWriteHashMap.kt */
/* loaded from: classes5.dex */
public final class CopyOnWriteHashMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f47062a = AtomicReferenceFieldUpdater.newUpdater(CopyOnWriteHashMap.class, Object.class, "current");
    private volatile /* synthetic */ Object current;

    public CopyOnWriteHashMap() {
        Map f8;
        f8 = MapsKt__MapsKt.f();
        this.current = f8;
    }

    public final V a(K key) {
        Intrinsics.f(key, "key");
        return (V) ((Map) this.current).get(key);
    }
}
