package com.sinch.android.rtc.internal.service.time;

/* loaded from: classes3.dex */
public class SystemClockTimeService implements TimeService {
    @Override // com.sinch.android.rtc.internal.service.time.TimeService
    public long now() {
        return System.currentTimeMillis();
    }
}
