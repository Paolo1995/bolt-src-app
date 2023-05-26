package ee.mtakso.driver.platform.google.geo;

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
public final class GmsLocationSource_Factory implements Factory<GmsLocationSource> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f23313a;

    public GmsLocationSource_Factory(Provider<Context> provider) {
        this.f23313a = provider;
    }

    public static GmsLocationSource_Factory a(Provider<Context> provider) {
        return new GmsLocationSource_Factory(provider);
    }

    public static GmsLocationSource c(Context context) {
        return new GmsLocationSource(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GmsLocationSource get() {
        return c(this.f23313a.get());
    }
}
