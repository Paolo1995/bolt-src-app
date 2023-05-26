package android.media;

import android.annotation.NonNull;

/* loaded from: classes.dex */
public final /* synthetic */ class AudioDeviceInfo {
    static {
        throw new NoClassDefFoundError();
    }

    @NonNull
    public native /* synthetic */ int[] getChannelCounts();

    @NonNull
    public native /* synthetic */ int[] getEncodings();

    public native /* synthetic */ int getId();

    public native /* synthetic */ CharSequence getProductName();

    @NonNull
    public native /* synthetic */ int[] getSampleRates();

    public native /* synthetic */ int getType();

    public native /* synthetic */ boolean isSink();

    public native /* synthetic */ boolean isSource();
}
