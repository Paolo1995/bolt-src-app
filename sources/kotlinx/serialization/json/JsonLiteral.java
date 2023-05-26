package kotlinx.serialization.json;

import e0.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.internal.StringOpsKt;

/* compiled from: JsonElement.kt */
/* loaded from: classes5.dex */
public final class JsonLiteral extends JsonPrimitive {

    /* renamed from: f  reason: collision with root package name */
    private final boolean f52346f;

    /* renamed from: g  reason: collision with root package name */
    private final String f52347g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonLiteral(Object body, boolean z7) {
        super(null);
        Intrinsics.f(body, "body");
        this.f52346f = z7;
        this.f52347g = body.toString();
    }

    @Override // kotlinx.serialization.json.JsonPrimitive
    public String b() {
        return this.f52347g;
    }

    public boolean d() {
        return this.f52346f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.a(Reflection.b(JsonLiteral.class), Reflection.b(obj.getClass()))) {
            return false;
        }
        JsonLiteral jsonLiteral = (JsonLiteral) obj;
        if (d() == jsonLiteral.d() && Intrinsics.a(b(), jsonLiteral.b())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (a.a(d()) * 31) + b().hashCode();
    }

    @Override // kotlinx.serialization.json.JsonPrimitive
    public String toString() {
        if (d()) {
            StringBuilder sb = new StringBuilder();
            StringOpsKt.c(sb, b());
            String sb2 = sb.toString();
            Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        return b();
    }
}
