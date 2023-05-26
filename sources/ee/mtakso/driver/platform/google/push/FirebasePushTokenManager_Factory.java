package ee.mtakso.driver.platform.google.push;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class FirebasePushTokenManager_Factory implements Factory<FirebasePushTokenManager> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final FirebasePushTokenManager_Factory f23337a = new FirebasePushTokenManager_Factory();

        private InstanceHolder() {
        }
    }

    public static FirebasePushTokenManager_Factory a() {
        return InstanceHolder.f23337a;
    }

    public static FirebasePushTokenManager c() {
        return new FirebasePushTokenManager();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public FirebasePushTokenManager get() {
        return c();
    }
}
