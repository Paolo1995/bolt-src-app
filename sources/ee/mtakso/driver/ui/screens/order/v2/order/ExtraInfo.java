package ee.mtakso.driver.ui.screens.order.v2.order;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScreenState.kt */
/* loaded from: classes3.dex */
public final class ExtraInfo {

    /* renamed from: a  reason: collision with root package name */
    private final String f32207a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f32208b;

    public ExtraInfo(String message, boolean z7) {
        Intrinsics.f(message, "message");
        this.f32207a = message;
        this.f32208b = z7;
    }

    public final String a() {
        return this.f32207a;
    }

    public final boolean b() {
        return this.f32208b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ExtraInfo) {
            ExtraInfo extraInfo = (ExtraInfo) obj;
            return Intrinsics.a(this.f32207a, extraInfo.f32207a) && this.f32208b == extraInfo.f32208b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f32207a.hashCode() * 31;
        boolean z7 = this.f32208b;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        String str = this.f32207a;
        boolean z7 = this.f32208b;
        return "ExtraInfo(message=" + str + ", wasShown=" + z7 + ")";
    }
}
