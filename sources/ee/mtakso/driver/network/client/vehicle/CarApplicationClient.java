package ee.mtakso.driver.network.client.vehicle;

import ee.mtakso.driver.network.response.ServerResponse;
import ee.mtakso.driver.network.response.ServerResponseKt;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CarApplicationClient.kt */
/* loaded from: classes3.dex */
public final class CarApplicationClient {

    /* renamed from: a  reason: collision with root package name */
    private CarApplicationApi f22899a;

    @Inject
    public CarApplicationClient(CarApplicationApi carApplicationApi) {
        Intrinsics.f(carApplicationApi, "carApplicationApi");
        this.f22899a = carApplicationApi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VehiclesAndApplications c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (VehiclesAndApplications) tmp0.invoke(obj);
    }

    public final Single<VehiclesAndApplications> b() {
        Single<ServerResponse<VehiclesAndApplications>> a8 = this.f22899a.a();
        final CarApplicationClient$getVehiclesAndApplications$1 carApplicationClient$getVehiclesAndApplications$1 = new Function1<ServerResponse<VehiclesAndApplications>, VehiclesAndApplications>() { // from class: ee.mtakso.driver.network.client.vehicle.CarApplicationClient$getVehiclesAndApplications$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final VehiclesAndApplications invoke(ServerResponse<VehiclesAndApplications> it) {
                Intrinsics.f(it, "it");
                return (VehiclesAndApplications) ServerResponseKt.b(it);
            }
        };
        Single x7 = a8.x(new Function() { // from class: ee.mtakso.driver.network.client.vehicle.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                VehiclesAndApplications c8;
                c8 = CarApplicationClient.c(Function1.this, obj);
                return c8;
            }
        });
        Intrinsics.e(x7, "carApplicationApi.getVeh…).map { it.exposeData() }");
        return x7;
    }
}
