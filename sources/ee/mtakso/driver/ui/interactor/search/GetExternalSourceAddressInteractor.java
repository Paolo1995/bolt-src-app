package ee.mtakso.driver.ui.interactor.search;

import ee.mtakso.driver.network.client.geo.ExternalSourceAddresses;
import ee.mtakso.driver.network.client.geo.GeoClient;
import ee.mtakso.driver.service.geo.GeoLocation;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetExternalSourceAddressInteractor.kt */
/* loaded from: classes3.dex */
public final class GetExternalSourceAddressInteractor {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f26868b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final GeoClient f26869a;

    /* compiled from: GetExternalSourceAddressInteractor.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public GetExternalSourceAddressInteractor(GeoClient geoClient) {
        Intrinsics.f(geoClient, "geoClient");
        this.f26869a = geoClient;
    }

    public final Single<ExternalSourceAddresses> a(String query, GeoLocation location, Long l8) {
        Intrinsics.f(query, "query");
        Intrinsics.f(location, "location");
        return this.f26869a.g(location.e().a(), location.e().b(), l8, query, 10);
    }
}
