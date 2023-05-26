package eu.bolt.driver.core.ui.translation;

import java.util.Map;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RawTranslationProvider.kt */
@Singleton
/* loaded from: classes5.dex */
public final class RawTranslationProvider {
    public final String a(String rawKey) {
        Intrinsics.f(rawKey, "rawKey");
        Map<String, String> b8 = TranslationManager.f41205b.b();
        if (b8 != null) {
            return b8.get(rawKey);
        }
        return null;
    }
}
