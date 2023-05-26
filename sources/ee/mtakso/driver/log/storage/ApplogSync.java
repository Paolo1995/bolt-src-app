package ee.mtakso.driver.log.storage;

import i0.a;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LogEntity.kt */
/* loaded from: classes3.dex */
public final class ApplogSync {

    /* renamed from: a  reason: collision with root package name */
    private final long f21085a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f21086b;

    public ApplogSync() {
        this(0L, false, 3, null);
    }

    public ApplogSync(long j8, boolean z7) {
        this.f21085a = j8;
        this.f21086b = z7;
    }

    public final long a() {
        return this.f21085a;
    }

    public final boolean b() {
        return this.f21086b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ApplogSync) {
            ApplogSync applogSync = (ApplogSync) obj;
            return this.f21085a == applogSync.f21085a && this.f21086b == applogSync.f21086b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a8 = a.a(this.f21085a) * 31;
        boolean z7 = this.f21086b;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return a8 + i8;
    }

    public String toString() {
        long j8 = this.f21085a;
        boolean z7 = this.f21086b;
        return "ApplogSync(logUid=" + j8 + ", wasUploaded=" + z7 + ")";
    }

    public /* synthetic */ ApplogSync(long j8, boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? 0L : j8, (i8 & 2) != 0 ? false : z7);
    }
}
