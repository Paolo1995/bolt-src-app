package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SchemaManager_Factory implements Factory<SchemaManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f12327a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<String> f12328b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Integer> f12329c;

    public SchemaManager_Factory(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        this.f12327a = provider;
        this.f12328b = provider2;
        this.f12329c = provider3;
    }

    public static SchemaManager_Factory a(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        return new SchemaManager_Factory(provider, provider2, provider3);
    }

    public static SchemaManager c(Context context, String str, int i8) {
        return new SchemaManager(context, str, i8);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SchemaManager get() {
        return c(this.f12327a.get(), this.f12328b.get(), this.f12329c.get().intValue());
    }
}
