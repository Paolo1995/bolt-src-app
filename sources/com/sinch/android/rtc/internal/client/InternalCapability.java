package com.sinch.android.rtc.internal.client;

/* loaded from: classes3.dex */
public enum InternalCapability {
    PUSH("push"),
    ONLINE("online"),
    ICE_RESTART("ice-restart");
    
    private final String capability;

    InternalCapability(String str) {
        this.capability = str;
    }

    public static InternalCapability getFromString(String str) {
        InternalCapability[] values;
        for (InternalCapability internalCapability : values()) {
            if (internalCapability.toString().equals(str)) {
                return internalCapability;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.capability;
    }
}
