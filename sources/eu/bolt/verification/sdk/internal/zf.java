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
public final class zf implements Factory<yf> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Activity> f45858a;

    public zf(Provider<Activity> provider) {
        this.f45858a = provider;
    }

    public static yf b(Activity activity) {
        return new yf(activity);
    }

    public static zf c(Provider<Activity> provider) {
        return new zf(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public yf get() {
        return b(this.f45858a.get());
    }
}
