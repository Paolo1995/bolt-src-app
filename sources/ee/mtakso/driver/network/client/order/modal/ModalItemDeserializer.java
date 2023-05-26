package ee.mtakso.driver.network.client.order.modal;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import ee.mtakso.driver.network.client.order.modal.ModalItem;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModalItemDeserializer.kt */
/* loaded from: classes3.dex */
public final class ModalItemDeserializer implements JsonDeserializer<ModalItem> {

    /* compiled from: ModalItemDeserializer.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22636a;

        static {
            int[] iArr = new int[ModalItem.Type.values().length];
            try {
                iArr[ModalItem.Type.ACTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f22636a = iArr;
        }
    }

    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public ModalItem deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        int i8;
        Intrinsics.f(json, "json");
        Intrinsics.f(typeOfT, "typeOfT");
        Intrinsics.f(context, "context");
        ModalItem.Type type = (ModalItem.Type) context.deserialize(json.getAsJsonObject().get("type"), ModalItem.Type.class);
        if (type == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f22636a[type.ordinal()];
        }
        if (i8 == 1) {
            Object deserialize = context.deserialize(json, ModalItem.Action.class);
            Intrinsics.e(deserialize, "context.deserialize(json…lItem.Action::class.java)");
            return (ModalItem) deserialize;
        }
        return ModalItem.Empty.f22635f;
    }
}
