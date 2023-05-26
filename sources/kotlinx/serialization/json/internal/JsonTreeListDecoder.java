package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TreeJsonDecoder.kt */
/* loaded from: classes5.dex */
public final class JsonTreeListDecoder extends AbstractJsonTreeDecoder {

    /* renamed from: f  reason: collision with root package name */
    private final JsonArray f52401f;

    /* renamed from: g  reason: collision with root package name */
    private final int f52402g;

    /* renamed from: h  reason: collision with root package name */
    private int f52403h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeListDecoder(Json json, JsonArray value) {
        super(json, value, null);
        Intrinsics.f(json, "json");
        Intrinsics.f(value, "value");
        this.f52401f = value;
        this.f52402g = v0().size();
        this.f52403h = -1;
    }

    @Override // kotlinx.serialization.internal.NamedValueDecoder
    protected String c0(SerialDescriptor desc, int i8) {
        Intrinsics.f(desc, "desc");
        return String.valueOf(i8);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    protected JsonElement g0(String tag) {
        Intrinsics.f(tag, "tag");
        return v0().get(Integer.parseInt(tag));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int o(SerialDescriptor descriptor) {
        Intrinsics.f(descriptor, "descriptor");
        int i8 = this.f52403h;
        if (i8 < this.f52402g - 1) {
            int i9 = i8 + 1;
            this.f52403h = i9;
            return i9;
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    /* renamed from: x0 */
    public JsonArray v0() {
        return this.f52401f;
    }
}
