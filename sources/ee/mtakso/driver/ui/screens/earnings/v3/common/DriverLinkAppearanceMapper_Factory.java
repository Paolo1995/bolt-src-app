package ee.mtakso.driver.ui.screens.earnings.v3.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverLinkAppearanceMapper_Factory implements Factory<DriverLinkAppearanceMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final DriverLinkAppearanceMapper_Factory f29046a = new DriverLinkAppearanceMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static DriverLinkAppearanceMapper_Factory a() {
        return InstanceHolder.f29046a;
    }

    public static DriverLinkAppearanceMapper c() {
        return new DriverLinkAppearanceMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverLinkAppearanceMapper get() {
        return c();
    }
}
