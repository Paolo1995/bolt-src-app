package com.google.firebase.components;

import androidx.annotation.NonNull;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class OptionalProvider<T> implements Provider<T>, Deferred<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Deferred.DeferredHandler<Object> f15499c = new Deferred.DeferredHandler() { // from class: com.google.firebase.components.j
        @Override // com.google.firebase.inject.Deferred.DeferredHandler
        public final void a(Provider provider) {
            OptionalProvider.f(provider);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private static final Provider<Object> f15500d = new Provider() { // from class: com.google.firebase.components.k
        @Override // com.google.firebase.inject.Provider
        public final Object get() {
            Object g8;
            g8 = OptionalProvider.g();
            return g8;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private Deferred.DeferredHandler<T> f15501a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Provider<T> f15502b;

    private OptionalProvider(Deferred.DeferredHandler<T> deferredHandler, Provider<T> provider) {
        this.f15501a = deferredHandler;
        this.f15502b = provider;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> OptionalProvider<T> e() {
        return new OptionalProvider<>(f15499c, f15500d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(Provider provider) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object g() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(Deferred.DeferredHandler deferredHandler, Deferred.DeferredHandler deferredHandler2, Provider provider) {
        deferredHandler.a(provider);
        deferredHandler2.a(provider);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> OptionalProvider<T> i(Provider<T> provider) {
        return new OptionalProvider<>(null, provider);
    }

    @Override // com.google.firebase.inject.Deferred
    public void a(@NonNull final Deferred.DeferredHandler<T> deferredHandler) {
        Provider<T> provider;
        Provider<T> provider2 = this.f15502b;
        Provider<Object> provider3 = f15500d;
        if (provider2 != provider3) {
            deferredHandler.a(provider2);
            return;
        }
        Provider<T> provider4 = null;
        synchronized (this) {
            provider = this.f15502b;
            if (provider != provider3) {
                provider4 = provider;
            } else {
                final Deferred.DeferredHandler<T> deferredHandler2 = this.f15501a;
                this.f15501a = new Deferred.DeferredHandler() { // from class: com.google.firebase.components.l
                    @Override // com.google.firebase.inject.Deferred.DeferredHandler
                    public final void a(Provider provider5) {
                        OptionalProvider.h(Deferred.DeferredHandler.this, deferredHandler, provider5);
                    }
                };
            }
        }
        if (provider4 != null) {
            deferredHandler.a(provider);
        }
    }

    @Override // com.google.firebase.inject.Provider
    public T get() {
        return this.f15502b.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Provider<T> provider) {
        Deferred.DeferredHandler<T> deferredHandler;
        if (this.f15502b == f15500d) {
            synchronized (this) {
                deferredHandler = this.f15501a;
                this.f15501a = null;
                this.f15502b = provider;
            }
            deferredHandler.a(provider);
            return;
        }
        throw new IllegalStateException("provide() can be called only once.");
    }
}
