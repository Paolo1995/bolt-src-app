package com.sinch.android.rtc.internal.client;

import com.sinch.android.rtc.internal.Capability;

/* loaded from: classes3.dex */
public class CapabilityUtils {
    public static Capability fromString(String str) {
        if ("voip".equals(str)) {
            return Capability.CALLING;
        }
        return null;
    }
}
