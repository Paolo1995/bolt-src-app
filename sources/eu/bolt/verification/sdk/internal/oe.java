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
public final class oe implements Factory<ne> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f44454a;

    public oe(Provider<Context> provider) {
        this.f44454a = provider;
    }

    public static ne b(Context context) {
        return new ne(context);
    }

    public static oe c(Provider<Context> provider) {
        return new oe(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public ne get() {
        return b(this.f44454a.get());
    }
}
