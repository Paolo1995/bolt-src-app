package android.media;

import android.os.Parcelable;

/* loaded from: classes.dex */
public final /* synthetic */ class AudioRecordingConfiguration implements Parcelable {
    static {
        throw new NoClassDefFoundError();
    }

    public native /* synthetic */ AudioDeviceInfo getAudioDevice();

    public native /* synthetic */ int getClientAudioSessionId();

    public native /* synthetic */ int getClientAudioSource();

    public native /* synthetic */ AudioFormat getClientFormat();

    public native /* synthetic */ AudioFormat getFormat();
}
