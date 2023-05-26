package ee.mtakso.driver.platform.google.core;

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
public final class GmsPlatformManager_Factory implements Factory<GmsPlatformManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f23299a;

    public GmsPlatformManager_Factory(Provider<Context> provider) {
        this.f23299a = provider;
    }

    public static GmsPlatformManager_Factory a(Provider<Context> provider) {
        return new GmsPlatformManager_Factory(provider);
    }

    public static GmsPlatformManager c(Context context) {
        return new GmsPlatformManager(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GmsPlatformManager get() {
        return c(this.f23299a.get());
    }
}
