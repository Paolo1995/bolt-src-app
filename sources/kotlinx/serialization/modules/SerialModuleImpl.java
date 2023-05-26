package kotlinx.serialization.modules;

import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.modules.ContextualProvider;

/* compiled from: SerializersModule.kt */
/* loaded from: classes5.dex */
public final class SerialModuleImpl extends SerializersModule {

    /* renamed from: a  reason: collision with root package name */
    private final Map<KClass<?>, ContextualProvider> f52455a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<KClass<?>, Map<KClass<?>, KSerializer<?>>> f52456b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<KClass<?>, Function1<?, SerializationStrategy<?>>> f52457c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<KClass<?>, Map<String, KSerializer<?>>> f52458d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<KClass<?>, Function1<String, DeserializationStrategy<?>>> f52459e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SerialModuleImpl(Map<KClass<?>, ? extends ContextualProvider> class2ContextualFactory, Map<KClass<?>, ? extends Map<KClass<?>, ? extends KSerializer<?>>> polyBase2Serializers, Map<KClass<?>, ? extends Function1<?, ? extends SerializationStrategy<?>>> polyBase2DefaultSerializerProvider, Map<KClass<?>, ? extends Map<String, ? extends KSerializer<?>>> polyBase2NamedSerializers, Map<KClass<?>, ? extends Function1<? super String, ? extends DeserializationStrategy<?>>> polyBase2DefaultDeserializerProvider) {
        super(null);
        Intrinsics.f(class2ContextualFactory, "class2ContextualFactory");
        Intrinsics.f(polyBase2Serializers, "polyBase2Serializers");
        Intrinsics.f(polyBase2DefaultSerializerProvider, "polyBase2DefaultSerializerProvider");
        Intrinsics.f(polyBase2NamedSerializers, "polyBase2NamedSerializers");
        Intrinsics.f(polyBase2DefaultDeserializerProvider, "polyBase2DefaultDeserializerProvider");
        this.f52455a = class2ContextualFactory;
        this.f52456b = polyBase2Serializers;
        this.f52457c = polyBase2DefaultSerializerProvider;
        this.f52458d = polyBase2NamedSerializers;
        this.f52459e = polyBase2DefaultDeserializerProvider;
    }

    @Override // kotlinx.serialization.modules.SerializersModule
    public void a(SerializersModuleCollector collector) {
        Intrinsics.f(collector, "collector");
        for (Map.Entry<KClass<?>, ContextualProvider> entry : this.f52455a.entrySet()) {
            KClass<?> key = entry.getKey();
            ContextualProvider value = entry.getValue();
            if (value instanceof ContextualProvider.Argless) {
                Intrinsics.d(key, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                KSerializer<?> b8 = ((ContextualProvider.Argless) value).b();
                Intrinsics.d(b8, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                collector.c(key, b8);
            } else if (value instanceof ContextualProvider.WithTypeArguments) {
                collector.e(key, ((ContextualProvider.WithTypeArguments) value).b());
            }
        }
        for (Map.Entry<KClass<?>, Map<KClass<?>, KSerializer<?>>> entry2 : this.f52456b.entrySet()) {
            KClass<?> key2 = entry2.getKey();
            for (Map.Entry<KClass<?>, KSerializer<?>> entry3 : entry2.getValue().entrySet()) {
                KClass<?> key3 = entry3.getKey();
                KSerializer<?> value2 = entry3.getValue();
                Intrinsics.d(key2, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                Intrinsics.d(key3, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                Intrinsics.d(value2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                collector.a(key2, key3, value2);
            }
        }
        for (Map.Entry<KClass<?>, Function1<?, SerializationStrategy<?>>> entry4 : this.f52457c.entrySet()) {
            KClass<?> key4 = entry4.getKey();
            Function1<?, SerializationStrategy<?>> value3 = entry4.getValue();
            Intrinsics.d(key4, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            Intrinsics.d(value3, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'value')] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>{ kotlinx.serialization.modules.SerializersModuleKt.PolymorphicSerializerProvider<kotlin.Any> }");
            collector.d(key4, (Function1) TypeIntrinsics.e(value3, 1));
        }
        for (Map.Entry<KClass<?>, Function1<String, DeserializationStrategy<?>>> entry5 : this.f52459e.entrySet()) {
            KClass<?> key5 = entry5.getKey();
            Function1<String, DeserializationStrategy<?>> value4 = entry5.getValue();
            Intrinsics.d(key5, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            Intrinsics.d(value4, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'className')] kotlin.String?, kotlinx.serialization.DeserializationStrategy<out kotlin.Any>?>{ kotlinx.serialization.modules.SerializersModuleKt.PolymorphicDeserializerProvider<out kotlin.Any> }");
            collector.b(key5, (Function1) TypeIntrinsics.e(value4, 1));
        }
    }

    @Override // kotlinx.serialization.modules.SerializersModule
    public <T> KSerializer<T> b(KClass<T> kClass, List<? extends KSerializer<?>> typeArgumentsSerializers) {
        KSerializer<?> kSerializer;
        Intrinsics.f(kClass, "kClass");
        Intrinsics.f(typeArgumentsSerializers, "typeArgumentsSerializers");
        ContextualProvider contextualProvider = this.f52455a.get(kClass);
        if (contextualProvider != null) {
            kSerializer = contextualProvider.a(typeArgumentsSerializers);
        } else {
            kSerializer = null;
        }
        if (!(kSerializer instanceof KSerializer)) {
            return null;
        }
        return (KSerializer<T>) kSerializer;
    }

    @Override // kotlinx.serialization.modules.SerializersModule
    public <T> DeserializationStrategy<? extends T> d(KClass<? super T> baseClass, String str) {
        KSerializer<?> kSerializer;
        Function1<String, DeserializationStrategy<?>> function1;
        Intrinsics.f(baseClass, "baseClass");
        Map<String, KSerializer<?>> map = this.f52458d.get(baseClass);
        if (map != null) {
            kSerializer = map.get(str);
        } else {
            kSerializer = null;
        }
        if (!(kSerializer instanceof KSerializer)) {
            kSerializer = null;
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        Function1<String, DeserializationStrategy<?>> function12 = this.f52459e.get(baseClass);
        if (TypeIntrinsics.k(function12, 1)) {
            function1 = function12;
        } else {
            function1 = null;
        }
        if (function1 == null) {
            return null;
        }
        return (DeserializationStrategy<? extends T>) function1.invoke(str);
    }

    @Override // kotlinx.serialization.modules.SerializersModule
    public <T> SerializationStrategy<T> e(KClass<? super T> baseClass, T value) {
        KSerializer<?> kSerializer;
        Function1<?, SerializationStrategy<?>> function1;
        Intrinsics.f(baseClass, "baseClass");
        Intrinsics.f(value, "value");
        if (!PlatformKt.i(value, baseClass)) {
            return null;
        }
        Map<KClass<?>, KSerializer<?>> map = this.f52456b.get(baseClass);
        if (map != null) {
            kSerializer = map.get(Reflection.b(value.getClass()));
        } else {
            kSerializer = null;
        }
        if (!(kSerializer instanceof SerializationStrategy)) {
            kSerializer = null;
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        Function1<?, SerializationStrategy<?>> function12 = this.f52457c.get(baseClass);
        if (TypeIntrinsics.k(function12, 1)) {
            function1 = function12;
        } else {
            function1 = null;
        }
        if (function1 == null) {
            return null;
        }
        return (SerializationStrategy<T>) function1.invoke(value);
    }
}
