package eu.bolt.driver.core.permission;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class PermissionManager_Factory implements Factory<PermissionManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PermissionInitiatorTracker> f40920a;

    public PermissionManager_Factory(Provider<PermissionInitiatorTracker> provider) {
        this.f40920a = provider;
    }

    public static PermissionManager_Factory a(Provider<PermissionInitiatorTracker> provider) {
        return new PermissionManager_Factory(provider);
    }

    public static PermissionManager c(PermissionInitiatorTracker permissionInitiatorTracker) {
        return new PermissionManager(permissionInitiatorTracker);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PermissionManager get() {
        return c(this.f40920a.get());
    }
}
