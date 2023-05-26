package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class CreationContextFactory_Factory implements Factory<CreationContextFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f12142a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Clock> f12143b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Clock> f12144c;

    public CreationContextFactory_Factory(Provider<Context> provider, Provider<Clock> provider2, Provider<Clock> provider3) {
        this.f12142a = provider;
        this.f12143b = provider2;
        this.f12144c = provider3;
    }

    public static CreationContextFactory_Factory a(Provider<Context> provider, Provider<Clock> provider2, Provider<Clock> provider3) {
        return new CreationContextFactory_Factory(provider, provider2, provider3);
    }

    public static CreationContextFactory c(Context context, Clock clock, Clock clock2) {
        return new CreationContextFactory(context, clock, clock2);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CreationContextFactory get() {
        return c(this.f12142a.get(), this.f12143b.get(), this.f12144c.get());
    }
}
