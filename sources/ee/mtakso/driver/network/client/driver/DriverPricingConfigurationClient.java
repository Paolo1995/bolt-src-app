package ee.mtakso.driver.network.client.driver;

import eu.bolt.driver.core.network.response.BasicServerResponseKt;
import eu.bolt.driver.core.network.response.ServerResponse;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverPricingConfigurationClient.kt */
/* loaded from: classes3.dex */
public final class DriverPricingConfigurationClient {

    /* renamed from: a  reason: collision with root package name */
    private final DriverPricingConfigurationApi f21953a;

    @Inject
    public DriverPricingConfigurationClient(DriverPricingConfigurationApi api) {
        Intrinsics.f(api, "api");
        this.f21953a = api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DriverPricingConfiguration c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DriverPricingConfiguration) tmp0.invoke(obj);
    }

    public final Single<DriverPricingConfiguration> b() {
        Single<ServerResponse<DriverPricingConfiguration>> a8 = this.f21953a.a();
        final DriverPricingConfigurationClient$getDriverPricingConfiguration$1 driverPricingConfigurationClient$getDriverPricingConfiguration$1 = new Function1<ServerResponse<DriverPricingConfiguration>, DriverPricingConfiguration>() { // from class: ee.mtakso.driver.network.client.driver.DriverPricingConfigurationClient$getDriverPricingConfiguration$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DriverPricingConfiguration invoke(ServerResponse<DriverPricingConfiguration> it) {
                Intrinsics.f(it, "it");
                return (DriverPricingConfiguration) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = a8.x(new Function() { // from class: ee.mtakso.driver.network.client.driver.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DriverPricingConfiguration c8;
                c8 = DriverPricingConfigurationClient.c(Function1.this, obj);
                return c8;
            }
        });
        Intrinsics.e(x7, "api.getDriverPricingConf…).map { it.exposeData() }");
        return x7;
    }
}
