package com.google.firebase.perf.util;

import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public enum Constants$CounterNames {
    TRACE_EVENT_RATE_LIMITED("_fstec"),
    NETWORK_TRACE_EVENT_RATE_LIMITED("_fsntc"),
    TRACE_STARTED_NOT_STOPPED("_tsns"),
    FRAMES_TOTAL("_fr_tot"),
    FRAMES_SLOW("_fr_slo"),
    FRAMES_FROZEN("_fr_fzn");
    

    /* renamed from: f  reason: collision with root package name */
    private String f16879f;

    Constants$CounterNames(@NonNull String str) {
        this.f16879f = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f16879f;
    }
}
