package ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LowStorageDialogDelegate_Factory implements Factory<LowStorageDialogDelegate> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f32578a;

    public LowStorageDialogDelegate_Factory(Provider<Context> provider) {
        this.f32578a = provider;
    }

    public static LowStorageDialogDelegate_Factory a(Provider<Context> provider) {
        return new LowStorageDialogDelegate_Factory(provider);
    }

    public static LowStorageDialogDelegate c(Context context) {
        return new LowStorageDialogDelegate(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LowStorageDialogDelegate get() {
        return c(this.f32578a.get());
    }
}
