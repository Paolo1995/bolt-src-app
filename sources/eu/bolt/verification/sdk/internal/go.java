package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class go implements Factory<fo> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final go f43175a = new go();
    }

    public static go a() {
        return a.f43175a;
    }

    public static fo c() {
        return new fo();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public fo get() {
        return c();
    }
}
