package kotlinx.serialization.internal;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.List;
import kotlin.Result;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Caching.kt */
/* loaded from: classes5.dex */
public final class ParametrizedCacheEntry<T> {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<List<KType>, Result<KSerializer<T>>> f52228a = new ConcurrentHashMap<>();

    public static final /* synthetic */ ConcurrentHashMap a(ParametrizedCacheEntry parametrizedCacheEntry) {
        return parametrizedCacheEntry.f52228a;
    }
}
