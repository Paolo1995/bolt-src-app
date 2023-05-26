package ee.mtakso.driver.ui.interactor.destination;

import ee.mtakso.driver.network.client.geo.ExternalSourceAddress;
import ee.mtakso.driver.network.client.geo.ExternalSourceAddressDetails;
import ee.mtakso.driver.network.client.settings.DriverDestination;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.ui.interactor.destination.UpdateDriverDestinationInteractor;
import ee.mtakso.driver.ui.interactor.search.GetExternalSourceAddressDetailInteractor;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpdateDriverDestinationInteractor.kt */
/* loaded from: classes3.dex */
public final class UpdateDriverDestinationInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DriverDestinationsManager f26439a;

    /* renamed from: b  reason: collision with root package name */
    private final GetExternalSourceAddressDetailInteractor f26440b;

    @Inject
    public UpdateDriverDestinationInteractor(DriverDestinationsManager driverDestinationsManager, GetExternalSourceAddressDetailInteractor getExternalSourceAddressDetailInteractor) {
        Intrinsics.f(driverDestinationsManager, "driverDestinationsManager");
        Intrinsics.f(getExternalSourceAddressDetailInteractor, "getExternalSourceAddressDetailInteractor");
        this.f26439a = driverDestinationsManager;
        this.f26440b = getExternalSourceAddressDetailInteractor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    public final Single<DriverDestination> c(Pair<DriverDestination, ExternalSourceAddress> addressPair) {
        Intrinsics.f(addressPair, "addressPair");
        final DriverDestination d8 = addressPair.d();
        Single<ExternalSourceAddressDetails> a8 = this.f26440b.a(addressPair.e(), null);
        final Function1<ExternalSourceAddressDetails, SingleSource<? extends DriverDestination>> function1 = new Function1<ExternalSourceAddressDetails, SingleSource<? extends DriverDestination>>() { // from class: ee.mtakso.driver.ui.interactor.destination.UpdateDriverDestinationInteractor$updateDriverDestinations$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends DriverDestination> invoke(ExternalSourceAddressDetails externalSourceAddressDetails) {
                DriverDestinationsManager driverDestinationsManager;
                Intrinsics.f(externalSourceAddressDetails, "externalSourceAddressDetails");
                driverDestinationsManager = UpdateDriverDestinationInteractor.this.f26439a;
                return SingleExtKt.d(driverDestinationsManager.P(d8.f(), d8.e(), externalSourceAddressDetails.a(), externalSourceAddressDetails.b(), externalSourceAddressDetails.c()));
            }
        };
        Single r7 = a8.r(new Function() { // from class: r2.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource d9;
                d9 = UpdateDriverDestinationInteractor.d(Function1.this, obj);
                return d9;
            }
        });
        Intrinsics.e(r7, "fun updateDriverDestinat…edulers()\n        }\n    }");
        return r7;
    }
}
