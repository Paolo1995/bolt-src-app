package kotlinx.serialization.internal;

import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

/* compiled from: Platform.common.kt */
/* loaded from: classes5.dex */
public interface SerializerCache<T> {
    KSerializer<T> a(KClass<Object> kClass);
}
