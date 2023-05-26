package ee.mtakso.driver.service.modules.order;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderInfoModel.kt */
/* loaded from: classes3.dex */
public final class SeparatedAddress {

    /* renamed from: a  reason: collision with root package name */
    private final String f24892a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24893b;

    public SeparatedAddress(String firstLine, String str) {
        Intrinsics.f(firstLine, "firstLine");
        this.f24892a = firstLine;
        this.f24893b = str;
    }

    public final String a() {
        return this.f24892a;
    }

    public final String b() {
        return this.f24893b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SeparatedAddress) {
            SeparatedAddress separatedAddress = (SeparatedAddress) obj;
            return Intrinsics.a(this.f24892a, separatedAddress.f24892a) && Intrinsics.a(this.f24893b, separatedAddress.f24893b);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f24892a.hashCode() * 31;
        String str = this.f24893b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.f24892a;
        String str2 = this.f24893b;
        return "SeparatedAddress(firstLine=" + str + ", secondLine=" + str2 + ")";
    }
}
