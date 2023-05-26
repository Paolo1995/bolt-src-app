package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class p1 implements Factory<o1> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final p1 f44498a = new p1();
    }

    public static p1 a() {
        return a.f44498a;
    }

    public static o1 c() {
        return new o1();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public o1 get() {
        return c();
    }
}
