package ee.mtakso.driver.di.modules;

import android.content.Context;
import android.content.pm.PackageInfo;
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
public final class AndroidModule_ProvidePackageInfoFactory implements Factory<PackageInfo> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f20747a;

    public AndroidModule_ProvidePackageInfoFactory(Provider<Context> provider) {
        this.f20747a = provider;
    }

    public static AndroidModule_ProvidePackageInfoFactory a(Provider<Context> provider) {
        return new AndroidModule_ProvidePackageInfoFactory(provider);
    }

    public static PackageInfo c(Context context) {
        return (PackageInfo) Preconditions.checkNotNullFromProvides(AndroidModule.k(context));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PackageInfo get() {
        return c(this.f20747a.get());
    }
}
