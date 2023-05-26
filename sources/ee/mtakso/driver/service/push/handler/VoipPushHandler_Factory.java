package ee.mtakso.driver.service.push.handler;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.voip.VoipService;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class VoipPushHandler_Factory implements Factory<VoipPushHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<VoipService> f25727a;

    public VoipPushHandler_Factory(Provider<VoipService> provider) {
        this.f25727a = provider;
    }

    public static VoipPushHandler_Factory a(Provider<VoipService> provider) {
        return new VoipPushHandler_Factory(provider);
    }

    public static VoipPushHandler c(VoipService voipService) {
        return new VoipPushHandler(voipService);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VoipPushHandler get() {
        return c(this.f25727a.get());
    }
}
