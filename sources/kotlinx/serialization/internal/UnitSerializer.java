package kotlinx.serialization.internal;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: Primitives.kt */
/* loaded from: classes5.dex */
public final class UnitSerializer implements KSerializer<Unit> {

    /* renamed from: b  reason: collision with root package name */
    public static final UnitSerializer f52298b = new UnitSerializer();

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ObjectSerializer<Unit> f52299a = new ObjectSerializer<>("kotlin.Unit", Unit.f50853a);

    private UnitSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return this.f52299a.a();
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public /* bridge */ /* synthetic */ Object b(Decoder decoder) {
        f(decoder);
        return Unit.f50853a;
    }

    public void f(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        this.f52299a.b(decoder);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, Unit value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        this.f52299a.c(encoder, value);
    }
}
