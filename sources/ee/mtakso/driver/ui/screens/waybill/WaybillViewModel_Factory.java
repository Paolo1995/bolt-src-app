package ee.mtakso.driver.ui.screens.waybill;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.driver.WaybillClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class WaybillViewModel_Factory implements Factory<WaybillViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<WaybillClient> f33627a;

    public WaybillViewModel_Factory(Provider<WaybillClient> provider) {
        this.f33627a = provider;
    }

    public static WaybillViewModel_Factory a(Provider<WaybillClient> provider) {
        return new WaybillViewModel_Factory(provider);
    }

    public static WaybillViewModel c(WaybillClient waybillClient) {
        return new WaybillViewModel(waybillClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WaybillViewModel get() {
        return c(this.f33627a.get());
    }
}
