package com.sinch.android.rtc.internal.natives;

import com.sinch.android.rtc.PushPair;

/* loaded from: classes3.dex */
public class PushPayloadDataPair implements PushPair {
    private String payload;
    private byte[] pushData;

    public PushPayloadDataPair(String str, byte[] bArr) {
        this.payload = str;
        this.pushData = bArr;
    }

    @Override // com.sinch.android.rtc.PushPair
    public byte[] getPushData() {
        return this.pushData;
    }

    @Override // com.sinch.android.rtc.PushPair
    public String getPushPayload() {
        return this.payload;
    }
}
