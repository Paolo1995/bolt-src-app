package com.sinch.android.rtc.calling;

/* loaded from: classes3.dex */
public interface CallListener {
    void onCallEnded(Call call);

    void onCallEstablished(Call call);

    void onCallProgressing(Call call);
}
