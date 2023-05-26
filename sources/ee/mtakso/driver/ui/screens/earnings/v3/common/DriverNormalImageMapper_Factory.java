package ee.mtakso.driver.ui.screens.earnings.v3.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverNormalImageMapper_Factory implements Factory<DriverNormalImageMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final DriverNormalImageMapper_Factory f29048a = new DriverNormalImageMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static DriverNormalImageMapper_Factory a() {
        return InstanceHolder.f29048a;
    }

    public static DriverNormalImageMapper c() {
        return new DriverNormalImageMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverNormalImageMapper get() {
        return c();
    }
}
