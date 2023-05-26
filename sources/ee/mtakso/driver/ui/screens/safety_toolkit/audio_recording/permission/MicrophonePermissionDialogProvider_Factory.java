package ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.permission;

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
public final class MicrophonePermissionDialogProvider_Factory implements Factory<MicrophonePermissionDialogProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f32600a;

    public MicrophonePermissionDialogProvider_Factory(Provider<Context> provider) {
        this.f32600a = provider;
    }

    public static MicrophonePermissionDialogProvider_Factory a(Provider<Context> provider) {
        return new MicrophonePermissionDialogProvider_Factory(provider);
    }

    public static MicrophonePermissionDialogProvider c(Context context) {
        return new MicrophonePermissionDialogProvider(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MicrophonePermissionDialogProvider get() {
        return c(this.f32600a.get());
    }
}
