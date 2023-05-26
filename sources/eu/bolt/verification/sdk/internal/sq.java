package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class sq implements Factory<rq> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final sq f45056a = new sq();
    }

    public static sq a() {
        return a.f45056a;
    }

    public static rq c() {
        return new rq();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public rq get() {
        return c();
    }
}
