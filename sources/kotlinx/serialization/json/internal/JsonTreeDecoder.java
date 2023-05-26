package kotlinx.serialization.json.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.internal.JsonInternalDependenciesKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.JsonSchemaCacheKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TreeJsonDecoder.kt */
/* loaded from: classes5.dex */
public class JsonTreeDecoder extends AbstractJsonTreeDecoder {

    /* renamed from: f  reason: collision with root package name */
    private final JsonObject f52396f;

    /* renamed from: g  reason: collision with root package name */
    private final String f52397g;

    /* renamed from: h  reason: collision with root package name */
    private final SerialDescriptor f52398h;

    /* renamed from: i  reason: collision with root package name */
    private int f52399i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f52400j;

    public /* synthetic */ JsonTreeDecoder(Json json, JsonObject jsonObject, String str, SerialDescriptor serialDescriptor, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, jsonObject, (i8 & 4) != 0 ? null : str, (i8 & 8) != 0 ? null : serialDescriptor);
    }

    private final boolean x0(SerialDescriptor serialDescriptor, int i8) {
        boolean z7;
        if (!d().g().f() && !serialDescriptor.j(i8) && serialDescriptor.h(i8).b()) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.f52400j = z7;
        return z7;
    }

    private final boolean y0(SerialDescriptor serialDescriptor, int i8, String str) {
        JsonPrimitive jsonPrimitive;
        Json d8 = d();
        SerialDescriptor h8 = serialDescriptor.h(i8);
        if (!h8.b() && (g0(str) instanceof JsonNull)) {
            return true;
        }
        if (Intrinsics.a(h8.d(), SerialKind.ENUM.f52123a)) {
            JsonElement g02 = g0(str);
            String str2 = null;
            if (g02 instanceof JsonPrimitive) {
                jsonPrimitive = (JsonPrimitive) g02;
            } else {
                jsonPrimitive = null;
            }
            if (jsonPrimitive != null) {
                str2 = JsonElementKt.d(jsonPrimitive);
            }
            if (str2 != null && JsonNamesMapKt.d(h8, d8, str2) == -3) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public boolean D() {
        if (!this.f52400j && super.D()) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public CompositeDecoder b(SerialDescriptor descriptor) {
        Intrinsics.f(descriptor, "descriptor");
        if (descriptor == this.f52398h) {
            return this;
        }
        return super.b(descriptor);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public void c(SerialDescriptor descriptor) {
        Set set;
        Set<String> h8;
        Intrinsics.f(descriptor, "descriptor");
        if (!this.f52370e.g() && !(descriptor.d() instanceof PolymorphicKind)) {
            if (!this.f52370e.j()) {
                h8 = JsonInternalDependenciesKt.a(descriptor);
            } else {
                Set<String> a8 = JsonInternalDependenciesKt.a(descriptor);
                Map map = (Map) JsonSchemaCacheKt.a(d()).a(descriptor, JsonNamesMapKt.c());
                if (map != null) {
                    set = map.keySet();
                } else {
                    set = null;
                }
                if (set == null) {
                    set = SetsKt__SetsKt.b();
                }
                h8 = SetsKt___SetsKt.h(a8, set);
            }
            for (String str : v0().keySet()) {
                if (!h8.contains(str) && !Intrinsics.a(str, this.f52397g)) {
                    throw JsonExceptionsKt.f(str, v0().toString());
                }
            }
        }
    }

    @Override // kotlinx.serialization.internal.NamedValueDecoder
    protected String c0(SerialDescriptor desc, int i8) {
        Object obj;
        boolean z7;
        Intrinsics.f(desc, "desc");
        String f8 = desc.f(i8);
        if (!this.f52370e.j()) {
            return f8;
        }
        if (v0().keySet().contains(f8)) {
            return f8;
        }
        Map map = (Map) JsonSchemaCacheKt.a(d()).b(desc, JsonNamesMapKt.c(), new JsonTreeDecoder$elementName$alternativeNamesMap$1(desc));
        Iterator<T> it = v0().keySet().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                Integer num = (Integer) map.get((String) obj);
                if (num != null && num.intValue() == i8) {
                    z7 = true;
                    continue;
                } else {
                    z7 = false;
                    continue;
                }
                if (z7) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        String str = (String) obj;
        if (str != null) {
            return str;
        }
        return f8;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    protected JsonElement g0(String tag) {
        Object g8;
        Intrinsics.f(tag, "tag");
        g8 = MapsKt__MapsKt.g(v0(), tag);
        return (JsonElement) g8;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int o(SerialDescriptor descriptor) {
        Intrinsics.f(descriptor, "descriptor");
        while (this.f52399i < descriptor.e()) {
            int i8 = this.f52399i;
            this.f52399i = i8 + 1;
            String X = X(descriptor, i8);
            int i9 = this.f52399i - 1;
            this.f52400j = false;
            if (v0().containsKey(X) || x0(descriptor, i9)) {
                if (!this.f52370e.d() || !y0(descriptor, i9, X)) {
                    return i9;
                }
            }
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    /* renamed from: z0 */
    public JsonObject v0() {
        return this.f52396f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeDecoder(Json json, JsonObject value, String str, SerialDescriptor serialDescriptor) {
        super(json, value, null);
        Intrinsics.f(json, "json");
        Intrinsics.f(value, "value");
        this.f52396f = value;
        this.f52397g = str;
        this.f52398h = serialDescriptor;
    }
}
