package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class mo implements Factory<lo> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final mo f44222a = new mo();
    }

    public static mo a() {
        return a.f44222a;
    }

    public static lo c() {
        return new lo();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public lo get() {
        return c();
    }
}
