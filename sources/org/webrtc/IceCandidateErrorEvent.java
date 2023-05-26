package org.webrtc;

/* loaded from: classes4.dex */
public final class IceCandidateErrorEvent {
    public final String address;
    public final int errorCode;
    public final String errorText;
    public final int port;
    public final String url;

    @CalledByNative
    public IceCandidateErrorEvent(String str, int i8, String str2, int i9, String str3) {
        this.address = str;
        this.port = i8;
        this.url = str2;
        this.errorCode = i9;
        this.errorText = str3;
    }
}
