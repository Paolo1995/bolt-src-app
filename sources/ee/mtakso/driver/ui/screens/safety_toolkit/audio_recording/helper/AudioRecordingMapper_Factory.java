package ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AudioRecordingMapper_Factory implements Factory<AudioRecordingMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final AudioRecordingMapper_Factory f32573a = new AudioRecordingMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static AudioRecordingMapper_Factory a() {
        return InstanceHolder.f32573a;
    }

    public static AudioRecordingMapper c() {
        return new AudioRecordingMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AudioRecordingMapper get() {
        return c();
    }
}
