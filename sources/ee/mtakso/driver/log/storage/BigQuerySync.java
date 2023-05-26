package ee.mtakso.driver.log.storage;

import i0.a;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LogEntity.kt */
/* loaded from: classes3.dex */
public final class BigQuerySync {

    /* renamed from: a  reason: collision with root package name */
    private final long f21087a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f21088b;

    public BigQuerySync() {
        this(0L, false, 3, null);
    }

    public BigQuerySync(long j8, boolean z7) {
        this.f21087a = j8;
        this.f21088b = z7;
    }

    public final long a() {
        return this.f21087a;
    }

    public final boolean b() {
        return this.f21088b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BigQuerySync) {
            BigQuerySync bigQuerySync = (BigQuerySync) obj;
            return this.f21087a == bigQuerySync.f21087a && this.f21088b == bigQuerySync.f21088b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a8 = a.a(this.f21087a) * 31;
        boolean z7 = this.f21088b;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return a8 + i8;
    }

    public String toString() {
        long j8 = this.f21087a;
        boolean z7 = this.f21088b;
        return "BigQuerySync(logUid=" + j8 + ", wasUploaded=" + z7 + ")";
    }

    public /* synthetic */ BigQuerySync(long j8, boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? 0L : j8, (i8 & 2) != 0 ? false : z7);
    }
}
