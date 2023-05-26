package com.sinch.android.rtc;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public interface LocalAudioListener {
    void onAudioBuffer(int i8, int i9, ByteBuffer byteBuffer);

    void onAudioRecordingStarted(int i8, int i9, int i10, int i11);

    void onAudioRecordingStopped(int i8);
}
