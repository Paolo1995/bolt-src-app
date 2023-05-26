package ee.mtakso.driver.network.client.modal;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import ee.mtakso.driver.network.client.modal.ModalDialogResponse;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModalDeseralizer.kt */
/* loaded from: classes3.dex */
public final class ModalDeserializer implements JsonDeserializer<ModalDialogResponse> {

    /* compiled from: ModalDeseralizer.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22282a;

        static {
            int[] iArr = new int[ModalDialogResponse.Type.values().length];
            try {
                iArr[ModalDialogResponse.Type.DYNAMIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ModalDialogResponse.Type.STORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ModalDialogResponse.Type.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f22282a = iArr;
        }
    }

    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public ModalDialogResponse deserialize(JsonElement json, Type type, JsonDeserializationContext context) {
        int i8;
        Intrinsics.f(json, "json");
        Intrinsics.f(context, "context");
        ModalDialogResponse.Type type2 = (ModalDialogResponse.Type) context.deserialize(json.getAsJsonObject().get("type"), ModalDialogResponse.Type.class);
        if (type2 == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f22282a[type2.ordinal()];
        }
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    Object deserialize = context.deserialize(json, ModalDialogResponse.Banner.class);
                    Intrinsics.e(deserialize, "context.deserialize<Moda…ponse.Banner::class.java)");
                    return (ModalDialogResponse) deserialize;
                }
                throw new IllegalArgumentException("No data provided");
            }
            Object deserialize2 = context.deserialize(json, ModalDialogResponse.Story.class);
            Intrinsics.e(deserialize2, "context.deserialize<Moda…sponse.Story::class.java)");
            return (ModalDialogResponse) deserialize2;
        }
        Object deserialize3 = context.deserialize(json, ModalDialogResponse.Dialog.class);
        Intrinsics.e(deserialize3, "context.deserialize<Moda…ponse.Dialog::class.java)");
        return (ModalDialogResponse) deserialize3;
    }
}
