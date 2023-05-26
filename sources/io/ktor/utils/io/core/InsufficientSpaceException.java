package io.ktor.utils.io.core;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Buffer.kt */
/* loaded from: classes5.dex */
public final class InsufficientSpaceException extends Exception {
    public InsufficientSpaceException() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InsufficientSpaceException(String message) {
        super(message);
        Intrinsics.f(message, "message");
    }

    public /* synthetic */ InsufficientSpaceException(String str, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? "Not enough free space" : str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InsufficientSpaceException(String name, int i8, int i9) {
        this("Not enough free space to write " + name + " of " + i8 + " bytes, available " + i9 + " bytes.");
        Intrinsics.f(name, "name");
    }
}
