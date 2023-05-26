package com.google.firebase.heartbeatinfo;

import java.util.List;

/* loaded from: classes3.dex */
public abstract class HeartBeatResult {
    public static HeartBeatResult a(String str, List<String> list) {
        return new AutoValue_HeartBeatResult(str, list);
    }

    public abstract List<String> b();

    public abstract String c();
}
