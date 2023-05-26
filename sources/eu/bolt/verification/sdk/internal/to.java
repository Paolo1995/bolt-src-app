package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class to implements Factory<so> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final to f45225a = new to();
    }

    public static to a() {
        return a.f45225a;
    }

    public static so c() {
        return new so();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public so get() {
        return c();
    }
}
