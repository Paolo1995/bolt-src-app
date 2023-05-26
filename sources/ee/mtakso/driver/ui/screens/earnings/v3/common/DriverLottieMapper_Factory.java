package ee.mtakso.driver.ui.screens.earnings.v3.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverLottieMapper_Factory implements Factory<DriverLottieMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final DriverLottieMapper_Factory f29047a = new DriverLottieMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static DriverLottieMapper_Factory a() {
        return InstanceHolder.f29047a;
    }

    public static DriverLottieMapper c() {
        return new DriverLottieMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverLottieMapper get() {
        return c();
    }
}
