package ee.mtakso.driver.di.modules;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
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
public final class AnalyticsModule_ProvideFirebaseAnalyticsFactory implements Factory<FirebaseAnalytics> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f20743a;

    public AnalyticsModule_ProvideFirebaseAnalyticsFactory(Provider<Context> provider) {
        this.f20743a = provider;
    }

    public static AnalyticsModule_ProvideFirebaseAnalyticsFactory a(Provider<Context> provider) {
        return new AnalyticsModule_ProvideFirebaseAnalyticsFactory(provider);
    }

    public static FirebaseAnalytics c(Context context) {
        return (FirebaseAnalytics) Preconditions.checkNotNullFromProvides(AnalyticsModule.J(context));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public FirebaseAnalytics get() {
        return c(this.f20743a.get());
    }
}
