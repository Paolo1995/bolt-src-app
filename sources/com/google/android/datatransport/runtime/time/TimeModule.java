package com.google.android.datatransport.runtime.time;

/* loaded from: classes.dex */
public abstract class TimeModule {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Clock a() {
        return new WallTimeClock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Clock b() {
        return new UptimeClock();
    }
}
