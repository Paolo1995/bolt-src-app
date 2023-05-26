package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ge implements Factory<fe> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final ge f43138a = new ge();
    }

    public static ge a() {
        return a.f43138a;
    }

    public static fe c() {
        return new fe();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public fe get() {
        return c();
    }
}
