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
public final class ChromeCustomTabsUrlLauncher_Factory implements Factory<ChromeCustomTabsUrlLauncher> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f36293a;

    public ChromeCustomTabsUrlLauncher_Factory(Provider<Context> provider) {
        this.f36293a = provider;
    }

    public static ChromeCustomTabsUrlLauncher_Factory a(Provider<Context> provider) {
        return new ChromeCustomTabsUrlLauncher_Factory(provider);
    }

    public static ChromeCustomTabsUrlLauncher c(Context context) {
        return new ChromeCustomTabsUrlLauncher(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChromeCustomTabsUrlLauncher get() {
        return c(this.f36293a.get());
    }
}
