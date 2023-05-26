package ee.mtakso.driver.ui.screens.earnings.v3.goal;

import ee.mtakso.driver.ui.screens.earnings.v3.common.CurrencyConfig;
import ee.mtakso.driver.uikit.utils.Text;
import j$.util.Spliterator;
import java.math.BigDecimal;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsGoalState.kt */
/* loaded from: classes3.dex */
public final class EarningsGoalState {

    /* renamed from: a  reason: collision with root package name */
    private final EarningsGoalActionStatus f29200a;

    /* renamed from: b  reason: collision with root package name */
    private final EarningsGoalActionStatus f29201b;

    /* renamed from: c  reason: collision with root package name */
    private final EarningsGoalActionStatus f29202c;

    /* renamed from: d  reason: collision with root package name */
    private final BigDecimal f29203d;

    /* renamed from: e  reason: collision with root package name */
    private final Text f29204e;

    /* renamed from: f  reason: collision with root package name */
    private final List<EarningsGoalPeriod> f29205f;

    /* renamed from: g  reason: collision with root package name */
    private final List<EarningsGoalExpense> f29206g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f29207h;

    /* renamed from: i  reason: collision with root package name */
    private final CurrencyConfig f29208i;

    /* renamed from: j  reason: collision with root package name */
    private final Throwable f29209j;

    public EarningsGoalState() {
        this(null, null, null, null, null, null, null, false, null, null, 1023, null);
    }

    public EarningsGoalState(EarningsGoalActionStatus earningsGoalActionStatus, EarningsGoalActionStatus earningsGoalActionStatus2, EarningsGoalActionStatus earningsGoalActionStatus3, BigDecimal bigDecimal, Text text, List<EarningsGoalPeriod> periods, List<EarningsGoalExpense> expenses, boolean z7, CurrencyConfig currencyConfig, Throwable th) {
        Intrinsics.f(periods, "periods");
        Intrinsics.f(expenses, "expenses");
        Intrinsics.f(currencyConfig, "currencyConfig");
        this.f29200a = earningsGoalActionStatus;
        this.f29201b = earningsGoalActionStatus2;
        this.f29202c = earningsGoalActionStatus3;
        this.f29203d = bigDecimal;
        this.f29204e = text;
        this.f29205f = periods;
        this.f29206g = expenses;
        this.f29207h = z7;
        this.f29208i = currencyConfig;
        this.f29209j = th;
    }

    public final EarningsGoalState a(EarningsGoalActionStatus earningsGoalActionStatus, EarningsGoalActionStatus earningsGoalActionStatus2, EarningsGoalActionStatus earningsGoalActionStatus3, BigDecimal bigDecimal, Text text, List<EarningsGoalPeriod> periods, List<EarningsGoalExpense> expenses, boolean z7, CurrencyConfig currencyConfig, Throwable th) {
        Intrinsics.f(periods, "periods");
        Intrinsics.f(expenses, "expenses");
        Intrinsics.f(currencyConfig, "currencyConfig");
        return new EarningsGoalState(earningsGoalActionStatus, earningsGoalActionStatus2, earningsGoalActionStatus3, bigDecimal, text, periods, expenses, z7, currencyConfig, th);
    }

    public final EarningsGoalActionStatus c() {
        return this.f29200a;
    }

    public final CurrencyConfig d() {
        return this.f29208i;
    }

    public final boolean e() {
        return this.f29207h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EarningsGoalState) {
            EarningsGoalState earningsGoalState = (EarningsGoalState) obj;
            return this.f29200a == earningsGoalState.f29200a && this.f29201b == earningsGoalState.f29201b && this.f29202c == earningsGoalState.f29202c && Intrinsics.a(this.f29203d, earningsGoalState.f29203d) && Intrinsics.a(this.f29204e, earningsGoalState.f29204e) && Intrinsics.a(this.f29205f, earningsGoalState.f29205f) && Intrinsics.a(this.f29206g, earningsGoalState.f29206g) && this.f29207h == earningsGoalState.f29207h && Intrinsics.a(this.f29208i, earningsGoalState.f29208i) && Intrinsics.a(this.f29209j, earningsGoalState.f29209j);
        }
        return false;
    }

    public final EarningsGoalActionStatus f() {
        return this.f29202c;
    }

    public final List<EarningsGoalExpense> g() {
        return this.f29206g;
    }

    public final List<EarningsGoalPeriod> h() {
        return this.f29205f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        EarningsGoalActionStatus earningsGoalActionStatus = this.f29200a;
        int hashCode = (earningsGoalActionStatus == null ? 0 : earningsGoalActionStatus.hashCode()) * 31;
        EarningsGoalActionStatus earningsGoalActionStatus2 = this.f29201b;
        int hashCode2 = (hashCode + (earningsGoalActionStatus2 == null ? 0 : earningsGoalActionStatus2.hashCode())) * 31;
        EarningsGoalActionStatus earningsGoalActionStatus3 = this.f29202c;
        int hashCode3 = (hashCode2 + (earningsGoalActionStatus3 == null ? 0 : earningsGoalActionStatus3.hashCode())) * 31;
        BigDecimal bigDecimal = this.f29203d;
        int hashCode4 = (hashCode3 + (bigDecimal == null ? 0 : bigDecimal.hashCode())) * 31;
        Text text = this.f29204e;
        int hashCode5 = (((((hashCode4 + (text == null ? 0 : text.hashCode())) * 31) + this.f29205f.hashCode()) * 31) + this.f29206g.hashCode()) * 31;
        boolean z7 = this.f29207h;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int hashCode6 = (((hashCode5 + i8) * 31) + this.f29208i.hashCode()) * 31;
        Throwable th = this.f29209j;
        return hashCode6 + (th != null ? th.hashCode() : 0);
    }

    public final BigDecimal i() {
        return this.f29203d;
    }

    public final Text j() {
        return this.f29204e;
    }

    public final Throwable k() {
        return this.f29209j;
    }

    public final EarningsGoalActionStatus l() {
        return this.f29201b;
    }

    public String toString() {
        EarningsGoalActionStatus earningsGoalActionStatus = this.f29200a;
        EarningsGoalActionStatus earningsGoalActionStatus2 = this.f29201b;
        EarningsGoalActionStatus earningsGoalActionStatus3 = this.f29202c;
        BigDecimal bigDecimal = this.f29203d;
        Text text = this.f29204e;
        List<EarningsGoalPeriod> list = this.f29205f;
        List<EarningsGoalExpense> list2 = this.f29206g;
        boolean z7 = this.f29207h;
        CurrencyConfig currencyConfig = this.f29208i;
        Throwable th = this.f29209j;
        return "EarningsGoalState(contentStatus=" + earningsGoalActionStatus + ", updateStatus=" + earningsGoalActionStatus2 + ", deleteStatus=" + earningsGoalActionStatus3 + ", target=" + bigDecimal + ", targetError=" + text + ", periods=" + list + ", expenses=" + list2 + ", deletable=" + z7 + ", currencyConfig=" + currencyConfig + ", throwable=" + th + ")";
    }

    public /* synthetic */ EarningsGoalState(EarningsGoalActionStatus earningsGoalActionStatus, EarningsGoalActionStatus earningsGoalActionStatus2, EarningsGoalActionStatus earningsGoalActionStatus3, BigDecimal bigDecimal, Text text, List list, List list2, boolean z7, CurrencyConfig currencyConfig, Throwable th, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? null : earningsGoalActionStatus, (i8 & 2) != 0 ? null : earningsGoalActionStatus2, (i8 & 4) != 0 ? null : earningsGoalActionStatus3, (i8 & 8) != 0 ? null : bigDecimal, (i8 & 16) != 0 ? null : text, (i8 & 32) != 0 ? CollectionsKt__CollectionsKt.k() : list, (i8 & 64) != 0 ? CollectionsKt__CollectionsKt.k() : list2, (i8 & 128) != 0 ? false : z7, (i8 & Spliterator.NONNULL) != 0 ? new CurrencyConfig(null, false, 3, null) : currencyConfig, (i8 & 512) == 0 ? th : null);
    }
}
