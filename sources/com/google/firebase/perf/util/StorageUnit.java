package com.google.firebase.perf.util;

import okhttp3.internal.ws.RealWebSocket;

/* loaded from: classes3.dex */
public enum StorageUnit {
    TERABYTES(1099511627776L) { // from class: com.google.firebase.perf.util.StorageUnit.1
    },
    GIGABYTES(1073741824) { // from class: com.google.firebase.perf.util.StorageUnit.2
    },
    MEGABYTES(1048576) { // from class: com.google.firebase.perf.util.StorageUnit.3
    },
    KILOBYTES(RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) { // from class: com.google.firebase.perf.util.StorageUnit.4
    },
    BYTES(1) { // from class: com.google.firebase.perf.util.StorageUnit.5
    };
    

    /* renamed from: f  reason: collision with root package name */
    long f16897f;

    public long a(long j8) {
        return (j8 * this.f16897f) / KILOBYTES.f16897f;
    }

    StorageUnit(long j8) {
        this.f16897f = j8;
    }
}
