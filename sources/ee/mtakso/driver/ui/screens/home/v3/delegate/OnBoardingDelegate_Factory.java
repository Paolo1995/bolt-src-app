package ee.mtakso.driver.ui.screens.home.v3.delegate;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.onboarding.OnBoardingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OnBoardingDelegate_Factory implements Factory<OnBoardingDelegate> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OnBoardingManager> f29882a;

    public OnBoardingDelegate_Factory(Provider<OnBoardingManager> provider) {
        this.f29882a = provider;
    }

    public static OnBoardingDelegate_Factory a(Provider<OnBoardingManager> provider) {
        return new OnBoardingDelegate_Factory(provider);
    }

    public static OnBoardingDelegate c(OnBoardingManager onBoardingManager) {
        return new OnBoardingDelegate(onBoardingManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OnBoardingDelegate get() {
        return c(this.f29882a.get());
    }
}
