package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;

/* loaded from: classes.dex */
public final class EventStoreModule_SchemaVersionFactory implements Factory<Integer> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final EventStoreModule_SchemaVersionFactory f12302a = new EventStoreModule_SchemaVersionFactory();

        private InstanceHolder() {
        }
    }

    public static EventStoreModule_SchemaVersionFactory a() {
        return InstanceHolder.f12302a;
    }

    public static int c() {
        return EventStoreModule.c();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Integer get() {
        return Integer.valueOf(c());
    }
}
