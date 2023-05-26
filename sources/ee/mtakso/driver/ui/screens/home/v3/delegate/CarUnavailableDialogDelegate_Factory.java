package ee.mtakso.driver.ui.screens.home.v3.delegate;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CarUnavailableDialogDelegate_Factory implements Factory<CarUnavailableDialogDelegate> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final CarUnavailableDialogDelegate_Factory f29867a = new CarUnavailableDialogDelegate_Factory();

        private InstanceHolder() {
        }
    }

    public static CarUnavailableDialogDelegate_Factory a() {
        return InstanceHolder.f29867a;
    }

    public static CarUnavailableDialogDelegate c() {
        return new CarUnavailableDialogDelegate();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CarUnavailableDialogDelegate get() {
        return c();
    }
}
