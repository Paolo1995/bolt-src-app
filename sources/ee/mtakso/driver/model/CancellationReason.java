package ee.mtakso.driver.model;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CancellationReason.kt */
/* loaded from: classes3.dex */
public final class CancellationReason {

    /* renamed from: a  reason: collision with root package name */
    private final String f21185a;

    /* renamed from: b  reason: collision with root package name */
    private String f21186b;

    public CancellationReason() {
        this(null, null, 3, null);
    }

    public CancellationReason(String code, String str) {
        Intrinsics.f(code, "code");
        this.f21185a = code;
        this.f21186b = str;
    }

    public final String a() {
        return this.f21185a;
    }

    public final String b() {
        return this.f21186b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CancellationReason) {
            CancellationReason cancellationReason = (CancellationReason) obj;
            return Intrinsics.a(this.f21185a, cancellationReason.f21185a) && Intrinsics.a(this.f21186b, cancellationReason.f21186b);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f21185a.hashCode() * 31;
        String str = this.f21186b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.f21185a;
        String str2 = this.f21186b;
        return "CancellationReason(code=" + str + ", comment=" + str2 + ")";
    }

    public /* synthetic */ CancellationReason(String str, String str2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? "" : str, (i8 & 2) != 0 ? null : str2);
    }
}
