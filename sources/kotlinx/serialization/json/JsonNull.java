package kotlinx.serialization.json;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: JsonElement.kt */
@Serializable(with = JsonNullSerializer.class)
/* loaded from: classes5.dex */
public final class JsonNull extends JsonPrimitive {
    public static final JsonNull INSTANCE = new JsonNull();

    /* renamed from: f  reason: collision with root package name */
    private static final String f52350f = "null";

    /* renamed from: g  reason: collision with root package name */
    private static final /* synthetic */ Lazy<KSerializer<Object>> f52351g;

    static {
        Lazy<KSerializer<Object>> a8;
        a8 = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.PUBLICATION, new Function0<KSerializer<Object>>() { // from class: kotlinx.serialization.json.JsonNull$$cachedSerializer$delegate$1
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final KSerializer<Object> invoke() {
                return JsonNullSerializer.f52353a;
            }
        });
        f52351g = a8;
    }

    private JsonNull() {
        super(null);
    }

    private final /* synthetic */ Lazy d() {
        return f52351g;
    }

    @Override // kotlinx.serialization.json.JsonPrimitive
    public String b() {
        return f52350f;
    }

    public final KSerializer<JsonNull> serializer() {
        return (KSerializer) d().getValue();
    }
}
