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
public final class dq implements Factory<cq> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f42660a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<rd> f42661b;

    public dq(Provider<Context> provider, Provider<rd> provider2) {
        this.f42660a = provider;
        this.f42661b = provider2;
    }

    public static cq b(Context context, rd rdVar) {
        return new cq(context, rdVar);
    }

    public static dq c(Provider<Context> provider, Provider<rd> provider2) {
        return new dq(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public cq get() {
        return b(this.f42660a.get(), this.f42661b.get());
    }
}
