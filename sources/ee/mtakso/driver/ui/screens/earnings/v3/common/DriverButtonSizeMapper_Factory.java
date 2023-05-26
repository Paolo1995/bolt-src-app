package ee.mtakso.driver.ui.screens.earnings.v3.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverButtonSizeMapper_Factory implements Factory<DriverButtonSizeMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final DriverButtonSizeMapper_Factory f29029a = new DriverButtonSizeMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static DriverButtonSizeMapper_Factory a() {
        return InstanceHolder.f29029a;
    }

    public static DriverButtonSizeMapper c() {
        return new DriverButtonSizeMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverButtonSizeMapper get() {
        return c();
    }
}
