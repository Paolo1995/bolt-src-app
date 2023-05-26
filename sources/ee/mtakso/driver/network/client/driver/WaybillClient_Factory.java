package ee.mtakso.driver.network.client.driver;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class WaybillClient_Factory implements Factory<WaybillClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<WaybillApi> f22019a;

    public WaybillClient_Factory(Provider<WaybillApi> provider) {
        this.f22019a = provider;
    }

    public static WaybillClient_Factory a(Provider<WaybillApi> provider) {
        return new WaybillClient_Factory(provider);
    }

    public static WaybillClient c(WaybillApi waybillApi) {
        return new WaybillClient(waybillApi);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WaybillClient get() {
        return c(this.f22019a.get());
    }
}
