package com.google.firebase.crashlytics.internal.common;

/* loaded from: classes3.dex */
public class SystemCurrentTimeProvider implements CurrentTimeProvider {
    @Override // com.google.firebase.crashlytics.internal.common.CurrentTimeProvider
    public long a() {
        return System.currentTimeMillis();
    }
}