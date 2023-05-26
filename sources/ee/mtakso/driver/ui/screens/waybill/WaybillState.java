package ee.mtakso.driver.ui.screens.waybill;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: WaybillState.kt */
/* loaded from: classes5.dex */
public final class WaybillState {

    /* renamed from: a  reason: collision with root package name */
    private final String f33621a;

    public WaybillState(String html) {
        Intrinsics.f(html, "html");
        this.f33621a = html;
    }

    public final String a() {
        return this.f33621a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WaybillState) && Intrinsics.a(this.f33621a, ((WaybillState) obj).f33621a);
    }

    public int hashCode() {
        return this.f33621a.hashCode();
    }

    public String toString() {
        String str = this.f33621a;
        return "WaybillState(html=" + str + ")";
    }
}
