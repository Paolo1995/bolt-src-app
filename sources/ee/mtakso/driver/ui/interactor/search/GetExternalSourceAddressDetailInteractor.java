package ee.mtakso.driver.ui.interactor.search;

import ee.mtakso.driver.network.client.geo.ExternalSourceAddress;
import ee.mtakso.driver.network.client.geo.ExternalSourceAddressDetails;
import ee.mtakso.driver.network.client.geo.GeoClient;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: GetExternalSourceAddressDetailInteractor.kt */
/* loaded from: classes3.dex */
public final class GetExternalSourceAddressDetailInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final GeoClient f26866a;

    @Inject
    public GetExternalSourceAddressDetailInteractor(GeoClient geoClient) {
        Intrinsics.f(geoClient, "geoClient");
        this.f26866a = geoClient;
    }

    private final boolean b(ExternalSourceAddress externalSourceAddress) {
        boolean y7;
        y7 = StringsKt__StringsJVMKt.y(externalSourceAddress.a());
        if ((!y7) && externalSourceAddress.c() != null && externalSourceAddress.d() != null) {
            return true;
        }
        return false;
    }

    public final Single<ExternalSourceAddressDetails> a(ExternalSourceAddress externalSourceAddress, Long l8) {
        boolean y7;
        Intrinsics.f(externalSourceAddress, "externalSourceAddress");
        if (b(externalSourceAddress)) {
            String a8 = externalSourceAddress.a();
            Double c8 = externalSourceAddress.c();
            Intrinsics.c(c8);
            double doubleValue = c8.doubleValue();
            Double d8 = externalSourceAddress.d();
            Intrinsics.c(d8);
            Single<ExternalSourceAddressDetails> w7 = Single.w(new ExternalSourceAddressDetails(a8, doubleValue, d8.doubleValue()));
            Intrinsics.e(w7, "{\n                Single…          )\n            }");
            return w7;
        }
        y7 = StringsKt__StringsJVMKt.y(externalSourceAddress.e());
        if (!y7) {
            return SingleExtKt.d(this.f26866a.f(externalSourceAddress.f(), l8, externalSourceAddress.e()));
        }
        Single<ExternalSourceAddressDetails> y8 = Single.y();
        Intrinsics.e(y8, "{\n                Single.never()\n            }");
        return y8;
    }
}
