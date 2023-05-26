package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class om implements Factory<nm> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final om f44478a = new om();
    }

    public static om a() {
        return a.f44478a;
    }

    public static nm c() {
        return new nm();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public nm get() {
        return c();
    }
}
