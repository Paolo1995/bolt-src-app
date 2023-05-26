package com.google.firebase.crashlytics.internal;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class CrashlyticsNativeComponentDeferredProxy implements CrashlyticsNativeComponent {

    /* renamed from: c  reason: collision with root package name */
    private static final NativeSessionFileProvider f15540c = new MissingNativeSessionFileProvider();

    /* renamed from: a  reason: collision with root package name */
    private final Deferred<CrashlyticsNativeComponent> f15541a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<CrashlyticsNativeComponent> f15542b = new AtomicReference<>(null);

    /* loaded from: classes3.dex */
    private static final class MissingNativeSessionFileProvider implements NativeSessionFileProvider {
        private MissingNativeSessionFileProvider() {
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File a() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File b() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File c() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File d() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File e() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File f() {
            return null;
        }
    }

    public CrashlyticsNativeComponentDeferredProxy(Deferred<CrashlyticsNativeComponent> deferred) {
        this.f15541a = deferred;
        deferred.a(new Deferred.DeferredHandler() { // from class: y.a
            @Override // com.google.firebase.inject.Deferred.DeferredHandler
            public final void a(Provider provider) {
                CrashlyticsNativeComponentDeferredProxy.this.g(provider);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Provider provider) {
        Logger.f().b("Crashlytics native component now available.");
        this.f15542b.set((CrashlyticsNativeComponent) provider.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(String str, String str2, long j8, StaticSessionData staticSessionData, Provider provider) {
        ((CrashlyticsNativeComponent) provider.get()).c(str, str2, j8, staticSessionData);
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    @NonNull
    public NativeSessionFileProvider a(@NonNull String str) {
        CrashlyticsNativeComponent crashlyticsNativeComponent = this.f15542b.get();
        if (crashlyticsNativeComponent == null) {
            return f15540c;
        }
        return crashlyticsNativeComponent.a(str);
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public boolean b() {
        CrashlyticsNativeComponent crashlyticsNativeComponent = this.f15542b.get();
        if (crashlyticsNativeComponent != null && crashlyticsNativeComponent.b()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public void c(@NonNull final String str, @NonNull final String str2, final long j8, @NonNull final StaticSessionData staticSessionData) {
        Logger f8 = Logger.f();
        f8.i("Deferring native open session: " + str);
        this.f15541a.a(new Deferred.DeferredHandler() { // from class: y.b
            @Override // com.google.firebase.inject.Deferred.DeferredHandler
            public final void a(Provider provider) {
                CrashlyticsNativeComponentDeferredProxy.h(str, str2, j8, staticSessionData, provider);
            }
        });
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public boolean d(@NonNull String str) {
        CrashlyticsNativeComponent crashlyticsNativeComponent = this.f15542b.get();
        if (crashlyticsNativeComponent != null && crashlyticsNativeComponent.d(str)) {
            return true;
        }
        return false;
    }
}
