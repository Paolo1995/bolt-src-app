package ee.mtakso.driver.service.integration.clevertap;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class FcmCleverTapPushTokenHandler_Factory implements Factory<FcmCleverTapPushTokenHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CleverTapManager> f24564a;

    public FcmCleverTapPushTokenHandler_Factory(Provider<CleverTapManager> provider) {
        this.f24564a = provider;
    }

    public static FcmCleverTapPushTokenHandler_Factory a(Provider<CleverTapManager> provider) {
        return new FcmCleverTapPushTokenHandler_Factory(provider);
    }

    public static FcmCleverTapPushTokenHandler c(CleverTapManager cleverTapManager) {
        return new FcmCleverTapPushTokenHandler(cleverTapManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public FcmCleverTapPushTokenHandler get() {
        return c(this.f24564a.get());
    }
}
