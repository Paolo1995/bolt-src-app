package ee.mtakso.driver.ui.screens.earnings.v3.breakdown;

import eu.bolt.driver.earnings.network.EarningBreakdownIntervals;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsBreakdownStateExt.kt */
/* loaded from: classes3.dex */
public final class EarningsBreakdownStateExt {

    /* renamed from: a  reason: collision with root package name */
    public static final EarningsBreakdownStateExt f28944a = new EarningsBreakdownStateExt();

    private EarningsBreakdownStateExt() {
    }

    public final EarningBreakdownIntervals.Interval a(EarningsBreakdownState earningsBreakdownState) {
        Intrinsics.f(earningsBreakdownState, "<this>");
        EarningBreakdownIntervals.Mode b8 = b(earningsBreakdownState);
        if (b8 == null || earningsBreakdownState.d() < 0 || b8.a().isEmpty()) {
            return null;
        }
        return b8.a().get(earningsBreakdownState.d());
    }

    public final EarningBreakdownIntervals.Mode b(EarningsBreakdownState earningsBreakdownState) {
        List<EarningBreakdownIntervals.Mode> list;
        boolean z7;
        EarningBreakdownIntervals e8;
        List<EarningBreakdownIntervals.Mode> a8;
        Intrinsics.f(earningsBreakdownState, "<this>");
        if (earningsBreakdownState.g() < 0) {
            return null;
        }
        EarningBreakdownIntervals e9 = earningsBreakdownState.e();
        if (e9 != null) {
            list = e9.a();
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7 || (e8 = earningsBreakdownState.e()) == null || (a8 = e8.a()) == null) {
            return null;
        }
        return a8.get(earningsBreakdownState.g());
    }

    public final boolean c(EarningsBreakdownState earningsBreakdownState) {
        List<EarningBreakdownIntervals.Interval> a8;
        int m8;
        Intrinsics.f(earningsBreakdownState, "<this>");
        EarningBreakdownIntervals.Mode b8 = b(earningsBreakdownState);
        if (b8 == null || (a8 = b8.a()) == null) {
            return false;
        }
        m8 = CollectionsKt__CollectionsKt.m(a8);
        if (earningsBreakdownState.d() >= m8) {
            return false;
        }
        return true;
    }

    public final boolean d(EarningsBreakdownState earningsBreakdownState) {
        Intrinsics.f(earningsBreakdownState, "<this>");
        if (earningsBreakdownState.d() > 0) {
            return true;
        }
        return false;
    }
}
