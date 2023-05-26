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
public final class nn implements Factory<mn> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f44353a;

    public nn(Provider<Context> provider) {
        this.f44353a = provider;
    }

    public static mn b(Context context) {
        return new mn(context);
    }

    public static nn c(Provider<Context> provider) {
        return new nn(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public mn get() {
        return b(this.f44353a.get());
    }
}
