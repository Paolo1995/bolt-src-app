package io.ktor.util.converters;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConversionService.kt */
/* loaded from: classes5.dex */
public class DataConversionException extends Exception {
    public DataConversionException() {
        this(null, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataConversionException(String message) {
        super(message);
        Intrinsics.f(message, "message");
    }

    public /* synthetic */ DataConversionException(String str, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? "Invalid data format" : str);
    }
}
