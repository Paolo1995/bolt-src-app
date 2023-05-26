package ee.mtakso.driver.network.client.order;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateClientInfo.kt */
/* loaded from: classes3.dex */
public final class RateClientInfo {

    /* renamed from: a  reason: collision with root package name */
    private final int f22518a;

    /* renamed from: b  reason: collision with root package name */
    private final String f22519b;

    /* renamed from: c  reason: collision with root package name */
    private final String f22520c;

    public RateClientInfo(int i8, String str, String comment) {
        Intrinsics.f(comment, "comment");
        this.f22518a = i8;
        this.f22519b = str;
        this.f22520c = comment;
    }

    public final String a() {
        return this.f22520c;
    }

    public final String b() {
        return this.f22519b;
    }

    public final int c() {
        return this.f22518a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RateClientInfo) {
            RateClientInfo rateClientInfo = (RateClientInfo) obj;
            return this.f22518a == rateClientInfo.f22518a && Intrinsics.a(this.f22519b, rateClientInfo.f22519b) && Intrinsics.a(this.f22520c, rateClientInfo.f22520c);
        }
        return false;
    }

    public int hashCode() {
        int i8 = this.f22518a * 31;
        String str = this.f22519b;
        return ((i8 + (str == null ? 0 : str.hashCode())) * 31) + this.f22520c.hashCode();
    }

    public String toString() {
        int i8 = this.f22518a;
        String str = this.f22519b;
        String str2 = this.f22520c;
        return "RateClientInfo(rating=" + i8 + ", problem=" + str + ", comment=" + str2 + ")";
    }
}
