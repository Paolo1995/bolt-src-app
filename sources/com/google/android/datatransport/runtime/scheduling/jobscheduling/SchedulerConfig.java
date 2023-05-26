package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue;
import com.google.android.datatransport.runtime.time.Clock;
import com.sinch.android.rtc.internal.client.calling.DefaultCallController;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class SchedulerConfig {

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Clock f12225a;

        /* renamed from: b  reason: collision with root package name */
        private Map<Priority, ConfigValue> f12226b = new HashMap();

        public Builder a(Priority priority, ConfigValue configValue) {
            this.f12226b.put(priority, configValue);
            return this;
        }

        public SchedulerConfig b() {
            if (this.f12225a != null) {
                if (this.f12226b.keySet().size() >= Priority.values().length) {
                    Map<Priority, ConfigValue> map = this.f12226b;
                    this.f12226b = new HashMap();
                    return SchedulerConfig.d(this.f12225a, map);
                }
                throw new IllegalStateException("Not all priorities have been configured");
            }
            throw new NullPointerException("missing required property: clock");
        }

        public Builder c(Clock clock) {
            this.f12225a = clock;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ConfigValue {

        /* loaded from: classes.dex */
        public static abstract class Builder {
            public abstract ConfigValue a();

            public abstract Builder b(long j8);

            public abstract Builder c(Set<Flag> set);

            public abstract Builder d(long j8);
        }

        public static Builder a() {
            return new AutoValue_SchedulerConfig_ConfigValue.Builder().c(Collections.emptySet());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long b();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Set<Flag> c();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long d();
    }

    /* loaded from: classes.dex */
    public enum Flag {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    private long a(int i8, long j8) {
        long j9;
        int i9 = i8 - 1;
        if (j8 > 1) {
            j9 = j8;
        } else {
            j9 = 2;
        }
        return (long) (Math.pow(3.0d, i9) * j8 * Math.max(1.0d, Math.log(10000.0d) / Math.log(j9 * i9)));
    }

    public static Builder b() {
        return new Builder();
    }

    static SchedulerConfig d(Clock clock, Map<Priority, ConfigValue> map) {
        return new AutoValue_SchedulerConfig(clock, map);
    }

    public static SchedulerConfig f(Clock clock) {
        return b().a(Priority.DEFAULT, ConfigValue.a().b(DefaultCallController.ICE_SERVERS_VALID_WINDOW_MS).d(86400000L).a()).a(Priority.HIGHEST, ConfigValue.a().b(1000L).d(86400000L).a()).a(Priority.VERY_LOW, ConfigValue.a().b(86400000L).d(86400000L).c(i(Flag.NETWORK_UNMETERED, Flag.DEVICE_IDLE)).a()).c(clock).b();
    }

    private static <T> Set<T> i(T... tArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(tArr)));
    }

    private void j(JobInfo.Builder builder, Set<Flag> set) {
        if (set.contains(Flag.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(Flag.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(Flag.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    public JobInfo.Builder c(JobInfo.Builder builder, Priority priority, long j8, int i8) {
        builder.setMinimumLatency(g(priority, j8, i8));
        j(builder, h().get(priority).c());
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Clock e();

    public long g(Priority priority, long j8, int i8) {
        long a8 = j8 - e().a();
        ConfigValue configValue = h().get(priority);
        return Math.min(Math.max(a(i8, configValue.b()), a8), configValue.d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Map<Priority, ConfigValue> h();
}
