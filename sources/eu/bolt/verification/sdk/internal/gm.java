package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class gm implements Factory<fm> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final gm f43155a = new gm();
    }

    public static gm a() {
        return a.f43155a;
    }

    public static fm c() {
        return new fm();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public fm get() {
        return c();
    }
}
