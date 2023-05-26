package org.koin.core.error;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoBeanDefFoundException.kt */
/* loaded from: classes5.dex */
public final class NoBeanDefFoundException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoBeanDefFoundException(String msg) {
        super(msg);
        Intrinsics.f(msg, "msg");
    }
}
