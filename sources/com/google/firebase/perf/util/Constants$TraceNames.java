package com.google.firebase.perf.util;

import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public enum Constants$TraceNames {
    APP_START_TRACE_NAME("_as"),
    ON_CREATE_TRACE_NAME("_astui"),
    ON_START_TRACE_NAME("_astfd"),
    ON_RESUME_TRACE_NAME("_asti"),
    FOREGROUND_TRACE_NAME("_fs"),
    BACKGROUND_TRACE_NAME("_bs");
    

    /* renamed from: f  reason: collision with root package name */
    private String f16887f;

    Constants$TraceNames(@NonNull String str) {
        this.f16887f = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f16887f;
    }
}
