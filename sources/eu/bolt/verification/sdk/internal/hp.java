package eu.bolt.verification.sdk.internal;

import androidx.fragment.app.FragmentActivity;
import com.tbruyelle.rxpermissions2.RxPermissions;
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
public final class hp implements Factory<RxPermissions> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<FragmentActivity> f43422a;

    public hp(Provider<FragmentActivity> provider) {
        this.f43422a = provider;
    }

    public static RxPermissions b(FragmentActivity fragmentActivity) {
        return (RxPermissions) Preconditions.checkNotNullFromProvides(xo.g(fragmentActivity));
    }

    public static hp c(Provider<FragmentActivity> provider) {
        return new hp(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public RxPermissions get() {
        return b(this.f43422a.get());
    }
}
