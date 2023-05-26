package kotlinx.serialization.json.internal;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JsonElementMarker.kt */
/* loaded from: classes5.dex */
public /* synthetic */ class JsonElementMarker$origin$1 extends FunctionReferenceImpl implements Function2<SerialDescriptor, Integer, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public JsonElementMarker$origin$1(Object obj) {
        super(2, obj, JsonElementMarker.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0);
    }

    public final Boolean j(SerialDescriptor p02, int i8) {
        boolean e8;
        Intrinsics.f(p02, "p0");
        e8 = ((JsonElementMarker) this.f50989g).e(p02, i8);
        return Boolean.valueOf(e8);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean s(SerialDescriptor serialDescriptor, Integer num) {
        return j(serialDescriptor, num.intValue());
    }
}
