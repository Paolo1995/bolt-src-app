package org.koin.core.error;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefinitionOverrideException.kt */
/* loaded from: classes5.dex */
public final class DefinitionOverrideException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefinitionOverrideException(String msg) {
        super(msg);
        Intrinsics.f(msg, "msg");
    }
}
