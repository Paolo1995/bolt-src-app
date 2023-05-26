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
public final class nl implements Factory<ml> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f44351a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<v4> f44352b;

    public nl(Provider<Context> provider, Provider<v4> provider2) {
        this.f44351a = provider;
        this.f44352b = provider2;
    }

    public static ml b(Context context, v4 v4Var) {
        return new ml(context, v4Var);
    }

    public static nl c(Provider<Context> provider, Provider<v4> provider2) {
        return new nl(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public ml get() {
        return b(this.f44351a.get(), this.f44352b.get());
    }
}
