package com.mixpanel.android.java_websocket.exceptions;

/* loaded from: classes3.dex */
public class IncompleteHandshakeException extends RuntimeException {

    /* renamed from: f  reason: collision with root package name */
    private int f19027f;

    public IncompleteHandshakeException(int i8) {
        this.f19027f = i8;
    }

    public int a() {
        return this.f19027f;
    }

    public IncompleteHandshakeException() {
        this.f19027f = 0;
    }
}
