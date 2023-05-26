package ee.mtakso.driver.ui.interactor.destination;

import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.utils.CompletableExtKt;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeactivateDestinationInteractor.kt */
/* loaded from: classes3.dex */
public final class DeactivateDestinationInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DriverDestinationsManager f26428a;

    @Inject
    public DeactivateDestinationInteractor(DriverDestinationsManager destinationsManager) {
        Intrinsics.f(destinationsManager, "destinationsManager");
        this.f26428a = destinationsManager;
    }

    public final Completable a() {
        Completable v7 = this.f26428a.y().v();
        Intrinsics.e(v7, "destinationsManager.deac…         .ignoreElement()");
        return CompletableExtKt.a(v7);
    }
}
