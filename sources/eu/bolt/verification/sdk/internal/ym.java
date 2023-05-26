package eu.bolt.verification.sdk.internal;

import androidx.camera.view.PreviewView;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.verification.sdk.internal.wm;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.verification.core.rib.camera.VerificationCameraBuilder.VerificationCameraScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ym implements Factory<PreviewView> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<jn> f45771a;

    public ym(Provider<jn> provider) {
        this.f45771a = provider;
    }

    public static PreviewView b(jn jnVar) {
        return (PreviewView) Preconditions.checkNotNullFromProvides(wm.c.b(jnVar));
    }

    public static ym c(Provider<jn> provider) {
        return new ym(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public PreviewView get() {
        return b(this.f45771a.get());
    }
}
