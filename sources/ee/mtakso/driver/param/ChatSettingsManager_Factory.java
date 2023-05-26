package ee.mtakso.driver.param;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ChatSettingsManager_Factory implements Factory<ChatSettingsManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f23074a;

    public ChatSettingsManager_Factory(Provider<DriverProvider> provider) {
        this.f23074a = provider;
    }

    public static ChatSettingsManager_Factory a(Provider<DriverProvider> provider) {
        return new ChatSettingsManager_Factory(provider);
    }

    public static ChatSettingsManager c(DriverProvider driverProvider) {
        return new ChatSettingsManager(driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatSettingsManager get() {
        return c(this.f23074a.get());
    }
}
