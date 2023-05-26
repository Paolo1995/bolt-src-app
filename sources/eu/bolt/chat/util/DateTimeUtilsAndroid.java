package eu.bolt.chat.util;

import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDateTime;

/* compiled from: DateTimeUtils.kt */
/* loaded from: classes5.dex */
public final class DateTimeUtilsAndroid {
    public static final Date a(LocalDateTime localDateTime) {
        Intrinsics.f(localDateTime, "<this>");
        return new Date(DateTimeUtilsKt.c(localDateTime));
    }
}
