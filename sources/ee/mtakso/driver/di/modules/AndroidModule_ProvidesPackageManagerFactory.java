package ee.mtakso.driver.di.modules;

import android.content.Context;
import android.content.pm.PackageManager;
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
public final class AndroidModule_ProvidesPackageManagerFactory implements Factory<PackageManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f20749a;

    public AndroidModule_ProvidesPackageManagerFactory(Provider<Context> provider) {
        this.f20749a = provider;
    }

    public static AndroidModule_ProvidesPackageManagerFactory a(Provider<Context> provider) {
        return new AndroidModule_ProvidesPackageManagerFactory(provider);
    }

    public static PackageManager c(Context context) {
        return (PackageManager) Preconditions.checkNotNullFromProvides(AndroidModule.q(context));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PackageManager get() {
        return c(this.f20749a.get());
    }
}
