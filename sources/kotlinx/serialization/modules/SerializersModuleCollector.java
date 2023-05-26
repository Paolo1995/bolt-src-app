package kotlinx.serialization.modules;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;

/* compiled from: SerializersModuleCollector.kt */
/* loaded from: classes5.dex */
public interface SerializersModuleCollector {

    /* compiled from: SerializersModuleCollector.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static <T> void a(SerializersModuleCollector serializersModuleCollector, KClass<T> kClass, final KSerializer<T> serializer) {
            Intrinsics.f(kClass, "kClass");
            Intrinsics.f(serializer, "serializer");
            serializersModuleCollector.e(kClass, new Function1<List<? extends KSerializer<?>>, KSerializer<?>>() { // from class: kotlinx.serialization.modules.SerializersModuleCollector$contextual$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final KSerializer<?> invoke(List<? extends KSerializer<?>> it) {
                    Intrinsics.f(it, "it");
                    return serializer;
                }
            });
        }
    }

    <Base, Sub extends Base> void a(KClass<Base> kClass, KClass<Sub> kClass2, KSerializer<Sub> kSerializer);

    <Base> void b(KClass<Base> kClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1);

    <T> void c(KClass<T> kClass, KSerializer<T> kSerializer);

    <Base> void d(KClass<Base> kClass, Function1<? super Base, ? extends SerializationStrategy<? super Base>> function1);

    <T> void e(KClass<T> kClass, Function1<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>> function1);
}
