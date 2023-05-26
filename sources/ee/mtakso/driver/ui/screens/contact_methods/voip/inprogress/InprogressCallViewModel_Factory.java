package ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class InprogressCallViewModel_Factory implements Factory<InprogressCallViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<InprogressCallInteractor> f28038a;

    public InprogressCallViewModel_Factory(Provider<InprogressCallInteractor> provider) {
        this.f28038a = provider;
    }

    public static InprogressCallViewModel_Factory a(Provider<InprogressCallInteractor> provider) {
        return new InprogressCallViewModel_Factory(provider);
    }

    public static InprogressCallViewModel c(InprogressCallInteractor inprogressCallInteractor) {
        return new InprogressCallViewModel(inprogressCallInteractor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public InprogressCallViewModel get() {
        return c(this.f28038a.get());
    }
}
