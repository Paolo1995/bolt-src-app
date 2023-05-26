package ee.mtakso.driver.ui.screens.order.finish;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: RightButtonState.kt */
/* loaded from: classes3.dex */
public final class RightButtonState {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f31348a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f31349b;

    public RightButtonState() {
        this(false, false, 3, null);
    }

    public RightButtonState(boolean z7, boolean z8) {
        this.f31348a = z7;
        this.f31349b = z8;
    }

    public final boolean a() {
        return this.f31349b;
    }

    public final boolean b() {
        return this.f31348a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RightButtonState) {
            RightButtonState rightButtonState = (RightButtonState) obj;
            return this.f31348a == rightButtonState.f31348a && this.f31349b == rightButtonState.f31349b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z7 = this.f31348a;
        ?? r02 = z7;
        if (z7) {
            r02 = 1;
        }
        int i8 = r02 * 31;
        boolean z8 = this.f31349b;
        return i8 + (z8 ? 1 : z8 ? 1 : 0);
    }

    public String toString() {
        boolean z7 = this.f31348a;
        boolean z8 = this.f31349b;
        return "RightButtonState(isSosEnabled=" + z7 + ", isSafetyToolkitEnabled=" + z8 + ")";
    }

    public /* synthetic */ RightButtonState(boolean z7, boolean z8, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? false : z7, (i8 & 2) != 0 ? false : z8);
    }
}
