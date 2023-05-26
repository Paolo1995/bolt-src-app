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
public final class mb implements Factory<lb> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Activity> f44172a;

    public mb(Provider<Activity> provider) {
        this.f44172a = provider;
    }

    public static lb b(Activity activity) {
        return new lb(activity);
    }

    public static mb c(Provider<Activity> provider) {
        return new mb(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public lb get() {
        return b(this.f44172a.get());
    }
}
