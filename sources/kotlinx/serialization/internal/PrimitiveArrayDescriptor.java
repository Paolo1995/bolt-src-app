package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: CollectionDescriptors.kt */
/* loaded from: classes5.dex */
public final class PrimitiveArrayDescriptor extends ListLikeDescriptor {

    /* renamed from: c  reason: collision with root package name */
    private final String f52247c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrimitiveArrayDescriptor(SerialDescriptor primitive) {
        super(primitive, null);
        Intrinsics.f(primitive, "primitive");
        this.f52247c = primitive.i() + "Array";
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String i() {
        return this.f52247c;
    }
}
