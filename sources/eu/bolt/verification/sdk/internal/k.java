package eu.bolt.verification.sdk.internal;

import androidx.fragment.app.FragmentActivity;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("eu.bolt.verification.sdk.di.VerificationSDKScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class k implements Factory<FragmentActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final g f43790a;

    public k(g gVar) {
        this.f43790a = gVar;
    }

    public static k b(g gVar) {
        return new k(gVar);
    }

    public static FragmentActivity c(g gVar) {
        return (FragmentActivity) Preconditions.checkNotNullFromProvides(gVar.d());
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public FragmentActivity get() {
        return c(this.f43790a);
    }
}
