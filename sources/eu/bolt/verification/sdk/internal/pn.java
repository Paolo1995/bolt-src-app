package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class pn implements Factory<on> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final pn f44559a = new pn();
    }

    public static pn a() {
        return a.f44559a;
    }

    public static on c() {
        return new on();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public on get() {
        return c();
    }
}
