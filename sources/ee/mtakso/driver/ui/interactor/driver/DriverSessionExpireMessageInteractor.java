package ee.mtakso.driver.ui.interactor.driver;

import ee.mtakso.driver.param.DeviceSettings;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverSessionExpireMessageInteractor.kt */
/* loaded from: classes3.dex */
public final class DriverSessionExpireMessageInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DeviceSettings f26463a;

    @Inject
    public DriverSessionExpireMessageInteractor(DeviceSettings deviceSettings) {
        Intrinsics.f(deviceSettings, "deviceSettings");
        this.f26463a = deviceSettings;
    }

    public final Single<Boolean> a() {
        boolean a8 = this.f26463a.k().a();
        this.f26463a.k().b(false);
        Single<Boolean> w7 = Single.w(Boolean.valueOf(a8));
        Intrinsics.e(w7, "just(logoutDueToSessionExpiry)");
        return w7;
    }
}
