package ee.mtakso.driver.ui.screens.home.v3.map.heatmap;

import android.annotation.SuppressLint;
import android.content.Context;
import eu.bolt.driver.core.ui.translation.RawTranslationProvider;
import eu.bolt.kalev.Kalev;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WaitingTimeTranslationProvider.kt */
/* loaded from: classes3.dex */
public final class WaitingTimeTranslationProvider {

    /* renamed from: a  reason: collision with root package name */
    private final RawTranslationProvider f30257a;

    @Inject
    public WaitingTimeTranslationProvider(RawTranslationProvider rawTranslationProvider) {
        Intrinsics.f(rawTranslationProvider, "rawTranslationProvider");
        this.f30257a = rawTranslationProvider;
    }

    @SuppressLint({"DiscouragedApi"})
    private final String a(Context context, String str, Object... objArr) {
        Object b8;
        try {
            Result.Companion companion = Result.f50818g;
            b8 = Result.b(Integer.valueOf(context.getResources().getIdentifier(str, "string", context.getPackageName())));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f50818g;
            b8 = Result.b(ResultKt.a(th));
        }
        Throwable e8 = Result.e(b8);
        if (e8 != null) {
            Kalev.e(e8, "Failed to find string " + str + " in resources");
        }
        if (Result.g(b8)) {
            b8 = null;
        }
        Integer num = (Integer) b8;
        if (num == null || num.intValue() == 0) {
            return null;
        }
        return context.getString(num.intValue(), Arrays.copyOf(objArr, objArr.length));
    }

    public final String b(Context context, String key, Object... args) {
        boolean z7;
        Intrinsics.f(context, "context");
        Intrinsics.f(key, "key");
        Intrinsics.f(args, "args");
        if (args.length == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            String a8 = this.f30257a.a(key);
            if (a8 == null) {
                return a(context, key, Arrays.copyOf(args, args.length));
            }
            return a8;
        }
        String a9 = this.f30257a.a(key);
        if (a9 != null) {
            Object[] copyOf = Arrays.copyOf(args, args.length);
            String format = String.format(a9, Arrays.copyOf(copyOf, copyOf.length));
            Intrinsics.e(format, "format(this, *args)");
            if (format != null) {
                return format;
            }
        }
        return a(context, key, Arrays.copyOf(args, args.length));
    }
}
