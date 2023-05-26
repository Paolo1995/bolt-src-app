package eu.bolt.verification.sdk.internal;

import android.content.Context;
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
public final class ep implements Factory<yg> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f42853a;

    public ep(Provider<Context> provider) {
        this.f42853a = provider;
    }

    public static ep a(Provider<Context> provider) {
        return new ep(provider);
    }

    public static yg c(Context context) {
        return (yg) Preconditions.checkNotNullFromProvides(xo.f(context));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public yg get() {
        return c(this.f42853a.get());
    }
}
