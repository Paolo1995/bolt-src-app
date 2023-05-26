package com.bumptech.glide.load;

import java.io.IOException;

/* loaded from: classes.dex */
public final class HttpException extends IOException {

    /* renamed from: f  reason: collision with root package name */
    private final int f9913f;

    public HttpException(int i8) {
        this("Http request failed", i8);
    }

    public HttpException(String str, int i8) {
        this(str, i8, null);
    }

    public HttpException(String str, int i8, Throwable th) {
        super(str + ", status code: " + i8, th);
        this.f9913f = i8;
    }
}
