package ee.mtakso.driver.ui.screens.home.v3.header.appearance;

import ee.mtakso.driver.uikit.widgets.RoundButton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RightButton.kt */
/* loaded from: classes3.dex */
public final class RightButton {

    /* renamed from: a  reason: collision with root package name */
    private final SafetyType f30038a;

    /* renamed from: b  reason: collision with root package name */
    private final RoundButton f30039b;

    /* compiled from: RightButton.kt */
    /* loaded from: classes3.dex */
    public enum SafetyType {
        SOS,
        SAFETY_TOOLKIT
    }

    public RightButton(SafetyType type, RoundButton safetyButton) {
        Intrinsics.f(type, "type");
        Intrinsics.f(safetyButton, "safetyButton");
        this.f30038a = type;
        this.f30039b = safetyButton;
    }

    public final RoundButton a() {
        return this.f30039b;
    }

    public final SafetyType b() {
        return this.f30038a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RightButton) {
            RightButton rightButton = (RightButton) obj;
            return this.f30038a == rightButton.f30038a && Intrinsics.a(this.f30039b, rightButton.f30039b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f30038a.hashCode() * 31) + this.f30039b.hashCode();
    }

    public String toString() {
        SafetyType safetyType = this.f30038a;
        RoundButton roundButton = this.f30039b;
        return "RightButton(type=" + safetyType + ", safetyButton=" + roundButton + ")";
    }
}
