package kotlinx.serialization.internal;

import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: Tuples.kt */
/* loaded from: classes5.dex */
public final class TripleSerializer<A, B, C> implements KSerializer<Triple<? extends A, ? extends B, ? extends C>> {

    /* renamed from: a  reason: collision with root package name */
    private final KSerializer<A> f52272a;

    /* renamed from: b  reason: collision with root package name */
    private final KSerializer<B> f52273b;

    /* renamed from: c  reason: collision with root package name */
    private final KSerializer<C> f52274c;

    /* renamed from: d  reason: collision with root package name */
    private final SerialDescriptor f52275d;

    public TripleSerializer(KSerializer<A> aSerializer, KSerializer<B> bSerializer, KSerializer<C> cSerializer) {
        Intrinsics.f(aSerializer, "aSerializer");
        Intrinsics.f(bSerializer, "bSerializer");
        Intrinsics.f(cSerializer, "cSerializer");
        this.f52272a = aSerializer;
        this.f52273b = bSerializer;
        this.f52274c = cSerializer;
        this.f52275d = SerialDescriptorsKt.b("kotlin.Triple", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>(this) { // from class: kotlinx.serialization.internal.TripleSerializer$descriptor$1

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ TripleSerializer<A, B, C> f52276f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.f52276f = this;
            }

            public final void b(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
                KSerializer kSerializer;
                KSerializer kSerializer2;
                KSerializer kSerializer3;
                Intrinsics.f(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
                kSerializer = ((TripleSerializer) this.f52276f).f52272a;
                ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "first", kSerializer.a(), null, false, 12, null);
                kSerializer2 = ((TripleSerializer) this.f52276f).f52273b;
                ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "second", kSerializer2.a(), null, false, 12, null);
                kSerializer3 = ((TripleSerializer) this.f52276f).f52274c;
                ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "third", kSerializer3.a(), null, false, 12, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                b(classSerialDescriptorBuilder);
                return Unit.f50853a;
            }
        });
    }

    private final Triple<A, B, C> i(CompositeDecoder compositeDecoder) {
        Object c8 = CompositeDecoder.DefaultImpls.c(compositeDecoder, a(), 0, this.f52272a, null, 8, null);
        Object c9 = CompositeDecoder.DefaultImpls.c(compositeDecoder, a(), 1, this.f52273b, null, 8, null);
        Object c10 = CompositeDecoder.DefaultImpls.c(compositeDecoder, a(), 2, this.f52274c, null, 8, null);
        compositeDecoder.c(a());
        return new Triple<>(c8, c9, c10);
    }

    private final Triple<A, B, C> j(CompositeDecoder compositeDecoder) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        obj = TuplesKt.f52277a;
        obj2 = TuplesKt.f52277a;
        obj3 = TuplesKt.f52277a;
        while (true) {
            int o8 = compositeDecoder.o(a());
            if (o8 != -1) {
                if (o8 != 0) {
                    if (o8 != 1) {
                        if (o8 == 2) {
                            obj3 = CompositeDecoder.DefaultImpls.c(compositeDecoder, a(), 2, this.f52274c, null, 8, null);
                        } else {
                            throw new SerializationException("Unexpected index " + o8);
                        }
                    } else {
                        obj2 = CompositeDecoder.DefaultImpls.c(compositeDecoder, a(), 1, this.f52273b, null, 8, null);
                    }
                } else {
                    obj = CompositeDecoder.DefaultImpls.c(compositeDecoder, a(), 0, this.f52272a, null, 8, null);
                }
            } else {
                compositeDecoder.c(a());
                obj4 = TuplesKt.f52277a;
                if (obj != obj4) {
                    obj5 = TuplesKt.f52277a;
                    if (obj2 != obj5) {
                        obj6 = TuplesKt.f52277a;
                        if (obj3 != obj6) {
                            return new Triple<>(obj, obj2, obj3);
                        }
                        throw new SerializationException("Element 'third' is missing");
                    }
                    throw new SerializationException("Element 'second' is missing");
                }
                throw new SerializationException("Element 'first' is missing");
            }
        }
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return this.f52275d;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: k */
    public Triple<A, B, C> b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        CompositeDecoder b8 = decoder.b(a());
        if (b8.p()) {
            return i(b8);
        }
        return j(b8);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: l */
    public void c(Encoder encoder, Triple<? extends A, ? extends B, ? extends C> value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        CompositeEncoder b8 = encoder.b(a());
        b8.B(a(), 0, this.f52272a, value.a());
        b8.B(a(), 1, this.f52273b, value.b());
        b8.B(a(), 2, this.f52274c, value.c());
        b8.c(a());
    }
}
