package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class mm implements Factory<lm> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final mm f44218a = new mm();
    }

    public static mm a() {
        return a.f44218a;
    }

    public static lm c() {
        return new lm();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public lm get() {
        return c();
    }
}
