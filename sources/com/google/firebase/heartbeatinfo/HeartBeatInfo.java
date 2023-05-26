package com.google.firebase.heartbeatinfo;

import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public interface HeartBeatInfo {

    /* loaded from: classes3.dex */
    public enum HeartBeat {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);
        

        /* renamed from: f  reason: collision with root package name */
        private final int f16269f;

        HeartBeat(int i8) {
            this.f16269f = i8;
        }

        public int a() {
            return this.f16269f;
        }
    }

    @NonNull
    HeartBeat b(@NonNull String str);
}
