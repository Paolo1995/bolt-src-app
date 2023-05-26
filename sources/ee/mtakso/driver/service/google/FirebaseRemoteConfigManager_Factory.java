package ee.mtakso.driver.service.google;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class FirebaseRemoteConfigManager_Factory implements Factory<FirebaseRemoteConfigManager> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final FirebaseRemoteConfigManager_Factory f24521a = new FirebaseRemoteConfigManager_Factory();

        private InstanceHolder() {
        }
    }

    public static FirebaseRemoteConfigManager_Factory a() {
        return InstanceHolder.f24521a;
    }

    public static FirebaseRemoteConfigManager c() {
        return new FirebaseRemoteConfigManager();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public FirebaseRemoteConfigManager get() {
        return c();
    }
}
