package org.koin.core.error;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScopeAlreadyCreatedException.kt */
/* loaded from: classes5.dex */
public final class ScopeAlreadyCreatedException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScopeAlreadyCreatedException(String s7) {
        super(s7);
        Intrinsics.f(s7, "s");
    }
}
