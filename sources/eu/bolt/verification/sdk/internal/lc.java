package eu.bolt.verification.sdk.internal;

import android.app.Activity;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class lc implements Factory<kc> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Activity> f44037a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<kb> f44038b;

    public lc(Provider<Activity> provider, Provider<kb> provider2) {
        this.f44037a = provider;
        this.f44038b = provider2;
    }

    public static kc b(Activity activity, kb kbVar) {
        return new kc(activity, kbVar);
    }

    public static lc c(Provider<Activity> provider, Provider<kb> provider2) {
        return new lc(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public kc get() {
        return b(this.f44037a.get(), this.f44038b.get());
    }
}
