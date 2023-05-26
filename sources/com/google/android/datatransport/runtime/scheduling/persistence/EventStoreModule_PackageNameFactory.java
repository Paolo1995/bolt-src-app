package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class EventStoreModule_PackageNameFactory implements Factory<String> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f12301a;

    public EventStoreModule_PackageNameFactory(Provider<Context> provider) {
        this.f12301a = provider;
    }

    public static EventStoreModule_PackageNameFactory a(Provider<Context> provider) {
        return new EventStoreModule_PackageNameFactory(provider);
    }

    public static String c(Context context) {
        return (String) Preconditions.c(EventStoreModule.b(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public String get() {
        return c(this.f12301a.get());
    }
}
