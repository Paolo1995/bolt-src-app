package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: CollectionSerializers.kt */
/* loaded from: classes5.dex */
public abstract class CollectionLikeSerializer<Element, Collection, Builder> extends AbstractCollectionSerializer<Element, Collection, Builder> {

    /* renamed from: a  reason: collision with root package name */
    private final KSerializer<Element> f52151a;

    private CollectionLikeSerializer(KSerializer<Element> kSerializer) {
        super(null);
        this.f52151a = kSerializer;
    }

    public /* synthetic */ CollectionLikeSerializer(KSerializer kSerializer, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSerializer);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public abstract SerialDescriptor a();

    @Override // kotlinx.serialization.SerializationStrategy
    public void c(Encoder encoder, Collection collection) {
        Intrinsics.f(encoder, "encoder");
        int j8 = j(collection);
        SerialDescriptor a8 = a();
        CompositeEncoder j9 = encoder.j(a8, j8);
        Iterator<Element> i8 = i(collection);
        for (int i9 = 0; i9 < j8; i9++) {
            j9.B(a(), i9, this.f52151a, i8.next());
        }
        j9.c(a8);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    protected final void l(CompositeDecoder decoder, Builder builder, int i8, int i9) {
        boolean z7;
        Intrinsics.f(decoder, "decoder");
        if (i9 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            for (int i10 = 0; i10 < i9; i10++) {
                m(decoder, i8 + i10, builder, false);
            }
            return;
        }
        throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    protected void m(CompositeDecoder decoder, int i8, Builder builder, boolean z7) {
        Intrinsics.f(decoder, "decoder");
        s(builder, i8, CompositeDecoder.DefaultImpls.c(decoder, a(), i8, this.f52151a, null, 8, null));
    }

    protected abstract void s(Builder builder, int i8, Element element);
}
