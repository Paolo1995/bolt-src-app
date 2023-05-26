package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ti implements Factory<si> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final ti f45203a = new ti();
    }

    public static ti a() {
        return a.f45203a;
    }

    public static si c() {
        return new si();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public si get() {
        return c();
    }
}
