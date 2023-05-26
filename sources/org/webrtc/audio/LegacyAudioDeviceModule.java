package org.webrtc.audio;

@Deprecated
/* loaded from: classes4.dex */
public class LegacyAudioDeviceModule implements AudioDeviceModule {
    @Override // org.webrtc.audio.AudioDeviceModule
    public long getNativeAudioDeviceModulePointer() {
        return 0L;
    }

    @Override // org.webrtc.audio.AudioDeviceModule
    public void release() {
    }

    @Override // org.webrtc.audio.AudioDeviceModule
    public void setMicrophoneMute(boolean z7) {
        org.webrtc.voiceengine.WebRtcAudioRecord.setMicrophoneMute(z7);
    }

    @Override // org.webrtc.audio.AudioDeviceModule
    public void setSpeakerMute(boolean z7) {
        org.webrtc.voiceengine.WebRtcAudioTrack.setSpeakerMute(z7);
    }
}
