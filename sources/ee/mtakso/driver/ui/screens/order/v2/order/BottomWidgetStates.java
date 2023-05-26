package ee.mtakso.driver.ui.screens.order.v2.order;

import ee.mtakso.driver.network.client.order.PaymentType;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomWidgetStates.kt */
/* loaded from: classes3.dex */
public final class BottomWidgetStates {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f32190a;

    /* renamed from: b  reason: collision with root package name */
    private final BottomBarState f32191b;

    /* renamed from: c  reason: collision with root package name */
    private final SwipeButtonState f32192c;

    /* renamed from: d  reason: collision with root package name */
    private final SwipeButtonOverrideState f32193d;

    /* renamed from: e  reason: collision with root package name */
    private final PaymentType f32194e;

    /* renamed from: f  reason: collision with root package name */
    private final long f32195f;

    public BottomWidgetStates(boolean z7, BottomBarState bottomBarState, SwipeButtonState swipeButtonState, SwipeButtonOverrideState swipeButtonOverrideState, PaymentType paymentType, long j8) {
        Intrinsics.f(bottomBarState, "bottomBarState");
        Intrinsics.f(swipeButtonState, "swipeButtonState");
        this.f32190a = z7;
        this.f32191b = bottomBarState;
        this.f32192c = swipeButtonState;
        this.f32193d = swipeButtonOverrideState;
        this.f32194e = paymentType;
        this.f32195f = j8;
    }

    public static /* synthetic */ BottomWidgetStates b(BottomWidgetStates bottomWidgetStates, boolean z7, BottomBarState bottomBarState, SwipeButtonState swipeButtonState, SwipeButtonOverrideState swipeButtonOverrideState, PaymentType paymentType, long j8, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = bottomWidgetStates.f32190a;
        }
        if ((i8 & 2) != 0) {
            bottomBarState = bottomWidgetStates.f32191b;
        }
        BottomBarState bottomBarState2 = bottomBarState;
        if ((i8 & 4) != 0) {
            swipeButtonState = bottomWidgetStates.f32192c;
        }
        SwipeButtonState swipeButtonState2 = swipeButtonState;
        if ((i8 & 8) != 0) {
            swipeButtonOverrideState = bottomWidgetStates.f32193d;
        }
        SwipeButtonOverrideState swipeButtonOverrideState2 = swipeButtonOverrideState;
        if ((i8 & 16) != 0) {
            paymentType = bottomWidgetStates.f32194e;
        }
        PaymentType paymentType2 = paymentType;
        if ((i8 & 32) != 0) {
            j8 = bottomWidgetStates.f32195f;
        }
        return bottomWidgetStates.a(z7, bottomBarState2, swipeButtonState2, swipeButtonOverrideState2, paymentType2, j8);
    }

    public final BottomWidgetStates a(boolean z7, BottomBarState bottomBarState, SwipeButtonState swipeButtonState, SwipeButtonOverrideState swipeButtonOverrideState, PaymentType paymentType, long j8) {
        Intrinsics.f(bottomBarState, "bottomBarState");
        Intrinsics.f(swipeButtonState, "swipeButtonState");
        return new BottomWidgetStates(z7, bottomBarState, swipeButtonState, swipeButtonOverrideState, paymentType, j8);
    }

    public final BottomBarState c() {
        return this.f32191b;
    }

    public final PaymentType d() {
        return this.f32194e;
    }

    public final boolean e() {
        return this.f32190a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BottomWidgetStates) {
            BottomWidgetStates bottomWidgetStates = (BottomWidgetStates) obj;
            return this.f32190a == bottomWidgetStates.f32190a && this.f32191b == bottomWidgetStates.f32191b && this.f32192c == bottomWidgetStates.f32192c && this.f32193d == bottomWidgetStates.f32193d && this.f32194e == bottomWidgetStates.f32194e && this.f32195f == bottomWidgetStates.f32195f;
        }
        return false;
    }

    public final SwipeButtonOverrideState f() {
        return this.f32193d;
    }

    public final SwipeButtonState g() {
        return this.f32192c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public int hashCode() {
        boolean z7 = this.f32190a;
        ?? r02 = z7;
        if (z7) {
            r02 = 1;
        }
        int hashCode = ((((r02 * 31) + this.f32191b.hashCode()) * 31) + this.f32192c.hashCode()) * 31;
        SwipeButtonOverrideState swipeButtonOverrideState = this.f32193d;
        int hashCode2 = (hashCode + (swipeButtonOverrideState == null ? 0 : swipeButtonOverrideState.hashCode())) * 31;
        PaymentType paymentType = this.f32194e;
        return ((hashCode2 + (paymentType != null ? paymentType.hashCode() : 0)) * 31) + i0.a.a(this.f32195f);
    }

    public String toString() {
        boolean z7 = this.f32190a;
        BottomBarState bottomBarState = this.f32191b;
        SwipeButtonState swipeButtonState = this.f32192c;
        SwipeButtonOverrideState swipeButtonOverrideState = this.f32193d;
        PaymentType paymentType = this.f32194e;
        long j8 = this.f32195f;
        return "BottomWidgetStates(shouldAnimateStatusChange=" + z7 + ", bottomBarState=" + bottomBarState + ", swipeButtonState=" + swipeButtonState + ", swipeButtonOverrideState=" + swipeButtonOverrideState + ", paymentType=" + paymentType + ", firstStopId=" + j8 + ")";
    }
}
