package ee.mtakso.driver.ui.screens.order.cancel;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.order.RejectReason;
import ee.mtakso.driver.network.client.order.RejectResponseType;
import ee.mtakso.driver.ui.screens.order.cancel.WhyCancelError;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TripCancellationState.kt */
/* loaded from: classes3.dex */
public final class TripCancellationState {

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f31244a;

    /* renamed from: b  reason: collision with root package name */
    private final List<RejectReason> f31245b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f31246c;

    /* renamed from: d  reason: collision with root package name */
    private final String f31247d;

    /* renamed from: e  reason: collision with root package name */
    private final WhyCancelError f31248e;

    /* renamed from: f  reason: collision with root package name */
    private final RejectResponseType f31249f;

    /* renamed from: g  reason: collision with root package name */
    private final String f31250g;

    public TripCancellationState() {
        this(null, null, false, null, null, null, null, 127, null);
    }

    public TripCancellationState(OrderHandle orderHandle, List<RejectReason> list, boolean z7, String comment, WhyCancelError errorState, RejectResponseType cancellationType, String str) {
        Intrinsics.f(comment, "comment");
        Intrinsics.f(errorState, "errorState");
        Intrinsics.f(cancellationType, "cancellationType");
        this.f31244a = orderHandle;
        this.f31245b = list;
        this.f31246c = z7;
        this.f31247d = comment;
        this.f31248e = errorState;
        this.f31249f = cancellationType;
        this.f31250g = str;
    }

    public static /* synthetic */ TripCancellationState b(TripCancellationState tripCancellationState, OrderHandle orderHandle, List list, boolean z7, String str, WhyCancelError whyCancelError, RejectResponseType rejectResponseType, String str2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            orderHandle = tripCancellationState.f31244a;
        }
        List<RejectReason> list2 = list;
        if ((i8 & 2) != 0) {
            list2 = tripCancellationState.f31245b;
        }
        List list3 = list2;
        if ((i8 & 4) != 0) {
            z7 = tripCancellationState.f31246c;
        }
        boolean z8 = z7;
        if ((i8 & 8) != 0) {
            str = tripCancellationState.f31247d;
        }
        String str3 = str;
        if ((i8 & 16) != 0) {
            whyCancelError = tripCancellationState.f31248e;
        }
        WhyCancelError whyCancelError2 = whyCancelError;
        if ((i8 & 32) != 0) {
            rejectResponseType = tripCancellationState.f31249f;
        }
        RejectResponseType rejectResponseType2 = rejectResponseType;
        if ((i8 & 64) != 0) {
            str2 = tripCancellationState.f31250g;
        }
        return tripCancellationState.a(orderHandle, list3, z8, str3, whyCancelError2, rejectResponseType2, str2);
    }

    public final TripCancellationState a(OrderHandle orderHandle, List<RejectReason> list, boolean z7, String comment, WhyCancelError errorState, RejectResponseType cancellationType, String str) {
        Intrinsics.f(comment, "comment");
        Intrinsics.f(errorState, "errorState");
        Intrinsics.f(cancellationType, "cancellationType");
        return new TripCancellationState(orderHandle, list, z7, comment, errorState, cancellationType, str);
    }

    public final RejectResponseType c() {
        return this.f31249f;
    }

    public final String d() {
        return this.f31247d;
    }

    public final WhyCancelError e() {
        return this.f31248e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TripCancellationState) {
            TripCancellationState tripCancellationState = (TripCancellationState) obj;
            return Intrinsics.a(this.f31244a, tripCancellationState.f31244a) && Intrinsics.a(this.f31245b, tripCancellationState.f31245b) && this.f31246c == tripCancellationState.f31246c && Intrinsics.a(this.f31247d, tripCancellationState.f31247d) && Intrinsics.a(this.f31248e, tripCancellationState.f31248e) && this.f31249f == tripCancellationState.f31249f && Intrinsics.a(this.f31250g, tripCancellationState.f31250g);
        }
        return false;
    }

    public final boolean f() {
        return this.f31246c;
    }

    public final OrderHandle g() {
        return this.f31244a;
    }

    public final List<RejectReason> h() {
        return this.f31245b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        OrderHandle orderHandle = this.f31244a;
        int hashCode = (orderHandle == null ? 0 : orderHandle.hashCode()) * 31;
        List<RejectReason> list = this.f31245b;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        boolean z7 = this.f31246c;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int hashCode3 = (((((((hashCode2 + i8) * 31) + this.f31247d.hashCode()) * 31) + this.f31248e.hashCode()) * 31) + this.f31249f.hashCode()) * 31;
        String str = this.f31250g;
        return hashCode3 + (str != null ? str.hashCode() : 0);
    }

    public final String i() {
        return this.f31250g;
    }

    public String toString() {
        OrderHandle orderHandle = this.f31244a;
        List<RejectReason> list = this.f31245b;
        boolean z7 = this.f31246c;
        String str = this.f31247d;
        WhyCancelError whyCancelError = this.f31248e;
        RejectResponseType rejectResponseType = this.f31249f;
        String str2 = this.f31250g;
        return "TripCancellationState(orderHandle=" + orderHandle + ", reasonList=" + list + ", needComment=" + z7 + ", comment=" + str + ", errorState=" + whyCancelError + ", cancellationType=" + rejectResponseType + ", selectedReasonCode=" + str2 + ")";
    }

    public /* synthetic */ TripCancellationState(OrderHandle orderHandle, List list, boolean z7, String str, WhyCancelError whyCancelError, RejectResponseType rejectResponseType, String str2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? null : orderHandle, (i8 & 2) != 0 ? null : list, (i8 & 4) != 0 ? false : z7, (i8 & 8) != 0 ? "" : str, (i8 & 16) != 0 ? WhyCancelError.None.f31277a : whyCancelError, (i8 & 32) != 0 ? RejectResponseType.REASONS_REQUIRED : rejectResponseType, (i8 & 64) != 0 ? null : str2);
    }
}
