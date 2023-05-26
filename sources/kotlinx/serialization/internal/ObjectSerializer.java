package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: ObjectSerializer.kt */
/* loaded from: classes5.dex */
public final class ObjectSerializer<T> implements KSerializer<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f52219a;

    /* renamed from: b  reason: collision with root package name */
    private List<? extends Annotation> f52220b;

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f52221c;

    public ObjectSerializer(final String serialName, T objectInstance) {
        List<? extends Annotation> k8;
        Lazy a8;
        Intrinsics.f(serialName, "serialName");
        Intrinsics.f(objectInstance, "objectInstance");
        this.f52219a = objectInstance;
        k8 = CollectionsKt__CollectionsKt.k();
        this.f52220b = k8;
        a8 = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.PUBLICATION, new Function0<SerialDescriptor>() { // from class: kotlinx.serialization.internal.ObjectSerializer$descriptor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final SerialDescriptor invoke() {
                final ObjectSerializer<T> objectSerializer = this;
                return SerialDescriptorsKt.c(serialName, StructureKind.OBJECT.f52127a, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.internal.ObjectSerializer$descriptor$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void b(ClassSerialDescriptorBuilder buildSerialDescriptor) {
                        List<? extends Annotation> list;
                        Intrinsics.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
                        list = ((ObjectSerializer) objectSerializer).f52220b;
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
        this.f52221c = a8;
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return (SerialDescriptor) this.f52221c.getValue();
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public T b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor a8 = a();
        CompositeDecoder b8 = decoder.b(a8);
        int o8 = b8.o(a());
        if (o8 == -1) {
            Unit unit = Unit.f50853a;
            b8.c(a8);
            return this.f52219a;
        }
        throw new SerializationException("Unexpected index " + o8);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void c(Encoder encoder, T value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        encoder.b(a()).c(a());
    }
}
