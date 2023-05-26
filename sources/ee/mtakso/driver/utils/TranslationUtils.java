package ee.mtakso.driver.utils;

import androidx.core.text.TextUtilsCompat;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslationUtils.kt */
/* loaded from: classes5.dex */
public final class TranslationUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final TranslationUtils f36331a = new TranslationUtils();

    private TranslationUtils() {
    }

    public final String a(String targetLanguage, String text) {
        Intrinsics.f(targetLanguage, "targetLanguage");
        Intrinsics.f(text, "text");
        String b8 = TextUtilsCompat.b(text);
        return "https://translate.google.com/#view=home&op=translate&sl=auto&tl=" + targetLanguage + "&text=" + b8;
    }
}
