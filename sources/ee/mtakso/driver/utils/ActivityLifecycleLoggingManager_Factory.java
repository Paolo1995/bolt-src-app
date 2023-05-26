package ee.mtakso.driver.utils;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ActivityLifecycleLoggingManager_Factory implements Factory<ActivityLifecycleLoggingManager> {

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final ActivityLifecycleLoggingManager_Factory f36271a = new ActivityLifecycleLoggingManager_Factory();

        private InstanceHolder() {
        }
    }

    public static ActivityLifecycleLoggingManager_Factory a() {
        return InstanceHolder.f36271a;
    }

    public static ActivityLifecycleLoggingManager c() {
        return new ActivityLifecycleLoggingManager();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ActivityLifecycleLoggingManager get() {
        return c();
    }
}
