package eu.bolt.verification.sdk.internal;

import android.app.Activity;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("eu.bolt.verification.sdk.di.VerificationSDKScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class j implements Factory<Activity> {

    /* renamed from: a  reason: collision with root package name */
    private final g f43619a;

    public j(g gVar) {
        this.f43619a = gVar;
    }

    public static j b(g gVar) {
        return new j(gVar);
    }

    public static Activity c(g gVar) {
        return (Activity) Preconditions.checkNotNullFromProvides(gVar.c());
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public Activity get() {
        return c(this.f43619a);
    }
}
