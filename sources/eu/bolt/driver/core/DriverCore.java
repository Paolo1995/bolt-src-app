package eu.bolt.driver.core;

import eu.bolt.driver.core.di.scope.authorized.AuthorizedCoreComponent;
import eu.bolt.driver.core.di.scope.singleton.SingletonCoreComponent;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverCore.kt */
/* loaded from: classes5.dex */
public final class DriverCore {

    /* renamed from: a  reason: collision with root package name */
    public static final DriverCore f40758a = new DriverCore();

    /* renamed from: b  reason: collision with root package name */
    private static volatile SingletonCoreComponent f40759b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile AuthorizedCoreComponent f40760c;

    /* renamed from: d  reason: collision with root package name */
    private static Function0<? extends AuthorizedCoreComponent> f40761d;

    private DriverCore() {
    }

    public final synchronized AuthorizedCoreComponent a() {
        AuthorizedCoreComponent authorizedCoreComponent;
        if (f40760c == null) {
            Function0<? extends AuthorizedCoreComponent> function0 = f40761d;
            if (function0 == null) {
                Intrinsics.w("authorizedCoreComponentProvider");
                function0 = null;
            }
            f40760c = function0.invoke();
        }
        authorizedCoreComponent = f40760c;
        if (authorizedCoreComponent == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        return authorizedCoreComponent;
    }

    public final synchronized SingletonCoreComponent b() {
        SingletonCoreComponent singletonCoreComponent;
        singletonCoreComponent = f40759b;
        if (singletonCoreComponent == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        return singletonCoreComponent;
    }

    public final synchronized void c(Function0<? extends AuthorizedCoreComponent> authorizedCoreComponentProvider) {
        Intrinsics.f(authorizedCoreComponentProvider, "authorizedCoreComponentProvider");
        f40761d = authorizedCoreComponentProvider;
        if (authorizedCoreComponentProvider == null) {
            Intrinsics.w("authorizedCoreComponentProvider");
            authorizedCoreComponentProvider = null;
        }
        f40760c = authorizedCoreComponentProvider.invoke();
    }
}
