package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class EventStoreModule_StoreConfigFactory implements Factory<EventStoreConfig> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final EventStoreModule_StoreConfigFactory f12303a = new EventStoreModule_StoreConfigFactory();

        private InstanceHolder() {
        }
    }

    public static EventStoreModule_StoreConfigFactory a() {
        return InstanceHolder.f12303a;
    }

    public static EventStoreConfig c() {
        return (EventStoreConfig) Preconditions.c(EventStoreModule.d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EventStoreConfig get() {
        return c();
    }
}
