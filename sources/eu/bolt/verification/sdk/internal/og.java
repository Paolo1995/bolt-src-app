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
public final class og implements Factory<ng> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Activity> f44457a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<jc> f44458b;

    public og(Provider<Activity> provider, Provider<jc> provider2) {
        this.f44457a = provider;
        this.f44458b = provider2;
    }

    public static ng b(Activity activity, jc jcVar) {
        return new ng(activity, jcVar);
    }

    public static og c(Provider<Activity> provider, Provider<jc> provider2) {
        return new og(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public ng get() {
        return b(this.f44457a.get(), this.f44458b.get());
    }
}
