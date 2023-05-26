package com.google.firebase.crashlytics.internal.common;

/* loaded from: classes3.dex */
public enum DeliveryMechanism {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    

    /* renamed from: f  reason: collision with root package name */
    private final int f15695f;

    DeliveryMechanism(int i8) {
        this.f15695f = i8;
    }

    public static DeliveryMechanism a(String str) {
        if (str != null) {
            return APP_STORE;
        }
        return DEVELOPER;
    }

    public int c() {
        return this.f15695f;
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.f15695f);
    }
}
