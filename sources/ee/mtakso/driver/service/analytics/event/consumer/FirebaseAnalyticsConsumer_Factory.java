package ee.mtakso.driver.service.analytics.event.consumer;

import com.google.firebase.analytics.FirebaseAnalytics;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class FirebaseAnalyticsConsumer_Factory implements Factory<FirebaseAnalyticsConsumer> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<FirebaseAnalytics> f23483a;

    public FirebaseAnalyticsConsumer_Factory(Provider<FirebaseAnalytics> provider) {
        this.f23483a = provider;
    }

    public static FirebaseAnalyticsConsumer_Factory a(Provider<FirebaseAnalytics> provider) {
        return new FirebaseAnalyticsConsumer_Factory(provider);
    }

    public static FirebaseAnalyticsConsumer c(FirebaseAnalytics firebaseAnalytics) {
        return new FirebaseAnalyticsConsumer(firebaseAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public FirebaseAnalyticsConsumer get() {
        return c(this.f23483a.get());
    }
}
