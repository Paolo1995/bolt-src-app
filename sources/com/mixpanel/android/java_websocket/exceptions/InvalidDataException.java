package com.mixpanel.android.java_websocket.exceptions;

/* loaded from: classes3.dex */
public class InvalidDataException extends Exception {

    /* renamed from: f  reason: collision with root package name */
    private int f19028f;

    public InvalidDataException(int i8) {
        this.f19028f = i8;
    }

    public int a() {
        return this.f19028f;
    }

    public InvalidDataException(int i8, String str) {
        super(str);
        this.f19028f = i8;
    }

    public InvalidDataException(int i8, Throwable th) {
        super(th);
        this.f19028f = i8;
    }
}
