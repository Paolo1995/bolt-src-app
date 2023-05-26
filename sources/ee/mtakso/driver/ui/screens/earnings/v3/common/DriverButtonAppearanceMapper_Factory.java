package ee.mtakso.driver.ui.screens.earnings.v3.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverButtonAppearanceMapper_Factory implements Factory<DriverButtonAppearanceMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final DriverButtonAppearanceMapper_Factory f29023a = new DriverButtonAppearanceMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static DriverButtonAppearanceMapper_Factory a() {
        return InstanceHolder.f29023a;
    }

    public static DriverButtonAppearanceMapper c() {
        return new DriverButtonAppearanceMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverButtonAppearanceMapper get() {
        return c();
    }
}
