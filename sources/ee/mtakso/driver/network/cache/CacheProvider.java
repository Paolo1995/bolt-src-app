package ee.mtakso.driver.network.cache;

import android.content.Context;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;

/* compiled from: CacheProvider.kt */
@Singleton
/* loaded from: classes3.dex */
public final class CacheProvider {

    /* renamed from: a  reason: collision with root package name */
    private final long f21305a;

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f21306b;

    @Inject
    public CacheProvider(final Context context) {
        Lazy b8;
        Intrinsics.f(context, "context");
        this.f21305a = 10485760L;
        b8 = LazyKt__LazyJVMKt.b(new Function0<Cache>() { // from class: ee.mtakso.driver.network.cache.CacheProvider$cache$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Cache invoke() {
                Cache b9;
                CacheProvider cacheProvider = CacheProvider.this;
                File cacheDir = context.getCacheDir();
                Intrinsics.e(cacheDir, "context.cacheDir");
                b9 = cacheProvider.b(cacheDir);
                return b9;
            }
        });
        this.f21306b = b8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Cache b(File file) {
        return new Cache(file, this.f21305a);
    }

    public final Cache c() {
        return (Cache) this.f21306b.getValue();
    }
}
