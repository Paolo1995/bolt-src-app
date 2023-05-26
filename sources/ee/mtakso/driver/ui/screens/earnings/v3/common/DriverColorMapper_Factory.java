package ee.mtakso.driver.ui.screens.earnings.v3.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverColorMapper_Factory implements Factory<DriverColorMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final DriverColorMapper_Factory f29033a = new DriverColorMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static DriverColorMapper_Factory a() {
        return InstanceHolder.f29033a;
    }

    public static DriverColorMapper c() {
        return new DriverColorMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverColorMapper get() {
        return c();
    }
}
