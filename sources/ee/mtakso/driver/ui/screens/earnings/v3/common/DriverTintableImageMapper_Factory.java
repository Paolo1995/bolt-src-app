package ee.mtakso.driver.ui.screens.earnings.v3.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverTintableImageMapper_Factory implements Factory<DriverTintableImageMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final DriverTintableImageMapper_Factory f29049a = new DriverTintableImageMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static DriverTintableImageMapper_Factory a() {
        return InstanceHolder.f29049a;
    }

    public static DriverTintableImageMapper c() {
        return new DriverTintableImageMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverTintableImageMapper get() {
        return c();
    }
}
