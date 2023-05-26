package ee.mtakso.driver.ui.screens.contact_methods.voip.incoming;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class IncomingCallViewModel_Factory implements Factory<IncomingCallViewModel> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final IncomingCallViewModel_Factory f27999a = new IncomingCallViewModel_Factory();

        private InstanceHolder() {
        }
    }

    public static IncomingCallViewModel_Factory a() {
        return InstanceHolder.f27999a;
    }

    public static IncomingCallViewModel c() {
        return new IncomingCallViewModel();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public IncomingCallViewModel get() {
        return c();
    }
}
