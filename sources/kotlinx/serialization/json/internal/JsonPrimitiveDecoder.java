package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TreeJsonDecoder.kt */
/* loaded from: classes5.dex */
public final class JsonPrimitiveDecoder extends AbstractJsonTreeDecoder {

    /* renamed from: f  reason: collision with root package name */
    private final JsonPrimitive f52393f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonPrimitiveDecoder(Json json, JsonPrimitive value) {
        super(json, value, null);
        Intrinsics.f(json, "json");
        Intrinsics.f(value, "value");
        this.f52393f = value;
        Z("primitive");
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    protected JsonElement g0(String tag) {
        boolean z7;
        Intrinsics.f(tag, "tag");
        if (tag == "primitive") {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return v0();
        }
        throw new IllegalArgumentException("This input can only handle primitives with 'primitive' tag".toString());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int o(SerialDescriptor descriptor) {
        Intrinsics.f(descriptor, "descriptor");
        return 0;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    /* renamed from: x0 */
    public JsonPrimitive v0() {
        return this.f52393f;
    }
}
