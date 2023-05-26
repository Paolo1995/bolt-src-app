package eu.bolt.driver.earnings.network;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import eu.bolt.driver.earnings.network.DriverBannerComponent;
import java.lang.reflect.Type;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverBannerComponentDeserializer.kt */
/* loaded from: classes5.dex */
public final class DriverBannerComponentDeserializer implements JsonDeserializer<DriverBannerComponent> {

    /* compiled from: DriverBannerComponentDeserializer.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41350a;

        static {
            int[] iArr = new int[DriverBannerComponent.Type.values().length];
            try {
                iArr[DriverBannerComponent.Type.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverBannerComponent.Type.UNKNOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f41350a = iArr;
        }
    }

    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public DriverBannerComponent deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        Intrinsics.f(json, "json");
        Intrinsics.f(typeOfT, "typeOfT");
        Intrinsics.f(context, "context");
        DriverBannerComponent.Type type = (DriverBannerComponent.Type) context.deserialize(json.getAsJsonObject().get("type"), DriverBannerComponent.Type.class);
        if (type == null) {
            type = DriverBannerComponent.Type.UNKNOWN;
        }
        int i8 = WhenMappings.f41350a[type.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
        return (DriverBannerComponent) context.deserialize(json, DriverBannerComponent.Image.class);
    }
}
