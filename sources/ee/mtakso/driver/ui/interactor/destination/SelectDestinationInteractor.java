package ee.mtakso.driver.ui.interactor.destination;

import ee.mtakso.driver.network.client.settings.DriverDestination;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.utils.CompletableExtKt;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectDestinationInteractor.kt */
/* loaded from: classes3.dex */
public final class SelectDestinationInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DriverDestinationsManager f26437a;

    @Inject
    public SelectDestinationInteractor(DriverDestinationsManager destinationsManager) {
        Intrinsics.f(destinationsManager, "destinationsManager");
        this.f26437a = destinationsManager;
    }

    public final Completable a(DriverDestination arg1) {
        Intrinsics.f(arg1, "arg1");
        return CompletableExtKt.a(this.f26437a.x(arg1));
    }
}
