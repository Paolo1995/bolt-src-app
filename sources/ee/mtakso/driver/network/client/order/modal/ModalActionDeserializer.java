package ee.mtakso.driver.network.client.order.modal;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import ee.mtakso.driver.network.client.order.modal.ModalAction;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModalActionDeserializer.kt */
/* loaded from: classes3.dex */
public final class ModalActionDeserializer implements JsonDeserializer<ModalAction> {

    /* compiled from: ModalActionDeserializer.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22626a;

        static {
            int[] iArr = new int[ModalAction.Type.values().length];
            try {
                iArr[ModalAction.Type.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ModalAction.Type.DEEP_LINK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f22626a = iArr;
        }
    }

    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public ModalAction deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        int i8;
        Intrinsics.f(json, "json");
        Intrinsics.f(typeOfT, "typeOfT");
        Intrinsics.f(context, "context");
        ModalAction.Type type = (ModalAction.Type) context.deserialize(json.getAsJsonObject().get("type"), ModalAction.Type.class);
        if (type == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f22626a[type.ordinal()];
        }
        if (i8 != 1) {
            if (i8 != 2) {
                return ModalAction.Empty.f22624f;
            }
            Object deserialize = context.deserialize(json, ModalAction.DeepLink.class);
            Intrinsics.e(deserialize, "context.deserialize(json…ion.DeepLink::class.java)");
            return (ModalAction) deserialize;
        }
        Object deserialize2 = context.deserialize(json, ModalAction.Text.class);
        Intrinsics.e(deserialize2, "context.deserialize(json…lAction.Text::class.java)");
        return (ModalAction) deserialize2;
    }
}
