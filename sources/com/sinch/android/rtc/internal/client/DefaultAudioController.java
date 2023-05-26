package com.sinch.android.rtc.internal.client;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import com.sinch.android.rtc.AudioController;
import com.sinch.android.rtc.LocalAudioListener;
import com.sinch.android.rtc.internal.client.audio.AudioManagerInternal;
import com.sinch.android.rtc.internal.client.audio.SpeakerController;
import java.util.Set;
import org.webrtc.MediaStreamTrack;
import org.webrtc.audio.WebRtcAudioRecord;

/* loaded from: classes3.dex */
public class DefaultAudioController implements AudioControllerInternal {
    private final String TAG = DefaultAudioController.class.getSimpleName();
    private AudioManagerInternal audioManagerInternal;
    public final DefaultSinchClient client;
    public final Context context;
    private final SpeakerController speakerController;
    public AudioController.UseSpeakerphone useSpeakerphone;

    public DefaultAudioController(Context context, DefaultSinchClient defaultSinchClient, SpeakerController speakerController) {
        this.context = context.getApplicationContext();
        this.client = defaultSinchClient;
        this.speakerController = speakerController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$enableAutomaticAudioRouting$0(AudioManagerInternal.AudioDevice audioDevice, Set set) {
        String str = this.TAG;
        Log.d(str, "onAudioDeviceChanged, selected audio device: " + audioDevice.name() + " , available devices: " + set.toString());
    }

    public void checkState() {
        if (this.client.isDisposed()) {
            throw new IllegalStateException("Associated SinchClient is disposed");
        }
        if (!this.client.isStarted()) {
            throw new IllegalStateException("Associated SinchClient is stopped");
        }
    }

    @Override // com.sinch.android.rtc.AudioController
    public void disableAutomaticAudioRouting() {
        AudioManagerInternal audioManagerInternal = this.audioManagerInternal;
        if (audioManagerInternal != null) {
            audioManagerInternal.stop();
        }
    }

    @Override // com.sinch.android.rtc.AudioController
    public void disableSpeaker() {
        checkState();
        disableAutomaticAudioRouting();
        this.speakerController.disable();
    }

    @Override // com.sinch.android.rtc.internal.client.AudioControllerInternal
    public void dispose() {
        AudioManagerInternal audioManagerInternal = this.audioManagerInternal;
        if (audioManagerInternal != null) {
            audioManagerInternal.stop();
        }
    }

    @Override // com.sinch.android.rtc.AudioController
    public void enableAutomaticAudioRouting(AudioController.AudioRoutingConfig audioRoutingConfig) {
        if (this.audioManagerInternal == null || this.useSpeakerphone != audioRoutingConfig.getUseSpeakerphoneState()) {
            disableAutomaticAudioRouting();
            this.useSpeakerphone = audioRoutingConfig.getUseSpeakerphoneState();
            this.audioManagerInternal = AudioManagerInternal.create(this.context, audioRoutingConfig.getUseSpeakerphoneState());
        }
        this.audioManagerInternal.start(new AudioManagerInternal.AudioManagerEvents() { // from class: com.sinch.android.rtc.internal.client.a
            @Override // com.sinch.android.rtc.internal.client.audio.AudioManagerInternal.AudioManagerEvents
            public final void onAudioDeviceChanged(AudioManagerInternal.AudioDevice audioDevice, Set set) {
                DefaultAudioController.this.lambda$enableAutomaticAudioRouting$0(audioDevice, set);
            }
        }, audioRoutingConfig.isBluetoothAudioManaged());
    }

    @Override // com.sinch.android.rtc.AudioController
    public void enableSpeaker() {
        checkState();
        disableAutomaticAudioRouting();
        this.speakerController.enable();
    }

    @Override // com.sinch.android.rtc.AudioController
    public boolean isAutomaticAudioRoutingEnabled() {
        AudioManagerInternal audioManagerInternal = this.audioManagerInternal;
        if (audioManagerInternal != null) {
            return audioManagerInternal.isRunning();
        }
        return false;
    }

    @Override // com.sinch.android.rtc.AudioController
    public boolean isMute() {
        checkState();
        return ((AudioManager) this.context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).isMicrophoneMute();
    }

    @Override // com.sinch.android.rtc.AudioController
    public boolean isSpeakerOn() {
        checkState();
        return ((AudioManager) this.context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).isSpeakerphoneOn();
    }

    @Override // com.sinch.android.rtc.AudioController
    public void mute() {
        checkState();
        ((AudioManager) this.context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).setMicrophoneMute(true);
    }

    @Override // com.sinch.android.rtc.AudioController
    public void setLocalAudioListener(LocalAudioListener localAudioListener) {
        WebRtcAudioRecord.SetLocalAudioListener(localAudioListener);
    }

    @Override // com.sinch.android.rtc.AudioController
    public void unmute() {
        checkState();
        ((AudioManager) this.context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).setMicrophoneMute(false);
    }
}
