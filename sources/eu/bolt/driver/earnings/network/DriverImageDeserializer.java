package eu.bolt.driver.earnings.network;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import eu.bolt.driver.earnings.network.DriverImage;
import java.lang.reflect.Type;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverImageDeserializer.kt */
/* loaded from: classes5.dex */
public final class DriverImageDeserializer implements JsonDeserializer<DriverImage> {

    /* compiled from: DriverImageDeserializer.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41374a;

        static {
            int[] iArr = new int[DriverImage.Type.values().length];
            try {
                iArr[DriverImage.Type.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverImage.Type.TINTABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DriverImage.Type.LOTTIE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DriverImage.Type.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f41374a = iArr;
        }
    }

    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public DriverImage deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        Intrinsics.f(json, "json");
        Intrinsics.f(typeOfT, "typeOfT");
        Intrinsics.f(context, "context");
        DriverImage.Type type = (DriverImage.Type) context.deserialize(json.getAsJsonObject().get("type"), DriverImage.Type.class);
        if (type == null) {
            type = DriverImage.Type.UNKNOWN;
        }
        int i8 = WhenMappings.f41374a[type.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4) {
                        return DriverImage.Empty.f41367f;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                Object deserialize = context.deserialize(json, DriverImage.Lottie.class);
                Intrinsics.e(deserialize, "context.deserialize(json…Image.Lottie::class.java)");
                return (DriverImage) deserialize;
            }
            Object deserialize2 = context.deserialize(json, DriverImage.Tintable.class);
            Intrinsics.e(deserialize2, "context.deserialize(json…age.Tintable::class.java)");
            return (DriverImage) deserialize2;
        }
        Object deserialize3 = context.deserialize(json, DriverImage.Normal.class);
        Intrinsics.e(deserialize3, "context.deserialize(json…Image.Normal::class.java)");
        return (DriverImage) deserialize3;
    }
}
