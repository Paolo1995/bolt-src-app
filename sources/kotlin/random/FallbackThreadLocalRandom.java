package kotlin.random;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformRandom.kt */
/* loaded from: classes5.dex */
public final class FallbackThreadLocalRandom extends AbstractPlatformRandom {

    /* renamed from: h  reason: collision with root package name */
    private final FallbackThreadLocalRandom$implStorage$1 f51029h = new ThreadLocal<java.util.Random>() { // from class: kotlin.random.FallbackThreadLocalRandom$implStorage$1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public java.util.Random initialValue() {
            return new java.util.Random();
        }
    };

    @Override // kotlin.random.AbstractPlatformRandom
    public java.util.Random i() {
        java.util.Random random = get();
        Intrinsics.e(random, "implStorage.get()");
        return random;
    }
}
