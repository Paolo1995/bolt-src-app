package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Map;

/* loaded from: classes.dex */
final class AutoValue_SchedulerConfig extends SchedulerConfig {

    /* renamed from: a  reason: collision with root package name */
    private final Clock f12214a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Priority, SchedulerConfig.ConfigValue> f12215b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_SchedulerConfig(Clock clock, Map<Priority, SchedulerConfig.ConfigValue> map) {
        if (clock != null) {
            this.f12214a = clock;
            if (map != null) {
                this.f12215b = map;
                return;
            }
            throw new NullPointerException("Null values");
        }
        throw new NullPointerException("Null clock");
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    Clock e() {
        return this.f12214a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig)) {
            return false;
        }
        SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
        if (this.f12214a.equals(schedulerConfig.e()) && this.f12215b.equals(schedulerConfig.h())) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    Map<Priority, SchedulerConfig.ConfigValue> h() {
        return this.f12215b;
    }

    public int hashCode() {
        return ((this.f12214a.hashCode() ^ 1000003) * 1000003) ^ this.f12215b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f12214a + ", values=" + this.f12215b + "}";
    }
}
