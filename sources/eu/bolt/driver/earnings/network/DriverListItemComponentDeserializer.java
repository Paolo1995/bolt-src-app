package eu.bolt.driver.earnings.network;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import eu.bolt.driver.earnings.network.DriverListItemComponent;
import java.lang.reflect.Type;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverListItemComponentDeserializer.kt */
/* loaded from: classes5.dex */
public final class DriverListItemComponentDeserializer implements JsonDeserializer<DriverListItemComponent> {

    /* compiled from: DriverListItemComponentDeserializer.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41402a;

        static {
            int[] iArr = new int[DriverListItemComponent.Type.values().length];
            try {
                iArr[DriverListItemComponent.Type.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverListItemComponent.Type.IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DriverListItemComponent.Type.CHIP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DriverListItemComponent.Type.TEXT_IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DriverListItemComponent.Type.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f41402a = iArr;
        }
    }

    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public DriverListItemComponent deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        Intrinsics.f(json, "json");
        Intrinsics.f(typeOfT, "typeOfT");
        Intrinsics.f(context, "context");
        DriverListItemComponent.Type type = (DriverListItemComponent.Type) context.deserialize(json.getAsJsonObject().get("type"), DriverListItemComponent.Type.class);
        if (type == null) {
            type = DriverListItemComponent.Type.UNKNOWN;
        }
        int i8 = WhenMappings.f41402a[type.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        if (i8 == 5) {
                            return DriverListItemComponent.Empty.f41392a;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    Object deserialize = context.deserialize(json, DriverListItemComponent.TextImage.class);
                    Intrinsics.e(deserialize, "context.deserialize(json…nt.TextImage::class.java)");
                    return (DriverListItemComponent) deserialize;
                }
                Object deserialize2 = context.deserialize(json, DriverListItemComponent.Chip.class);
                Intrinsics.e(deserialize2, "context.deserialize(json…mponent.Chip::class.java)");
                return (DriverListItemComponent) deserialize2;
            }
            Object deserialize3 = context.deserialize(json, DriverListItemComponent.Image.class);
            Intrinsics.e(deserialize3, "context.deserialize(json…ponent.Image::class.java)");
            return (DriverListItemComponent) deserialize3;
        }
        Object deserialize4 = context.deserialize(json, DriverListItemComponent.Text.class);
        Intrinsics.e(deserialize4, "context.deserialize(json…mponent.Text::class.java)");
        return (DriverListItemComponent) deserialize4;
    }
}
