package eu.bolt.verification.sdk.internal;

import androidx.fragment.app.FragmentActivity;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.verification.sdk.di.VerificationSDKScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class cp implements Factory<ib> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<FragmentActivity> f42539a;

    public cp(Provider<FragmentActivity> provider) {
        this.f42539a = provider;
    }

    public static cp a(Provider<FragmentActivity> provider) {
        return new cp(provider);
    }

    public static ib c(FragmentActivity fragmentActivity) {
        return (ib) Preconditions.checkNotNullFromProvides(xo.b(fragmentActivity));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ib get() {
        return c(this.f42539a.get());
    }
}
