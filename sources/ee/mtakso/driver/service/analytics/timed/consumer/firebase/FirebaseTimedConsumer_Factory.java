package ee.mtakso.driver.service.analytics.timed.consumer.firebase;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class FirebaseTimedConsumer_Factory implements Factory<FirebaseTimedConsumer> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final FirebaseTimedConsumer_Factory f23539a = new FirebaseTimedConsumer_Factory();

        private InstanceHolder() {
        }
    }

    public static FirebaseTimedConsumer_Factory a() {
        return InstanceHolder.f23539a;
    }

    public static FirebaseTimedConsumer c() {
        return new FirebaseTimedConsumer();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public FirebaseTimedConsumer get() {
        return c();
    }
}
