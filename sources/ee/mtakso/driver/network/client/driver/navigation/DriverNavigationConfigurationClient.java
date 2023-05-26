package ee.mtakso.driver.network.client.driver.navigation;

import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.rx2.RxSingleKt;

/* compiled from: DriverNavigationConfigurationClient.kt */
/* loaded from: classes3.dex */
public final class DriverNavigationConfigurationClient {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineDispatcher f22057a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverNavigationConfigurationApi f22058b;

    @Inject
    public DriverNavigationConfigurationClient(CoroutineDispatcher dispatcher, DriverNavigationConfigurationApi api) {
        Intrinsics.f(dispatcher, "dispatcher");
        Intrinsics.f(api, "api");
        this.f22057a = dispatcher;
        this.f22058b = api;
    }

    public final Single<DynamicNavigation> b() {
        return RxSingleKt.b(this.f22057a, new DriverNavigationConfigurationClient$getDriveNavigationOptions$1(this, null));
    }
}
