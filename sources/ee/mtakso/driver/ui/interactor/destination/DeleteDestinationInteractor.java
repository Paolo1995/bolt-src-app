package ee.mtakso.driver.ui.interactor.destination;

import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.utils.CompletableExtKt;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeleteDestinationInteractor.kt */
/* loaded from: classes3.dex */
public final class DeleteDestinationInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DriverDestinationsManager f26430a;

    @Inject
    public DeleteDestinationInteractor(DriverDestinationsManager destinationsManager) {
        Intrinsics.f(destinationsManager, "destinationsManager");
        this.f26430a = destinationsManager;
    }

    public final Completable a(long j8) {
        return CompletableExtKt.a(this.f26430a.A(j8));
    }
}
