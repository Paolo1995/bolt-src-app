package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* renamed from: eu.bolt.verification.sdk.internal.if  reason: invalid class name */
/* loaded from: classes5.dex */
public final class Cif implements Factory<hf> {

    /* renamed from: eu.bolt.verification.sdk.internal.if$a */
    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final Cif f43565a = new Cif();
    }

    public static Cif a() {
        return a.f43565a;
    }

    public static hf c() {
        return new hf();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public hf get() {
        return c();
    }
}
