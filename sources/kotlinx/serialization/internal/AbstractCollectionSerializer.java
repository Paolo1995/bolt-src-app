package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;

/* compiled from: CollectionSerializers.kt */
/* loaded from: classes5.dex */
public abstract class AbstractCollectionSerializer<Element, Collection, Builder> implements KSerializer<Collection> {
    private AbstractCollectionSerializer() {
    }

    public /* synthetic */ AbstractCollectionSerializer(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ void n(AbstractCollectionSerializer abstractCollectionSerializer, CompositeDecoder compositeDecoder, int i8, Object obj, boolean z7, int i9, Object obj2) {
        if (obj2 == null) {
            if ((i9 & 8) != 0) {
                z7 = true;
            }
            abstractCollectionSerializer.m(compositeDecoder, i8, obj, z7);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readElement");
    }

    private final int o(CompositeDecoder compositeDecoder, Builder builder) {
        int k8 = compositeDecoder.k(a());
        h(builder, k8);
        return k8;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Collection b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return k(decoder, null);
    }

    protected abstract Builder f();

    protected abstract int g(Builder builder);

    protected abstract void h(Builder builder, int i8);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Iterator<Element> i(Collection collection);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int j(Collection collection);

    public final Collection k(Decoder decoder, Collection collection) {
        Builder f8;
        Intrinsics.f(decoder, "decoder");
        if (collection == null || (f8 = p(collection)) == null) {
            f8 = f();
        }
        int g8 = g(f8);
        CompositeDecoder b8 = decoder.b(a());
        if (!b8.p()) {
            while (true) {
                int o8 = b8.o(a());
                if (o8 == -1) {
                    break;
                }
                n(this, b8, g8 + o8, f8, false, 8, null);
            }
        } else {
            l(b8, f8, g8, o(b8, f8));
        }
        b8.c(a());
        return q(f8);
    }

    protected abstract void l(CompositeDecoder compositeDecoder, Builder builder, int i8, int i9);

    protected abstract void m(CompositeDecoder compositeDecoder, int i8, Builder builder, boolean z7);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Builder p(Collection collection);

    protected abstract Collection q(Builder builder);
}
