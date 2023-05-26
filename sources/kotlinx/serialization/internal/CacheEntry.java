package kotlinx.serialization.internal;

import kotlinx.serialization.KSerializer;

/* compiled from: Caching.kt */
/* loaded from: classes5.dex */
final class CacheEntry<T> {

    /* renamed from: a  reason: collision with root package name */
    public final KSerializer<T> f52139a;

    public CacheEntry(KSerializer<T> kSerializer) {
        this.f52139a = kSerializer;
    }
}
