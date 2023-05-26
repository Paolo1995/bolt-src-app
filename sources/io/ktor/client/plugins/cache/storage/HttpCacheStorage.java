package io.ktor.client.plugins.cache.storage;

import io.ktor.client.plugins.cache.HttpCacheEntry;
import io.ktor.http.Url;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: HttpCacheStorage.kt */
/* loaded from: classes5.dex */
public abstract class HttpCacheStorage {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f46456a = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private static final Function0<HttpCacheStorage> f46457b = new Function0<UnlimitedCacheStorage>() { // from class: io.ktor.client.plugins.cache.storage.HttpCacheStorage$Companion$Unlimited$1
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final UnlimitedCacheStorage invoke() {
            return new UnlimitedCacheStorage();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final HttpCacheStorage f46458c = DisabledCacheStorage.f46455d;

    /* compiled from: HttpCacheStorage.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HttpCacheStorage a() {
            return HttpCacheStorage.f46458c;
        }

        public final Function0<HttpCacheStorage> b() {
            return HttpCacheStorage.f46457b;
        }
    }

    public abstract HttpCacheEntry c(Url url, Map<String, String> map);

    public abstract Set<HttpCacheEntry> d(Url url);

    public abstract void e(Url url, HttpCacheEntry httpCacheEntry);
}
