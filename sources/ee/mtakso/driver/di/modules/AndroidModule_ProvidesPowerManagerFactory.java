package ee.mtakso.driver.di.modules;

import android.content.Context;
import android.os.PowerManager;
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
public final class AndroidModule_ProvidesPowerManagerFactory implements Factory<PowerManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f20750a;

    public AndroidModule_ProvidesPowerManagerFactory(Provider<Context> provider) {
        this.f20750a = provider;
    }

    public static AndroidModule_ProvidesPowerManagerFactory a(Provider<Context> provider) {
        return new AndroidModule_ProvidesPowerManagerFactory(provider);
    }

    public static PowerManager c(Context context) {
        return (PowerManager) Preconditions.checkNotNullFromProvides(AndroidModule.r(context));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PowerManager get() {
        return c(this.f20750a.get());
    }
}
