package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class w1 implements Factory<v1> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final w1 f45486a = new w1();
    }

    public static w1 a() {
        return a.f45486a;
    }

    public static v1 c() {
        return new v1();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public v1 get() {
        return c();
    }
}
