package ee.mtakso.driver.service.quickaccess;

import ee.mtakso.driver.service.quickaccess.QuickAccessService;
import ee.mtakso.driver.utils.RxUtils;
import io.reactivex.Observable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: QuickAccessService.kt */
/* loaded from: classes3.dex */
/* synthetic */ class QuickAccessService$onStartCommand$7 extends FunctionReferenceImpl implements Function1<Observable<QuickAccessService.StatusOrderData>, Observable<QuickAccessService.StatusOrderData>> {

    /* renamed from: o  reason: collision with root package name */
    public static final QuickAccessService$onStartCommand$7 f25774o = new QuickAccessService$onStartCommand$7();

    QuickAccessService$onStartCommand$7() {
        super(1, RxUtils.class, "applyComputationSchedulers", "applyComputationSchedulers(Lio/reactivex/Observable;)Lio/reactivex/Observable;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: j */
    public final Observable<QuickAccessService.StatusOrderData> invoke(Observable<QuickAccessService.StatusOrderData> observable) {
        return RxUtils.a(observable);
    }
}
