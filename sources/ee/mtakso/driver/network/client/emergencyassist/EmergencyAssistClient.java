package ee.mtakso.driver.network.client.emergencyassist;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.emergencyassist.help_provider.ExternalHelpProviderResponse;
import ee.mtakso.driver.network.client.emergencyassist.local_authority.DidYouGetHelpRequest;
import ee.mtakso.driver.network.client.emergencyassist.reverse_geocode.EmergencyAssistReverseGeocodeResponse;
import ee.mtakso.driver.network.client.emergencyassist.third_party_incident.RequestExternalHelpResponse;
import ee.mtakso.driver.network.client.emergencyassist.third_party_incident.RequestExternalHelpUpdateRequest;
import ee.mtakso.driver.network.client.incident.OpenIncidentRequest;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import eu.bolt.driver.core.network.response.BasicServerResponseKt;
import eu.bolt.driver.core.network.response.EmptyServerResponse;
import eu.bolt.driver.core.network.response.ServerResponse;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmergencyAssistClient.kt */
/* loaded from: classes3.dex */
public final class EmergencyAssistClient {

    /* renamed from: a  reason: collision with root package name */
    private final EmergencyAssistApi f22169a;

    @Inject
    public EmergencyAssistClient(EmergencyAssistApi emergencyAssistApi) {
        Intrinsics.f(emergencyAssistApi, "emergencyAssistApi");
        this.f22169a = emergencyAssistApi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExternalHelpProviderResponse e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ExternalHelpProviderResponse) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RequestExternalHelpResponse h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (RequestExternalHelpResponse) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EmergencyAssistReverseGeocodeResponse l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (EmergencyAssistReverseGeocodeResponse) tmp0.invoke(obj);
    }

    public final Single<ExternalHelpProviderResponse> d(double d8, double d9) {
        Single<ServerResponse<ExternalHelpProviderResponse>> f8 = this.f22169a.f(d8, d9);
        final EmergencyAssistClient$getExternalHelpProvider$1 emergencyAssistClient$getExternalHelpProvider$1 = new Function1<ServerResponse<ExternalHelpProviderResponse>, ExternalHelpProviderResponse>() { // from class: ee.mtakso.driver.network.client.emergencyassist.EmergencyAssistClient$getExternalHelpProvider$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ExternalHelpProviderResponse invoke(ServerResponse<ExternalHelpProviderResponse> it) {
                Intrinsics.f(it, "it");
                return (ExternalHelpProviderResponse) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = f8.x(new Function() { // from class: ee.mtakso.driver.network.client.emergencyassist.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ExternalHelpProviderResponse e8;
                e8 = EmergencyAssistClient.e(Function1.this, obj);
                return e8;
            }
        });
        Intrinsics.e(x7, "emergencyAssistApi.getEx… .map { it.exposeData() }");
        return x7;
    }

    public final Single<EmptyServerResponse> f(OrderHandle orderHandle) {
        return this.f22169a.c(new DidYouGetHelpRequest(orderHandle));
    }

    public final Single<RequestExternalHelpResponse> g(GeoCoordinate geoCoordinate, OrderHandle orderHandle) {
        Intrinsics.f(geoCoordinate, "geoCoordinate");
        Single<ServerResponse<RequestExternalHelpResponse>> a8 = this.f22169a.a(new OpenIncidentRequest(geoCoordinate.a(), geoCoordinate.b(), orderHandle));
        final EmergencyAssistClient$requestExternalHelp$1 emergencyAssistClient$requestExternalHelp$1 = new Function1<ServerResponse<RequestExternalHelpResponse>, RequestExternalHelpResponse>() { // from class: ee.mtakso.driver.network.client.emergencyassist.EmergencyAssistClient$requestExternalHelp$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final RequestExternalHelpResponse invoke(ServerResponse<RequestExternalHelpResponse> it) {
                Intrinsics.f(it, "it");
                return (RequestExternalHelpResponse) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = a8.x(new Function() { // from class: ee.mtakso.driver.network.client.emergencyassist.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                RequestExternalHelpResponse h8;
                h8 = EmergencyAssistClient.h(Function1.this, obj);
                return h8;
            }
        });
        Intrinsics.e(x7, "emergencyAssistApi.reque…it.exposeData()\n        }");
        return x7;
    }

    public final Single<EmptyServerResponse> i(GeoCoordinate geoCoordinate, long j8) {
        Intrinsics.f(geoCoordinate, "geoCoordinate");
        return this.f22169a.d(new RequestExternalHelpUpdateRequest(j8, geoCoordinate.a(), geoCoordinate.b()));
    }

    public final Single<EmptyServerResponse> j(OrderHandle orderHandle) {
        return this.f22169a.e(new DidYouGetHelpRequest(orderHandle));
    }

    public final Single<EmergencyAssistReverseGeocodeResponse> k(double d8, double d9) {
        Single<ServerResponse<EmergencyAssistReverseGeocodeResponse>> b8 = this.f22169a.b(d8, d9);
        final EmergencyAssistClient$reverseGeoCode$1 emergencyAssistClient$reverseGeoCode$1 = new Function1<ServerResponse<EmergencyAssistReverseGeocodeResponse>, EmergencyAssistReverseGeocodeResponse>() { // from class: ee.mtakso.driver.network.client.emergencyassist.EmergencyAssistClient$reverseGeoCode$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final EmergencyAssistReverseGeocodeResponse invoke(ServerResponse<EmergencyAssistReverseGeocodeResponse> it) {
                Intrinsics.f(it, "it");
                return (EmergencyAssistReverseGeocodeResponse) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = b8.x(new Function() { // from class: ee.mtakso.driver.network.client.emergencyassist.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                EmergencyAssistReverseGeocodeResponse l8;
                l8 = EmergencyAssistClient.l(Function1.this, obj);
                return l8;
            }
        });
        Intrinsics.e(x7, "emergencyAssistApi.rever… .map { it.exposeData() }");
        return x7;
    }
}
