package org.koin.core.error;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClosedScopeException.kt */
/* loaded from: classes5.dex */
public final class ClosedScopeException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClosedScopeException(String msg) {
        super(msg);
        Intrinsics.f(msg, "msg");
    }
}
