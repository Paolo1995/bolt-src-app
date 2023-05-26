package ee.mtakso.driver.network.client.driver;

import eu.bolt.driver.core.network.client.driver.DriverConfiguration;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.rx2.RxSingleKt;

/* compiled from: DriverConfigurationClient.kt */
/* loaded from: classes3.dex */
public final class DriverConfigurationClient {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineDispatcher f21909a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverConfigurationApi f21910b;

    @Inject
    public DriverConfigurationClient(CoroutineDispatcher dispatcher, DriverConfigurationApi api) {
        Intrinsics.f(dispatcher, "dispatcher");
        Intrinsics.f(api, "api");
        this.f21909a = dispatcher;
        this.f21910b = api;
    }

    public final Single<DriverConfiguration> b() {
        return RxSingleKt.b(this.f21909a, new DriverConfigurationClient$loadDriverConfiguration$1(this, null));
    }
}
