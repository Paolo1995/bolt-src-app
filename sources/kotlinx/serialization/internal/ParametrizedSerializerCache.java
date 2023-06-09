package kotlinx.serialization.internal;

import java.util.List;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: Platform.common.kt */
/* loaded from: classes5.dex */
public interface ParametrizedSerializerCache<T> {
    Object a(KClass<Object> kClass, List<? extends KType> list);
}
