package ee.mtakso.driver.ui.interactor.income.report;

import ee.mtakso.driver.network.client.earnings.EarningsChartResponse;
import ee.mtakso.driver.network.client.earnings.EarningsClient;
import ee.mtakso.driver.network.client.earnings.EarningsScreenType;
import ee.mtakso.driver.network.client.earnings.ReportScreen;
import ee.mtakso.driver.utils.Optional;
import io.reactivex.Single;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReportPageInteractor.kt */
/* loaded from: classes3.dex */
public final class ReportPageInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final EarningsClient f26590a;

    /* renamed from: b  reason: collision with root package name */
    private final ReportItemsMapper f26591b;

    /* renamed from: c  reason: collision with root package name */
    private final ChartMapper f26592c;

    /* compiled from: ReportPageInteractor.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f26593a;

        static {
            int[] iArr = new int[EarningsScreenType.values().length];
            try {
                iArr[EarningsScreenType.FULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EarningsScreenType.BALANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EarningsScreenType.EARNINGS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f26593a = iArr;
        }
    }

    @Inject
    public ReportPageInteractor(EarningsClient earningsClient, ReportItemsMapper reportItemsMapper, ChartMapper chartMapper) {
        Intrinsics.f(earningsClient, "earningsClient");
        Intrinsics.f(reportItemsMapper, "reportItemsMapper");
        Intrinsics.f(chartMapper, "chartMapper");
        this.f26590a = earningsClient;
        this.f26591b = reportItemsMapper;
        this.f26592c = chartMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReportPageData f(ReportPageResponse reportPageResponse, final String str) {
        Optional<R> e8 = reportPageResponse.a().e(new Function() { // from class: ee.mtakso.driver.ui.interactor.income.report.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ChartData g8;
                g8 = ReportPageInteractor.g(ReportPageInteractor.this, str, (EarningsChartResponse) obj);
                return g8;
            }
        });
        Intrinsics.e(e8, "pageResponse.chart.map {…reateChartData(it, key) }");
        return new ReportPageData(this.f26591b.c(reportPageResponse.b().a()), e8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChartData g(ReportPageInteractor this$0, String key, EarningsChartResponse it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(key, "$key");
        Intrinsics.f(it, "it");
        return this$0.f26592c.b(it, key);
    }

    private final Single<ReportPageResponse> h(String str) {
        Single<ReportScreen> c8 = this.f26590a.c(str, EarningsScreenType.BALANCE.getInternalId());
        final ReportPageInteractor$loadBalancePage$1 reportPageInteractor$loadBalancePage$1 = new Function1<ReportScreen, ReportPageResponse>() { // from class: ee.mtakso.driver.ui.interactor.income.report.ReportPageInteractor$loadBalancePage$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ReportPageResponse invoke(ReportScreen it) {
                Intrinsics.f(it, "it");
                Optional a8 = Optional.a();
                Intrinsics.e(a8, "empty()");
                return new ReportPageResponse(a8, it);
            }
        };
        Single x7 = c8.x(new Function() { // from class: ee.mtakso.driver.ui.interactor.income.report.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ReportPageResponse i8;
                i8 = ReportPageInteractor.i(Function1.this, obj);
                return i8;
            }
        });
        Intrinsics.e(x7, "earningsClient.getInvoic…mpty(), it)\n            }");
        return x7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReportPageResponse i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ReportPageResponse) tmp0.invoke(obj);
    }

    private final Single<ReportPageResponse> j(String str) {
        Single<ReportScreen> c8 = this.f26590a.c(str, EarningsScreenType.EARNINGS.getInternalId());
        Single<EarningsChartResponse> a8 = this.f26590a.a(str);
        final ReportPageInteractor$loadEarningsPage$1 reportPageInteractor$loadEarningsPage$1 = new Function2<ReportScreen, EarningsChartResponse, ReportPageResponse>() { // from class: ee.mtakso.driver.ui.interactor.income.report.ReportPageInteractor$loadEarningsPage$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final ReportPageResponse s(ReportScreen report, EarningsChartResponse chart) {
                Intrinsics.f(report, "report");
                Intrinsics.f(chart, "chart");
                Optional f8 = Optional.f(chart);
                Intrinsics.e(f8, "of(chart)");
                return new ReportPageResponse(f8, report);
            }
        };
        Single<ReportPageResponse> V = Single.V(c8, a8, new BiFunction() { // from class: ee.mtakso.driver.ui.interactor.income.report.d
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                ReportPageResponse k8;
                k8 = ReportPageInteractor.k(Function2.this, obj, obj2);
                return k8;
            }
        });
        Intrinsics.e(V, "zip(\n            earning…)\n            }\n        )");
        return V;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReportPageResponse k(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ReportPageResponse) tmp0.s(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReportPageData m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ReportPageData) tmp0.invoke(obj);
    }

    public final Single<ReportPageData> l(final String key, EarningsScreenType mode) {
        Single<ReportPageResponse> h8;
        Intrinsics.f(key, "key");
        Intrinsics.f(mode, "mode");
        int i8 = WhenMappings.f26593a[mode.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    h8 = j(key);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                h8 = h(key);
            }
        } else {
            h8 = h(key);
        }
        final Function1<ReportPageResponse, ReportPageData> function1 = new Function1<ReportPageResponse, ReportPageData>() { // from class: ee.mtakso.driver.ui.interactor.income.report.ReportPageInteractor$loadPageData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ReportPageData invoke(ReportPageResponse it) {
                ReportPageData f8;
                Intrinsics.f(it, "it");
                f8 = ReportPageInteractor.this.f(it, key);
                return f8;
            }
        };
        Single x7 = h8.x(new Function() { // from class: ee.mtakso.driver.ui.interactor.income.report.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ReportPageData m8;
                m8 = ReportPageInteractor.m(Function1.this, obj);
                return m8;
            }
        });
        Intrinsics.e(x7, "fun loadPageData(key: St…portData(it, key) }\n    }");
        return x7;
    }
}
