package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class TimeModule_EventClockFactory implements Factory<Clock> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final TimeModule_EventClockFactory f12365a = new TimeModule_EventClockFactory();

        private InstanceHolder() {
        }
    }

    public static TimeModule_EventClockFactory a() {
        return InstanceHolder.f12365a;
    }

    public static Clock b() {
        return (Clock) Preconditions.c(TimeModule.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* renamed from: c */
    public Clock get() {
        return b();
    }
}
