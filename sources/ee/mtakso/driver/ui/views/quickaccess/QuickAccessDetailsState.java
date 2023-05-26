package ee.mtakso.driver.ui.views.quickaccess;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuickAccessDetailsState.kt */
/* loaded from: classes5.dex */
public final class QuickAccessDetailsState {

    /* renamed from: a  reason: collision with root package name */
    private final CharSequence f34435a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f34436b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence f34437c;

    /* renamed from: d  reason: collision with root package name */
    private final ActionButtonState f34438d;

    /* renamed from: e  reason: collision with root package name */
    private final PaidWaitingButtonState f34439e;

    /* renamed from: f  reason: collision with root package name */
    private final QuickAccessRatingState f34440f;

    /* renamed from: g  reason: collision with root package name */
    private final QuickAccessTimerState f34441g;

    public QuickAccessDetailsState(CharSequence title, CharSequence firstLine, CharSequence secondLine, ActionButtonState actionButton, PaidWaitingButtonState paidWaitingButtonState, QuickAccessRatingState quickAccessRatingState, QuickAccessTimerState quickAccessTimerState) {
        Intrinsics.f(title, "title");
        Intrinsics.f(firstLine, "firstLine");
        Intrinsics.f(secondLine, "secondLine");
        Intrinsics.f(actionButton, "actionButton");
        this.f34435a = title;
        this.f34436b = firstLine;
        this.f34437c = secondLine;
        this.f34438d = actionButton;
        this.f34439e = paidWaitingButtonState;
        this.f34440f = quickAccessRatingState;
        this.f34441g = quickAccessTimerState;
    }

    public final ActionButtonState a() {
        return this.f34438d;
    }

    public final CharSequence b() {
        return this.f34436b;
    }

    public final PaidWaitingButtonState c() {
        return this.f34439e;
    }

    public final QuickAccessRatingState d() {
        return this.f34440f;
    }

    public final CharSequence e() {
        return this.f34437c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QuickAccessDetailsState) {
            QuickAccessDetailsState quickAccessDetailsState = (QuickAccessDetailsState) obj;
            return Intrinsics.a(this.f34435a, quickAccessDetailsState.f34435a) && Intrinsics.a(this.f34436b, quickAccessDetailsState.f34436b) && Intrinsics.a(this.f34437c, quickAccessDetailsState.f34437c) && Intrinsics.a(this.f34438d, quickAccessDetailsState.f34438d) && Intrinsics.a(this.f34439e, quickAccessDetailsState.f34439e) && Intrinsics.a(this.f34440f, quickAccessDetailsState.f34440f) && Intrinsics.a(this.f34441g, quickAccessDetailsState.f34441g);
        }
        return false;
    }

    public final QuickAccessTimerState f() {
        return this.f34441g;
    }

    public final CharSequence g() {
        return this.f34435a;
    }

    public int hashCode() {
        int hashCode = ((((((this.f34435a.hashCode() * 31) + this.f34436b.hashCode()) * 31) + this.f34437c.hashCode()) * 31) + this.f34438d.hashCode()) * 31;
        PaidWaitingButtonState paidWaitingButtonState = this.f34439e;
        int hashCode2 = (hashCode + (paidWaitingButtonState == null ? 0 : paidWaitingButtonState.hashCode())) * 31;
        QuickAccessRatingState quickAccessRatingState = this.f34440f;
        int hashCode3 = (hashCode2 + (quickAccessRatingState == null ? 0 : quickAccessRatingState.hashCode())) * 31;
        QuickAccessTimerState quickAccessTimerState = this.f34441g;
        return hashCode3 + (quickAccessTimerState != null ? quickAccessTimerState.hashCode() : 0);
    }

    public String toString() {
        CharSequence charSequence = this.f34435a;
        CharSequence charSequence2 = this.f34436b;
        CharSequence charSequence3 = this.f34437c;
        ActionButtonState actionButtonState = this.f34438d;
        PaidWaitingButtonState paidWaitingButtonState = this.f34439e;
        QuickAccessRatingState quickAccessRatingState = this.f34440f;
        QuickAccessTimerState quickAccessTimerState = this.f34441g;
        return "QuickAccessDetailsState(title=" + ((Object) charSequence) + ", firstLine=" + ((Object) charSequence2) + ", secondLine=" + ((Object) charSequence3) + ", actionButton=" + actionButtonState + ", paidWaitingButton=" + paidWaitingButtonState + ", ratingState=" + quickAccessRatingState + ", timerState=" + quickAccessTimerState + ")";
    }

    public /* synthetic */ QuickAccessDetailsState(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, ActionButtonState actionButtonState, PaidWaitingButtonState paidWaitingButtonState, QuickAccessRatingState quickAccessRatingState, QuickAccessTimerState quickAccessTimerState, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? "" : charSequence, (i8 & 2) != 0 ? "" : charSequence2, (i8 & 4) != 0 ? "" : charSequence3, actionButtonState, (i8 & 16) != 0 ? null : paidWaitingButtonState, (i8 & 32) != 0 ? null : quickAccessRatingState, (i8 & 64) != 0 ? null : quickAccessTimerState);
    }
}
