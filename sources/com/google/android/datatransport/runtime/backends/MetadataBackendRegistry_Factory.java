package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class MetadataBackendRegistry_Factory implements Factory<MetadataBackendRegistry> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f12150a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CreationContextFactory> f12151b;

    public MetadataBackendRegistry_Factory(Provider<Context> provider, Provider<CreationContextFactory> provider2) {
        this.f12150a = provider;
        this.f12151b = provider2;
    }

    public static MetadataBackendRegistry_Factory a(Provider<Context> provider, Provider<CreationContextFactory> provider2) {
        return new MetadataBackendRegistry_Factory(provider, provider2);
    }

    public static MetadataBackendRegistry c(Context context, Object obj) {
        return new MetadataBackendRegistry(context, (CreationContextFactory) obj);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MetadataBackendRegistry get() {
        return c(this.f12150a.get(), this.f12151b.get());
    }
}
