package org.webrtc.audio;

/* loaded from: classes4.dex */
public interface AudioDeviceModule {
    long getNativeAudioDeviceModulePointer();

    void release();

    void setMicrophoneMute(boolean z7);

    void setSpeakerMute(boolean z7);
}
