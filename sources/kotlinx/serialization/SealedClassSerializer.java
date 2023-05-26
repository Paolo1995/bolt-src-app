package kotlinx.serialization;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;

/* compiled from: SealedSerializer.kt */
/* loaded from: classes5.dex */
public final class SealedClassSerializer<T> extends AbstractPolymorphicSerializer<T> {

    /* renamed from: a  reason: collision with root package name */
    private final KClass<T> f52060a;

    /* renamed from: b  reason: collision with root package name */
    private List<? extends Annotation> f52061b;

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f52062c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<KClass<? extends T>, KSerializer<? extends T>> f52063d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, KSerializer<? extends T>> f52064e;

    public SealedClassSerializer(final String serialName, KClass<T> baseClass, KClass<? extends T>[] subclasses, final KSerializer<? extends T>[] subclassSerializers) {
        List<? extends Annotation> k8;
        Lazy a8;
        List l02;
        Map<KClass<? extends T>, KSerializer<? extends T>> q8;
        int b8;
        Intrinsics.f(serialName, "serialName");
        Intrinsics.f(baseClass, "baseClass");
        Intrinsics.f(subclasses, "subclasses");
        Intrinsics.f(subclassSerializers, "subclassSerializers");
        this.f52060a = baseClass;
        k8 = CollectionsKt__CollectionsKt.k();
        this.f52061b = k8;
        a8 = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.PUBLICATION, new Function0<SerialDescriptor>() { // from class: kotlinx.serialization.SealedClassSerializer$descriptor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final SerialDescriptor invoke() {
                final SealedClassSerializer<T> sealedClassSerializer = this;
                final KSerializer<? extends T>[] kSerializerArr = subclassSerializers;
                return SerialDescriptorsKt.c(serialName, PolymorphicKind.SEALED.f52091a, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.SealedClassSerializer$descriptor$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void b(ClassSerialDescriptorBuilder buildSerialDescriptor) {
                        List<? extends Annotation> list;
                        Intrinsics.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
                        ClassSerialDescriptorBuilder.b(buildSerialDescriptor, "type", BuiltinSerializersKt.H(StringCompanionObject.f51021a).a(), null, false, 12, null);
                        final KSerializer<? extends T>[] kSerializerArr2 = kSerializerArr;
                        ClassSerialDescriptorBuilder.b(buildSerialDescriptor, AppMeasurementSdk.ConditionalUserProperty.VALUE, SerialDescriptorsKt.c("kotlinx.serialization.Sealed<" + sealedClassSerializer.j().d() + '>', SerialKind.CONTEXTUAL.f52122a, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.SealedClassSerializer$descriptor$2$1$elementDescriptor$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final void b(ClassSerialDescriptorBuilder buildSerialDescriptor2) {
                                List<KSerializer> B;
                                Intrinsics.f(buildSerialDescriptor2, "$this$buildSerialDescriptor");
                                B = ArraysKt___ArraysKt.B(kSerializerArr2);
                                for (KSerializer kSerializer : B) {
                                    SerialDescriptor a9 = kSerializer.a();
                                    ClassSerialDescriptorBuilder.b(buildSerialDescriptor2, a9.i(), a9, null, false, 12, null);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                                b(classSerialDescriptorBuilder);
                                return Unit.f50853a;
                            }
                        }), null, false, 12, null);
                        list = ((SealedClassSerializer) sealedClassSerializer).f52061b;
                        buildSerialDescriptor.h(list);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                        b(classSerialDescriptorBuilder);
                        return Unit.f50853a;
                    }
                });
            }
        });
        this.f52062c = a8;
        if (subclasses.length == subclassSerializers.length) {
            l02 = ArraysKt___ArraysKt.l0(subclasses, subclassSerializers);
            q8 = MapsKt__MapsKt.q(l02);
            this.f52063d = q8;
            final Set<Map.Entry<KClass<? extends T>, KSerializer<? extends T>>> entrySet = q8.entrySet();
            Grouping<Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>>, String> grouping = new Grouping<Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>>, String>() { // from class: kotlinx.serialization.SealedClassSerializer$special$$inlined$groupingBy$1
                @Override // kotlin.collections.Grouping
                public String a(Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>> entry) {
                    return entry.getValue().a().i();
                }

                @Override // kotlin.collections.Grouping
                public Iterator<Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>>> b() {
                    return entrySet.iterator();
                }
            };
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>>> b9 = grouping.b();
            while (b9.hasNext()) {
                Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>> next = b9.next();
                String a9 = grouping.a(next);
                Object obj = linkedHashMap.get(a9);
                if (obj == null) {
                    linkedHashMap.containsKey(a9);
                }
                Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>> entry = next;
                Map.Entry entry2 = (Map.Entry) obj;
                String str = a9;
                if (entry2 != null) {
                    throw new IllegalStateException(("Multiple sealed subclasses of '" + j() + "' have the same serial name '" + str + "': '" + entry2.getKey() + "', '" + entry.getKey() + '\'').toString());
                }
                linkedHashMap.put(a9, entry);
            }
            b8 = MapsKt__MapsJVMKt.b(linkedHashMap.size());
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(b8);
            for (Map.Entry entry3 : linkedHashMap.entrySet()) {
                linkedHashMap2.put(entry3.getKey(), (KSerializer) ((Map.Entry) entry3.getValue()).getValue());
            }
            this.f52064e = linkedHashMap2;
            return;
        }
        throw new IllegalArgumentException("All subclasses of sealed class " + j().d() + " should be marked @Serializable");
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return (SerialDescriptor) this.f52062c.getValue();
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public DeserializationStrategy<? extends T> h(CompositeDecoder decoder, String str) {
        Intrinsics.f(decoder, "decoder");
        KSerializer<? extends T> kSerializer = this.f52064e.get(str);
        if (kSerializer == null) {
            return super.h(decoder, str);
        }
        return kSerializer;
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public SerializationStrategy<T> i(Encoder encoder, T value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        KSerializer<? extends T> kSerializer = this.f52063d.get(Reflection.b(value.getClass()));
        if (kSerializer == null) {
            kSerializer = super.i(encoder, value);
        }
        if (kSerializer == null) {
            return null;
        }
        return kSerializer;
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public KClass<T> j() {
        return this.f52060a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SealedClassSerializer(String serialName, KClass<T> baseClass, KClass<? extends T>[] subclasses, KSerializer<? extends T>[] subclassSerializers, Annotation[] classAnnotations) {
        this(serialName, baseClass, subclasses, subclassSerializers);
        List<? extends Annotation> e8;
        Intrinsics.f(serialName, "serialName");
        Intrinsics.f(baseClass, "baseClass");
        Intrinsics.f(subclasses, "subclasses");
        Intrinsics.f(subclassSerializers, "subclassSerializers");
        Intrinsics.f(classAnnotations, "classAnnotations");
        e8 = ArraysKt___ArraysJvmKt.e(classAnnotations);
        this.f52061b = e8;
    }
}
