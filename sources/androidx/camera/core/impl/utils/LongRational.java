package androidx.camera.core.impl.utils;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
final class LongRational {

    /* renamed from: a  reason: collision with root package name */
    private final long f3816a;

    /* renamed from: b  reason: collision with root package name */
    private final long f3817b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LongRational(long j8, long j9) {
        this.f3816a = j8;
        this.f3817b = j9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long a() {
        return this.f3817b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long b() {
        return this.f3816a;
    }

    @NonNull
    public String toString() {
        return this.f3816a + "/" + this.f3817b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LongRational(double d8) {
        this((long) (d8 * 10000.0d), 10000L);
    }
}
