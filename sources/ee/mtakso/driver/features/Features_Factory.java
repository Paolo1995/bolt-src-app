package ee.mtakso.driver.features;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class Features_Factory implements Factory<Features> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f20910a;

    public Features_Factory(Provider<Context> provider) {
        this.f20910a = provider;
    }

    public static Features_Factory a(Provider<Context> provider) {
        return new Features_Factory(provider);
    }

    public static Features c(Context context) {
        return new Features(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Features get() {
        return c(this.f20910a.get());
    }
}
