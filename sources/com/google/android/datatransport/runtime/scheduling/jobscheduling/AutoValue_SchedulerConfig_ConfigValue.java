package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Set;

/* loaded from: classes.dex */
final class AutoValue_SchedulerConfig_ConfigValue extends SchedulerConfig.ConfigValue {

    /* renamed from: a  reason: collision with root package name */
    private final long f12216a;

    /* renamed from: b  reason: collision with root package name */
    private final long f12217b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<SchedulerConfig.Flag> f12218c;

    /* loaded from: classes.dex */
    static final class Builder extends SchedulerConfig.ConfigValue.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f12219a;

        /* renamed from: b  reason: collision with root package name */
        private Long f12220b;

        /* renamed from: c  reason: collision with root package name */
        private Set<SchedulerConfig.Flag> f12221c;

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public SchedulerConfig.ConfigValue a() {
            String str = "";
            if (this.f12219a == null) {
                str = " delta";
            }
            if (this.f12220b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f12221c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new AutoValue_SchedulerConfig_ConfigValue(this.f12219a.longValue(), this.f12220b.longValue(), this.f12221c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public SchedulerConfig.ConfigValue.Builder b(long j8) {
            this.f12219a = Long.valueOf(j8);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public SchedulerConfig.ConfigValue.Builder c(Set<SchedulerConfig.Flag> set) {
            if (set != null) {
                this.f12221c = set;
                return this;
            }
            throw new NullPointerException("Null flags");
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public SchedulerConfig.ConfigValue.Builder d(long j8) {
            this.f12220b = Long.valueOf(j8);
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    long b() {
        return this.f12216a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    Set<SchedulerConfig.Flag> c() {
        return this.f12218c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    long d() {
        return this.f12217b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig.ConfigValue)) {
            return false;
        }
        SchedulerConfig.ConfigValue configValue = (SchedulerConfig.ConfigValue) obj;
        if (this.f12216a == configValue.b() && this.f12217b == configValue.d() && this.f12218c.equals(configValue.c())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j8 = this.f12216a;
        long j9 = this.f12217b;
        return this.f12218c.hashCode() ^ ((((((int) (j8 ^ (j8 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j9 >>> 32) ^ j9))) * 1000003);
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f12216a + ", maxAllowedDelay=" + this.f12217b + ", flags=" + this.f12218c + "}";
    }

    private AutoValue_SchedulerConfig_ConfigValue(long j8, long j9, Set<SchedulerConfig.Flag> set) {
        this.f12216a = j8;
        this.f12217b = j9;
        this.f12218c = set;
    }
}
