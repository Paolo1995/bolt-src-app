package ee.mtakso.driver.ui.screens.login.v3.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class SharedLoginV3ViewModel_Factory implements Factory<SharedLoginV3ViewModel> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final SharedLoginV3ViewModel_Factory f30657a = new SharedLoginV3ViewModel_Factory();

        private InstanceHolder() {
        }
    }

    public static SharedLoginV3ViewModel_Factory a() {
        return InstanceHolder.f30657a;
    }

    public static SharedLoginV3ViewModel c() {
        return new SharedLoginV3ViewModel();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SharedLoginV3ViewModel get() {
        return c();
    }
}
