package kotlinx.serialization.internal;

import java.util.Iterator;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: CollectionSerializers.kt */
/* loaded from: classes5.dex */
public abstract class MapLikeSerializer<Key, Value, Collection, Builder extends Map<Key, Value>> extends AbstractCollectionSerializer<Map.Entry<? extends Key, ? extends Value>, Collection, Builder> {

    /* renamed from: a  reason: collision with root package name */
    private final KSerializer<Key> f52213a;

    /* renamed from: b  reason: collision with root package name */
    private final KSerializer<Value> f52214b;

    private MapLikeSerializer(KSerializer<Key> kSerializer, KSerializer<Value> kSerializer2) {
        super(null);
        this.f52213a = kSerializer;
        this.f52214b = kSerializer2;
    }

    public /* synthetic */ MapLikeSerializer(KSerializer kSerializer, KSerializer kSerializer2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSerializer, kSerializer2);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public abstract SerialDescriptor a();

    @Override // kotlinx.serialization.SerializationStrategy
    public void c(Encoder encoder, Collection collection) {
        Intrinsics.f(encoder, "encoder");
        int j8 = j(collection);
        SerialDescriptor a8 = a();
        CompositeEncoder j9 = encoder.j(a8, j8);
        Iterator<Map.Entry<? extends Key, ? extends Value>> i8 = i(collection);
        int i9 = 0;
        while (i8.hasNext()) {
            Map.Entry<? extends Key, ? extends Value> next = i8.next();
            Key key = next.getKey();
            Value value = next.getValue();
            int i10 = i9 + 1;
            j9.B(a(), i9, r(), key);
            j9.B(a(), i10, s(), value);
            i9 = i10 + 1;
        }
        j9.c(a8);
    }

    public final KSerializer<Key> r() {
        return this.f52213a;
    }

    public final KSerializer<Value> s() {
        return this.f52214b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: t */
    public final void l(CompositeDecoder decoder, Builder builder, int i8, int i9) {
        boolean z7;
        IntRange o8;
        IntProgression n8;
        Intrinsics.f(decoder, "decoder");
        Intrinsics.f(builder, "builder");
        if (i9 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            o8 = RangesKt___RangesKt.o(0, i9 * 2);
            n8 = RangesKt___RangesKt.n(o8, 2);
            int g8 = n8.g();
            int i10 = n8.i();
            int k8 = n8.k();
            if ((k8 <= 0 || g8 > i10) && (k8 >= 0 || i10 > g8)) {
                return;
            }
            while (true) {
                m(decoder, i8 + g8, builder, false);
                if (g8 != i10) {
                    g8 += k8;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: u */
    public final void m(CompositeDecoder decoder, int i8, Builder builder, boolean z7) {
        int i9;
        Object c8;
        Object g8;
        Intrinsics.f(decoder, "decoder");
        Intrinsics.f(builder, "builder");
        Object c9 = CompositeDecoder.DefaultImpls.c(decoder, a(), i8, this.f52213a, null, 8, null);
        boolean z8 = true;
        if (z7) {
            i9 = decoder.o(a());
            if (i9 != i8 + 1) {
                z8 = false;
            }
            if (!z8) {
                throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + i8 + ", returned index for value: " + i9).toString());
            }
        } else {
            i9 = i8 + 1;
        }
        int i10 = i9;
        if (builder.containsKey(c9) && !(this.f52214b.a().d() instanceof PrimitiveKind)) {
            SerialDescriptor a8 = a();
            KSerializer<Value> kSerializer = this.f52214b;
            g8 = MapsKt__MapsKt.g(builder, c9);
            c8 = decoder.y(a8, i10, kSerializer, g8);
        } else {
            c8 = CompositeDecoder.DefaultImpls.c(decoder, a(), i10, this.f52214b, null, 8, null);
        }
        builder.put(c9, c8);
    }
}
