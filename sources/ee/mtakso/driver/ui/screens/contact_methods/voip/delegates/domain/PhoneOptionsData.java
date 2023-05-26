package ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactOptionsData.kt */
/* loaded from: classes3.dex */
public final class PhoneOptionsData {

    /* renamed from: a  reason: collision with root package name */
    private final String f27922a;

    public PhoneOptionsData(String phone) {
        Intrinsics.f(phone, "phone");
        this.f27922a = phone;
    }

    public final String a() {
        return this.f27922a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PhoneOptionsData) && Intrinsics.a(this.f27922a, ((PhoneOptionsData) obj).f27922a);
    }

    public int hashCode() {
        return this.f27922a.hashCode();
    }

    public String toString() {
        String str = this.f27922a;
        return "PhoneOptionsData(phone=" + str + ")";
    }
}
