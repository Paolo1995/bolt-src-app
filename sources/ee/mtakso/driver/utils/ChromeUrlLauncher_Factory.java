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
public final class ChromeUrlLauncher_Factory implements Factory<ChromeUrlLauncher> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f36295a;

    public ChromeUrlLauncher_Factory(Provider<Context> provider) {
        this.f36295a = provider;
    }

    public static ChromeUrlLauncher_Factory a(Provider<Context> provider) {
        return new ChromeUrlLauncher_Factory(provider);
    }

    public static ChromeUrlLauncher c(Context context) {
        return new ChromeUrlLauncher(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChromeUrlLauncher get() {
        return c(this.f36295a.get());
    }
}
