package ee.mtakso.driver.ui.screens.earnings.v3.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverContentTypeMapper_Factory implements Factory<DriverContentTypeMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final DriverContentTypeMapper_Factory f29035a = new DriverContentTypeMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static DriverContentTypeMapper_Factory a() {
        return InstanceHolder.f29035a;
    }

    public static DriverContentTypeMapper c() {
        return new DriverContentTypeMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverContentTypeMapper get() {
        return c();
    }
}
