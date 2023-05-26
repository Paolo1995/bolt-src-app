package eu.bolt.driver.core.language;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LanguageUtils.kt */
/* loaded from: classes5.dex */
public final class LanguageUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final LanguageUtils f40820a = new LanguageUtils();

    private LanguageUtils() {
    }

    public final Locale a(Language language) {
        Intrinsics.f(language, "language");
        return new Locale(language.b(), language.a());
    }

    public final String b(Language language) {
        Intrinsics.f(language, "language");
        String b8 = language.b();
        String a8 = language.a();
        return b8 + "-" + a8;
    }
}
