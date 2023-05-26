package ee.mtakso.driver.param;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DeviceFeatures_Factory implements Factory<DeviceFeatures> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f23085a;

    public DeviceFeatures_Factory(Provider<Context> provider) {
        this.f23085a = provider;
    }

    public static DeviceFeatures_Factory a(Provider<Context> provider) {
        return new DeviceFeatures_Factory(provider);
    }

    public static DeviceFeatures c(Context context) {
        return new DeviceFeatures(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DeviceFeatures get() {
        return c(this.f23085a.get());
    }
}
