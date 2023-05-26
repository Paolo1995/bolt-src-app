package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class a8 implements Factory<z7> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final a8 f41961a = new a8();
    }

    public static a8 a() {
        return a.f41961a;
    }

    public static z7 c() {
        return new z7();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public z7 get() {
        return c();
    }
}
