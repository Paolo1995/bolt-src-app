package ee.mtakso.driver.service.analytics.timed;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompositeTimedEvent.kt */
/* loaded from: classes3.dex */
public final class CompositeTimedEventKt {
    public static final void a(CompositeTimedEvent compositeTimedEvent, Map<String, String> newPaylod) {
        Intrinsics.f(compositeTimedEvent, "<this>");
        Intrinsics.f(newPaylod, "newPaylod");
        compositeTimedEvent.b().putAll(newPaylod);
    }

    public static final <T> T b(CompositeTimedEvent compositeTimedEvent, Class<T> clazz) {
        Intrinsics.f(compositeTimedEvent, "<this>");
        Intrinsics.f(clazz, "clazz");
        for (T t7 : compositeTimedEvent.a()) {
            if (Intrinsics.a(((TimedEvent) t7).getClass(), clazz)) {
                return t7;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
