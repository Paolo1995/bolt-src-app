package kotlinx.serialization.json;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: JsonElement.kt */
@Serializable(with = JsonElementSerializer.class)
/* loaded from: classes5.dex */
public abstract class JsonElement {
    public static final Companion Companion = new Companion(null);

    /* compiled from: JsonElement.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<JsonElement> serializer() {
            return JsonElementSerializer.f52337a;
        }
    }

    private JsonElement() {
    }

    public /* synthetic */ JsonElement(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
