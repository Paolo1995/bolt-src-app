package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class TimeModule_UptimeClockFactory implements Factory<Clock> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final TimeModule_UptimeClockFactory f12366a = new TimeModule_UptimeClockFactory();

        private InstanceHolder() {
        }
    }

    public static TimeModule_UptimeClockFactory a() {
        return InstanceHolder.f12366a;
    }

    public static Clock c() {
        return (Clock) Preconditions.c(TimeModule.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Clock get() {
        return c();
    }
}
