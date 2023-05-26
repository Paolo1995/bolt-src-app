package ee.mtakso.driver.di.modules;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import eu.bolt.android.audio_recording_engine.engine.AudioRecorderApi;
import eu.bolt.android.audio_recording_engine.engine.AudioRecorderImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TripAudioRecordingModule.kt */
@Module
/* loaded from: classes3.dex */
public final class TripAudioRecordingModule {
    @Provides
    public final AudioRecorderApi a(Context context) {
        Intrinsics.f(context, "context");
        return new AudioRecorderImpl(context);
    }
}
