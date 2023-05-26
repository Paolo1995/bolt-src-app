package io.ktor.util.date;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GMTDateParser.kt */
/* loaded from: classes5.dex */
public final class InvalidDateStringException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidDateStringException(String data, int i8, String pattern) {
        super("Failed to parse date string: \"" + data + "\" at index " + i8 + ". Pattern: \"" + pattern + '\"');
        Intrinsics.f(data, "data");
        Intrinsics.f(pattern, "pattern");
    }
}
