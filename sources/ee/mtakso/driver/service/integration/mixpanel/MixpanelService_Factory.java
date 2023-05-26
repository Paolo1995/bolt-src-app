package ee.mtakso.driver.service.integration.mixpanel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.controller.MixpanelController;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class MixpanelService_Factory implements Factory<MixpanelService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MixpanelController> f24580a;

    public MixpanelService_Factory(Provider<MixpanelController> provider) {
        this.f24580a = provider;
    }

    public static MixpanelService_Factory a(Provider<MixpanelController> provider) {
        return new MixpanelService_Factory(provider);
    }

    public static MixpanelService c(MixpanelController mixpanelController) {
        return new MixpanelService(mixpanelController);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MixpanelService get() {
        return c(this.f24580a.get());
    }
}
