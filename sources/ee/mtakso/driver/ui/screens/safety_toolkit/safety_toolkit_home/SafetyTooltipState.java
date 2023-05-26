package ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SafetyTooltipState.kt */
/* loaded from: classes3.dex */
public final class SafetyTooltipState {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f32853a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f32854b;

    public SafetyTooltipState() {
        this(false, false, 3, null);
    }

    public SafetyTooltipState(boolean z7, boolean z8) {
        this.f32853a = z7;
        this.f32854b = z8;
    }

    public final SafetyTooltipState a(boolean z7, boolean z8) {
        return new SafetyTooltipState(z7, z8);
    }

    public final boolean b() {
        return this.f32853a;
    }

    public final boolean c() {
        return this.f32854b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SafetyTooltipState) {
            SafetyTooltipState safetyTooltipState = (SafetyTooltipState) obj;
            return this.f32853a == safetyTooltipState.f32853a && this.f32854b == safetyTooltipState.f32854b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z7 = this.f32853a;
        ?? r02 = z7;
        if (z7) {
            r02 = 1;
        }
        int i8 = r02 * 31;
        boolean z8 = this.f32854b;
        return i8 + (z8 ? 1 : z8 ? 1 : 0);
    }

    public String toString() {
        boolean z7 = this.f32853a;
        boolean z8 = this.f32854b;
        return "SafetyTooltipState(isSafetyToolkitTooltipShown=" + z7 + ", isTripAudioTooltipShown=" + z8 + ")";
    }

    public /* synthetic */ SafetyTooltipState(boolean z7, boolean z8, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? false : z7, (i8 & 2) != 0 ? false : z8);
    }
}
