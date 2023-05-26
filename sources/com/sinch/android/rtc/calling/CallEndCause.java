package com.sinch.android.rtc.calling;

/* loaded from: classes3.dex */
public enum CallEndCause {
    NONE(0),
    TIMEOUT(1),
    DENIED(2),
    NO_ANSWER(3),
    FAILURE(4),
    HUNG_UP(5),
    CANCELED(6),
    OTHER_DEVICE_ANSWERED(7),
    INACTIVE(8);
    
    private int value;

    CallEndCause(int i8) {
        this.value = i8;
    }

    public int getValue() {
        return this.value;
    }
}
