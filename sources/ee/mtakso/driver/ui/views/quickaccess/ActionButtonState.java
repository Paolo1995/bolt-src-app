package ee.mtakso.driver.ui.views.quickaccess;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuickAccessDetailsState.kt */
/* loaded from: classes5.dex */
public final class ActionButtonState {

    /* renamed from: a  reason: collision with root package name */
    private final CharSequence f34374a;

    /* renamed from: b  reason: collision with root package name */
    private final int f34375b;

    /* renamed from: c  reason: collision with root package name */
    private final int f34376c;

    public ActionButtonState(CharSequence text, int i8, int i9) {
        Intrinsics.f(text, "text");
        this.f34374a = text;
        this.f34375b = i8;
        this.f34376c = i9;
    }

    public final int a() {
        return this.f34375b;
    }

    public final int b() {
        return this.f34376c;
    }

    public final CharSequence c() {
        return this.f34374a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActionButtonState) {
            ActionButtonState actionButtonState = (ActionButtonState) obj;
            return Intrinsics.a(this.f34374a, actionButtonState.f34374a) && this.f34375b == actionButtonState.f34375b && this.f34376c == actionButtonState.f34376c;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f34374a.hashCode() * 31) + this.f34375b) * 31) + this.f34376c;
    }

    public String toString() {
        CharSequence charSequence = this.f34374a;
        int i8 = this.f34375b;
        int i9 = this.f34376c;
        return "ActionButtonState(text=" + ((Object) charSequence) + ", bgColor=" + i8 + ", rippleColor=" + i9 + ")";
    }
}
