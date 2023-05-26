package kotlinx.serialization.internal;

/* compiled from: CollectionSerializers.kt */
/* loaded from: classes5.dex */
public abstract class PrimitiveArrayBuilder<Array> {
    public static /* synthetic */ void c(PrimitiveArrayBuilder primitiveArrayBuilder, int i8, int i9, Object obj) {
        if (obj == null) {
            if ((i9 & 1) != 0) {
                i8 = primitiveArrayBuilder.d() + 1;
            }
            primitiveArrayBuilder.b(i8);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ensureCapacity");
    }

    public abstract Array a();

    public abstract void b(int i8);

    public abstract int d();
}
