package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class pp implements Factory<op> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final pp f44565a = new pp();
    }

    public static pp a() {
        return a.f44565a;
    }

    public static op c() {
        return new op();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public op get() {
        return c();
    }
}
