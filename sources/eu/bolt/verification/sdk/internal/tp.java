package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class tp implements Factory<sp> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final tp f45226a = new tp();
    }

    public static tp a() {
        return a.f45226a;
    }

    public static sp c() {
        return new sp();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public sp get() {
        return c();
    }
}
