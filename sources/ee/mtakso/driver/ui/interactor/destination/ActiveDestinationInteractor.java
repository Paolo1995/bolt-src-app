package ee.mtakso.driver.ui.interactor.destination;

import ee.mtakso.driver.network.client.settings.DriverDestination;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.utils.Optional;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActiveDestinationInteractor.kt */
/* loaded from: classes3.dex */
public final class ActiveDestinationInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DriverDestinationsManager f26426a;

    @Inject
    public ActiveDestinationInteractor(DriverDestinationsManager destinationsManager) {
        Intrinsics.f(destinationsManager, "destinationsManager");
        this.f26426a = destinationsManager;
    }

    public final Observable<Optional<DriverDestination>> a() {
        return this.f26426a.F();
    }
}
