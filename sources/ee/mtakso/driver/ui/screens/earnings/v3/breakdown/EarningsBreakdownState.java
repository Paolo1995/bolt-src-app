package ee.mtakso.driver.ui.screens.earnings.v3.breakdown;

import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.driver.earnings.network.EarningBreakdownIntervals;
import eu.bolt.driver.earnings.network.EarningBreakdownScreen;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsBreakdownState.kt */
/* loaded from: classes3.dex */
public final class EarningsBreakdownState {

    /* renamed from: a  reason: collision with root package name */
    private final EarningBreakdownScreen f28938a;

    /* renamed from: b  reason: collision with root package name */
    private final EarningBreakdownIntervals f28939b;

    /* renamed from: c  reason: collision with root package name */
    private final int f28940c;

    /* renamed from: d  reason: collision with root package name */
    private final int f28941d;

    /* renamed from: e  reason: collision with root package name */
    private final Text f28942e;

    /* renamed from: f  reason: collision with root package name */
    private final List<ListModel> f28943f;

    public EarningsBreakdownState() {
        this(null, null, 0, 0, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EarningsBreakdownState(EarningBreakdownScreen earningBreakdownScreen, EarningBreakdownIntervals earningBreakdownIntervals, int i8, int i9, Text text, List<? extends ListModel> items) {
        Intrinsics.f(items, "items");
        this.f28938a = earningBreakdownScreen;
        this.f28939b = earningBreakdownIntervals;
        this.f28940c = i8;
        this.f28941d = i9;
        this.f28942e = text;
        this.f28943f = items;
    }

    public static /* synthetic */ EarningsBreakdownState b(EarningsBreakdownState earningsBreakdownState, EarningBreakdownScreen earningBreakdownScreen, EarningBreakdownIntervals earningBreakdownIntervals, int i8, int i9, Text text, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            earningBreakdownScreen = earningsBreakdownState.f28938a;
        }
        if ((i10 & 2) != 0) {
            earningBreakdownIntervals = earningsBreakdownState.f28939b;
        }
        EarningBreakdownIntervals earningBreakdownIntervals2 = earningBreakdownIntervals;
        if ((i10 & 4) != 0) {
            i8 = earningsBreakdownState.f28940c;
        }
        int i11 = i8;
        if ((i10 & 8) != 0) {
            i9 = earningsBreakdownState.f28941d;
        }
        int i12 = i9;
        if ((i10 & 16) != 0) {
            text = earningsBreakdownState.f28942e;
        }
        Text text2 = text;
        List<ListModel> list2 = list;
        if ((i10 & 32) != 0) {
            list2 = earningsBreakdownState.f28943f;
        }
        return earningsBreakdownState.a(earningBreakdownScreen, earningBreakdownIntervals2, i11, i12, text2, list2);
    }

    public final EarningsBreakdownState a(EarningBreakdownScreen earningBreakdownScreen, EarningBreakdownIntervals earningBreakdownIntervals, int i8, int i9, Text text, List<? extends ListModel> items) {
        Intrinsics.f(items, "items");
        return new EarningsBreakdownState(earningBreakdownScreen, earningBreakdownIntervals, i8, i9, text, items);
    }

    public final EarningBreakdownScreen c() {
        return this.f28938a;
    }

    public final int d() {
        return this.f28941d;
    }

    public final EarningBreakdownIntervals e() {
        return this.f28939b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EarningsBreakdownState) {
            EarningsBreakdownState earningsBreakdownState = (EarningsBreakdownState) obj;
            return Intrinsics.a(this.f28938a, earningsBreakdownState.f28938a) && Intrinsics.a(this.f28939b, earningsBreakdownState.f28939b) && this.f28940c == earningsBreakdownState.f28940c && this.f28941d == earningsBreakdownState.f28941d && Intrinsics.a(this.f28942e, earningsBreakdownState.f28942e) && Intrinsics.a(this.f28943f, earningsBreakdownState.f28943f);
        }
        return false;
    }

    public final List<ListModel> f() {
        return this.f28943f;
    }

    public final int g() {
        return this.f28940c;
    }

    public final Text h() {
        return this.f28942e;
    }

    public int hashCode() {
        EarningBreakdownScreen earningBreakdownScreen = this.f28938a;
        int hashCode = (earningBreakdownScreen == null ? 0 : earningBreakdownScreen.hashCode()) * 31;
        EarningBreakdownIntervals earningBreakdownIntervals = this.f28939b;
        int hashCode2 = (((((hashCode + (earningBreakdownIntervals == null ? 0 : earningBreakdownIntervals.hashCode())) * 31) + this.f28940c) * 31) + this.f28941d) * 31;
        Text text = this.f28942e;
        return ((hashCode2 + (text != null ? text.hashCode() : 0)) * 31) + this.f28943f.hashCode();
    }

    public String toString() {
        EarningBreakdownScreen earningBreakdownScreen = this.f28938a;
        EarningBreakdownIntervals earningBreakdownIntervals = this.f28939b;
        int i8 = this.f28940c;
        int i9 = this.f28941d;
        Text text = this.f28942e;
        List<ListModel> list = this.f28943f;
        return "EarningsBreakdownState(data=" + earningBreakdownScreen + ", intervals=" + earningBreakdownIntervals + ", modePosition=" + i8 + ", intervalPosition=" + i9 + ", title=" + text + ", items=" + list + ")";
    }

    public /* synthetic */ EarningsBreakdownState(EarningBreakdownScreen earningBreakdownScreen, EarningBreakdownIntervals earningBreakdownIntervals, int i8, int i9, Text text, List list, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : earningBreakdownScreen, (i10 & 2) != 0 ? null : earningBreakdownIntervals, (i10 & 4) != 0 ? -1 : i8, (i10 & 8) != 0 ? -1 : i9, (i10 & 16) == 0 ? text : null, (i10 & 32) != 0 ? CollectionsKt__CollectionsKt.k() : list);
    }
}
