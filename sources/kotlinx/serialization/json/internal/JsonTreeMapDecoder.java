package kotlinx.serialization.json.internal;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;

/* compiled from: TreeJsonDecoder.kt */
/* loaded from: classes5.dex */
final class JsonTreeMapDecoder extends JsonTreeDecoder {

    /* renamed from: k  reason: collision with root package name */
    private final JsonObject f52404k;

    /* renamed from: l  reason: collision with root package name */
    private final List<String> f52405l;

    /* renamed from: m  reason: collision with root package name */
    private final int f52406m;

    /* renamed from: n  reason: collision with root package name */
    private int f52407n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeMapDecoder(Json json, JsonObject value) {
        super(json, value, null, null, 12, null);
        List<String> H0;
        Intrinsics.f(json, "json");
        Intrinsics.f(value, "value");
        this.f52404k = value;
        H0 = CollectionsKt___CollectionsKt.H0(v0().keySet());
        this.f52405l = H0;
        this.f52406m = H0.size() * 2;
        this.f52407n = -1;
    }

    @Override // kotlinx.serialization.json.internal.JsonTreeDecoder, kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public void c(SerialDescriptor descriptor) {
        Intrinsics.f(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.json.internal.JsonTreeDecoder, kotlinx.serialization.internal.NamedValueDecoder
    protected String c0(SerialDescriptor desc, int i8) {
        Intrinsics.f(desc, "desc");
        return this.f52405l.get(i8 / 2);
    }

    @Override // kotlinx.serialization.json.internal.JsonTreeDecoder, kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    protected JsonElement g0(String tag) {
        Object g8;
        Intrinsics.f(tag, "tag");
        if (this.f52407n % 2 == 0) {
            return JsonElementKt.a(tag);
        }
        g8 = MapsKt__MapsKt.g(v0(), tag);
        return (JsonElement) g8;
    }

    @Override // kotlinx.serialization.json.internal.JsonTreeDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public int o(SerialDescriptor descriptor) {
        Intrinsics.f(descriptor, "descriptor");
        int i8 = this.f52407n;
        if (i8 < this.f52406m - 1) {
            int i9 = i8 + 1;
            this.f52407n = i9;
            return i9;
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.JsonTreeDecoder, kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    /* renamed from: z0 */
    public JsonObject v0() {
        return this.f52404k;
    }
}
