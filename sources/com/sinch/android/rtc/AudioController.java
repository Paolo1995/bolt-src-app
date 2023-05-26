package com.sinch.android.rtc;

/* loaded from: classes3.dex */
public interface AudioController {

    /* loaded from: classes3.dex */
    public static class AudioRoutingConfig {
        private final boolean mManageBluetoothAudio;
        private final UseSpeakerphone mUseSpeakerphoneState;

        public AudioRoutingConfig(UseSpeakerphone useSpeakerphone, boolean z7) {
            this.mUseSpeakerphoneState = useSpeakerphone;
            this.mManageBluetoothAudio = z7;
        }

        public UseSpeakerphone getUseSpeakerphoneState() {
            return this.mUseSpeakerphoneState;
        }

        public boolean isBluetoothAudioManaged() {
            return this.mManageBluetoothAudio;
        }
    }

    /* loaded from: classes3.dex */
    public enum UseSpeakerphone {
        SPEAKERPHONE_AUTO("auto"),
        SPEAKERPHONE_TRUE("true"),
        SPEAKERPHONE_FALSE("false");
        
        private final String state;

        UseSpeakerphone(String str) {
            this.state = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.state;
        }
    }

    void disableAutomaticAudioRouting();

    void disableSpeaker();

    void enableAutomaticAudioRouting(AudioRoutingConfig audioRoutingConfig);

    void enableSpeaker();

    boolean isAutomaticAudioRoutingEnabled();

    boolean isMute();

    boolean isSpeakerOn();

    void mute();

    void setLocalAudioListener(LocalAudioListener localAudioListener);

    void unmute();
}
