package ee.mtakso.driver.utils;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class SystemUrlLauncher_Factory implements Factory<SystemUrlLauncher> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f36327a;

    public SystemUrlLauncher_Factory(Provider<Context> provider) {
        this.f36327a = provider;
    }

    public static SystemUrlLauncher_Factory a(Provider<Context> provider) {
        return new SystemUrlLauncher_Factory(provider);
    }

    public static SystemUrlLauncher c(Context context) {
        return new SystemUrlLauncher(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SystemUrlLauncher get() {
        return c(this.f36327a.get());
    }
}
