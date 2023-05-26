package ee.mtakso.driver.ui.interactor.destination;

import ee.mtakso.driver.service.modules.driverdestinations.DestinationLimit;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.utils.ObservableExtKt;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DestinationLimitInteractor.kt */
/* loaded from: classes3.dex */
public final class DestinationLimitInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DriverDestinationsManager f26432a;

    @Inject
    public DestinationLimitInteractor(DriverDestinationsManager destinationsManager) {
        Intrinsics.f(destinationsManager, "destinationsManager");
        this.f26432a = destinationsManager;
    }

    public final Observable<DestinationLimit> a() {
        return ObservableExtKt.g(this.f26432a.G());
    }
}
