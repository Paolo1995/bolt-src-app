package ee.mtakso.driver.ui.interactor.driver;

import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DistinctDriverStateInteractor.kt */
/* loaded from: classes3.dex */
public final class DistinctDriverStateInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DriverStatusProvider f26445a;

    @Inject
    public DistinctDriverStateInteractor(DriverStatusProvider driverStatusProvider) {
        Intrinsics.f(driverStatusProvider, "driverStatusProvider");
        this.f26445a = driverStatusProvider;
    }

    public final Observable<DriverStatus> a() {
        Observable<DriverStatus> observeOn = this.f26445a.g().distinctUntilChanged().observeOn(AndroidSchedulers.a());
        Intrinsics.e(observeOn, "driverStatusProvider.obs…dSchedulers.mainThread())");
        return observeOn;
    }
}
