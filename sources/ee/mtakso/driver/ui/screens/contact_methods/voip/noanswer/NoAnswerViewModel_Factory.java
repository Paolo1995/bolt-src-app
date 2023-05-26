package ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class NoAnswerViewModel_Factory implements Factory<NoAnswerViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<NoAnswerInteractor> f28068a;

    public NoAnswerViewModel_Factory(Provider<NoAnswerInteractor> provider) {
        this.f28068a = provider;
    }

    public static NoAnswerViewModel_Factory a(Provider<NoAnswerInteractor> provider) {
        return new NoAnswerViewModel_Factory(provider);
    }

    public static NoAnswerViewModel c(NoAnswerInteractor noAnswerInteractor) {
        return new NoAnswerViewModel(noAnswerInteractor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public NoAnswerViewModel get() {
        return c(this.f28068a.get());
    }
}
