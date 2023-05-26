package io.ktor.http;

import io.ktor.util.date.GMTDate;
import io.ktor.util.date.GMTDateParser;
import io.ktor.util.date.InvalidDateStringException;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: DateUtils.kt */
/* loaded from: classes5.dex */
public final class DateUtilsKt {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f46764a;

    static {
        List<String> n8;
        n8 = CollectionsKt__CollectionsKt.n("***, dd MMM YYYY hh:mm:ss zzz", "****, dd-MMM-YYYY hh:mm:ss zzz", "*** MMM d hh:mm:ss YYYY", "***, dd-MMM-YYYY hh:mm:ss zzz", "***, dd-MMM-YYYY hh-mm-ss zzz", "***, dd MMM YYYY hh:mm:ss zzz", "*** dd-MMM-YYYY hh:mm:ss zzz", "*** dd MMM YYYY hh:mm:ss zzz", "*** dd-MMM-YYYY hh-mm-ss zzz", "***,dd-MMM-YYYY hh:mm:ss zzz", "*** MMM d YYYY hh:mm:ss zzz");
        f46764a = n8;
    }

    public static final GMTDate a(String str) {
        CharSequence Y0;
        Intrinsics.f(str, "<this>");
        Y0 = StringsKt__StringsKt.Y0(str);
        String obj = Y0.toString();
        for (String str2 : f46764a) {
            try {
                return new GMTDateParser(str2).b(str);
            } catch (InvalidDateStringException unused) {
            }
        }
        throw new IllegalStateException(("Failed to parse date: " + obj).toString());
    }
}
