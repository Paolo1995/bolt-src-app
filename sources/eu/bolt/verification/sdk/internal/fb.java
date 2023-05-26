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
public final class fb implements Factory<eb> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Activity> f42977a;

    public fb(Provider<Activity> provider) {
        this.f42977a = provider;
    }

    public static eb b(Activity activity) {
        return new eb(activity);
    }

    public static fb c(Provider<Activity> provider) {
        return new fb(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public eb get() {
        return b(this.f42977a.get());
    }
}
