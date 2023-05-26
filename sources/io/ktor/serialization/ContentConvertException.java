package io.ktor.serialization;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentConvertException.kt */
/* loaded from: classes5.dex */
public class ContentConvertException extends Exception {
    public /* synthetic */ ContentConvertException(String str, Throwable th, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i8 & 2) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentConvertException(String message, Throwable th) {
        super(message, th);
        Intrinsics.f(message, "message");
    }
}
