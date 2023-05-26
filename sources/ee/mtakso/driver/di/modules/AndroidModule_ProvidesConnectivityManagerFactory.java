package ee.mtakso.driver.di.modules;

import android.content.Context;
import android.net.ConnectivityManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AndroidModule_ProvidesConnectivityManagerFactory implements Factory<ConnectivityManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f20748a;

    public AndroidModule_ProvidesConnectivityManagerFactory(Provider<Context> provider) {
        this.f20748a = provider;
    }

    public static AndroidModule_ProvidesConnectivityManagerFactory a(Provider<Context> provider) {
        return new AndroidModule_ProvidesConnectivityManagerFactory(provider);
    }

    public static ConnectivityManager c(Context context) {
        return (ConnectivityManager) Preconditions.checkNotNullFromProvides(AndroidModule.o(context));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ConnectivityManager get() {
        return c(this.f20748a.get());
    }
}
