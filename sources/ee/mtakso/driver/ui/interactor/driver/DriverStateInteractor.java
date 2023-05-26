package ee.mtakso.driver.ui.interactor.driver;

import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverStateInteractor.kt */
/* loaded from: classes3.dex */
public final class DriverStateInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DriverStatusProvider f26472a;

    @Inject
    public DriverStateInteractor(DriverStatusProvider driverStatusProvider) {
        Intrinsics.f(driverStatusProvider, "driverStatusProvider");
        this.f26472a = driverStatusProvider;
    }

    public final Observable<DriverStatus> a() {
        Observable<DriverStatus> observeOn = this.f26472a.g().distinctUntilChanged().observeOn(AndroidSchedulers.a());
        Intrinsics.e(observeOn, "driverStatusProvider.obs…dSchedulers.mainThread())");
        return observeOn;
    }
}
