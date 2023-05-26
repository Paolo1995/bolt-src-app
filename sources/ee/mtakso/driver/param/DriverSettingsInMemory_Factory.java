package ee.mtakso.driver.param;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverSettingsInMemory_Factory implements Factory<DriverSettingsInMemory> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final DriverSettingsInMemory_Factory f23193a = new DriverSettingsInMemory_Factory();

        private InstanceHolder() {
        }
    }

    public static DriverSettingsInMemory_Factory a() {
        return InstanceHolder.f23193a;
    }

    public static DriverSettingsInMemory c() {
        return new DriverSettingsInMemory();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverSettingsInMemory get() {
        return c();
    }
}
