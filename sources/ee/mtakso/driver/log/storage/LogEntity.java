package ee.mtakso.driver.log.storage;

import i0.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogEntity.kt */
/* loaded from: classes3.dex */
public final class LogEntity {

    /* renamed from: a  reason: collision with root package name */
    private final long f21105a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21106b;

    /* renamed from: c  reason: collision with root package name */
    private final String f21107c;

    /* renamed from: d  reason: collision with root package name */
    private final String f21108d;

    /* renamed from: e  reason: collision with root package name */
    private final long f21109e;

    /* renamed from: f  reason: collision with root package name */
    private final String f21110f;

    public LogEntity(long j8, String str, String message, String severity, long j9, String data) {
        Intrinsics.f(message, "message");
        Intrinsics.f(severity, "severity");
        Intrinsics.f(data, "data");
        this.f21105a = j8;
        this.f21106b = str;
        this.f21107c = message;
        this.f21108d = severity;
        this.f21109e = j9;
        this.f21110f = data;
    }

    public final String a() {
        return this.f21110f;
    }

    public final String b() {
        return this.f21107c;
    }

    public final String c() {
        return this.f21108d;
    }

    public final String d() {
        return this.f21106b;
    }

    public final long e() {
        return this.f21109e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LogEntity) {
            LogEntity logEntity = (LogEntity) obj;
            return this.f21105a == logEntity.f21105a && Intrinsics.a(this.f21106b, logEntity.f21106b) && Intrinsics.a(this.f21107c, logEntity.f21107c) && Intrinsics.a(this.f21108d, logEntity.f21108d) && this.f21109e == logEntity.f21109e && Intrinsics.a(this.f21110f, logEntity.f21110f);
        }
        return false;
    }

    public final long f() {
        return this.f21105a;
    }

    public int hashCode() {
        int a8 = a.a(this.f21105a) * 31;
        String str = this.f21106b;
        return ((((((((a8 + (str == null ? 0 : str.hashCode())) * 31) + this.f21107c.hashCode()) * 31) + this.f21108d.hashCode()) * 31) + a.a(this.f21109e)) * 31) + this.f21110f.hashCode();
    }

    public String toString() {
        long j8 = this.f21105a;
        String str = this.f21106b;
        String str2 = this.f21107c;
        String str3 = this.f21108d;
        long j9 = this.f21109e;
        String str4 = this.f21110f;
        return "LogEntity(uid=" + j8 + ", tag=" + str + ", message=" + str2 + ", severity=" + str3 + ", timestamp=" + j9 + ", data=" + str4 + ")";
    }

    public /* synthetic */ LogEntity(long j8, String str, String str2, String str3, long j9, String str4, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? 0L : j8, str, str2, str3, j9, str4);
    }
}
