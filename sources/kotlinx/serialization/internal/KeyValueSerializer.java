package kotlinx.serialization.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: Tuples.kt */
/* loaded from: classes5.dex */
public abstract class KeyValueSerializer<K, V, R> implements KSerializer<R> {

    /* renamed from: a  reason: collision with root package name */
    private final KSerializer<K> f52193a;

    /* renamed from: b  reason: collision with root package name */
    private final KSerializer<V> f52194b;

    private KeyValueSerializer(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        this.f52193a = kSerializer;
        this.f52194b = kSerializer2;
    }

    public /* synthetic */ KeyValueSerializer(KSerializer kSerializer, KSerializer kSerializer2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSerializer, kSerializer2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.DeserializationStrategy
    public R b(Decoder decoder) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Intrinsics.f(decoder, "decoder");
        CompositeDecoder b8 = decoder.b(a());
        if (!b8.p()) {
            obj = TuplesKt.f52277a;
            obj2 = TuplesKt.f52277a;
            Object obj5 = obj2;
            while (true) {
                int o8 = b8.o(a());
                if (o8 != -1) {
                    if (o8 != 0) {
                        if (o8 == 1) {
                            obj5 = CompositeDecoder.DefaultImpls.c(b8, a(), 1, this.f52194b, null, 8, null);
                        } else {
                            throw new SerializationException("Invalid index: " + o8);
                        }
                    } else {
                        obj = CompositeDecoder.DefaultImpls.c(b8, a(), 0, this.f52193a, null, 8, null);
                    }
                } else {
                    b8.c(a());
                    obj3 = TuplesKt.f52277a;
                    if (obj != obj3) {
                        obj4 = TuplesKt.f52277a;
                        if (obj5 != obj4) {
                            return (R) h(obj, obj5);
                        }
                        throw new SerializationException("Element 'value' is missing");
                    }
                    throw new SerializationException("Element 'key' is missing");
                }
            }
        } else {
            return (R) h(CompositeDecoder.DefaultImpls.c(b8, a(), 0, this.f52193a, null, 8, null), CompositeDecoder.DefaultImpls.c(b8, a(), 1, this.f52194b, null, 8, null));
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void c(Encoder encoder, R r7) {
        Intrinsics.f(encoder, "encoder");
        CompositeEncoder b8 = encoder.b(a());
        b8.B(a(), 0, this.f52193a, f(r7));
        b8.B(a(), 1, this.f52194b, g(r7));
        b8.c(a());
    }

    protected abstract K f(R r7);

    protected abstract V g(R r7);

    protected abstract R h(K k8, V v7);
}
