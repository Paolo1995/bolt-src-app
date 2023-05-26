package eu.bolt.verification.sdk.internal;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class h1 implements Factory<g1> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f43188a;

    public h1(Provider<Context> provider) {
        this.f43188a = provider;
    }

    public static g1 b(Context context) {
        return new g1(context);
    }

    public static h1 c(Provider<Context> provider) {
        return new h1(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public g1 get() {
        return b(this.f43188a.get());
    }
}
