package eu.bolt.verification.sdk.internal;

import android.app.Activity;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.android.rib.RxActivityEvents;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class qd implements Factory<pd> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Activity> f44644a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RxActivityEvents> f44645b;

    public qd(Provider<Activity> provider, Provider<RxActivityEvents> provider2) {
        this.f44644a = provider;
        this.f44645b = provider2;
    }

    public static pd b(Activity activity, RxActivityEvents rxActivityEvents) {
        return new pd(activity, rxActivityEvents);
    }

    public static qd c(Provider<Activity> provider, Provider<RxActivityEvents> provider2) {
        return new qd(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public pd get() {
        return b(this.f44644a.get(), this.f44645b.get());
    }
}
