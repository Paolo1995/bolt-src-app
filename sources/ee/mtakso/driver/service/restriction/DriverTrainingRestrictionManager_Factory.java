package ee.mtakso.driver.service.restriction;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverTrainingRestrictionManager_Factory implements Factory<DriverTrainingRestrictionManager> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final DriverTrainingRestrictionManager_Factory f25840a = new DriverTrainingRestrictionManager_Factory();

        private InstanceHolder() {
        }
    }

    public static DriverTrainingRestrictionManager_Factory a() {
        return InstanceHolder.f25840a;
    }

    public static DriverTrainingRestrictionManager c() {
        return new DriverTrainingRestrictionManager();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverTrainingRestrictionManager get() {
        return c();
    }
}
