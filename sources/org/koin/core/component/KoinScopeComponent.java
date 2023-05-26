package org.koin.core.component;

import org.koin.core.scope.Scope;

/* compiled from: KoinScopeComponent.kt */
/* loaded from: classes5.dex */
public interface KoinScopeComponent extends KoinComponent {

    /* compiled from: KoinScopeComponent.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static void a(KoinScopeComponent koinScopeComponent) {
            if (koinScopeComponent.a().m()) {
                koinScopeComponent.a().d();
            }
        }
    }

    Scope a();
}
