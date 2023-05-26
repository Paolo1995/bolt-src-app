package eu.bolt.driver.earnings.network;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import eu.bolt.driver.earnings.network.DriverButtonAction;
import java.lang.reflect.Type;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverButtonActionDeserializer.kt */
/* loaded from: classes5.dex */
public final class DriverButtonActionDeserializer implements JsonDeserializer<DriverButtonAction> {

    /* compiled from: DriverButtonActionDeserializer.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41360a;

        static {
            int[] iArr = new int[DriverButtonAction.Type.values().length];
            try {
                iArr[DriverButtonAction.Type.CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverButtonAction.Type.DEEP_LINK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DriverButtonAction.Type.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f41360a = iArr;
        }
    }

    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public DriverButtonAction deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        Intrinsics.f(json, "json");
        Intrinsics.f(typeOfT, "typeOfT");
        Intrinsics.f(context, "context");
        DriverButtonAction.Type type = (DriverButtonAction.Type) context.deserialize(json.getAsJsonObject().get("type"), DriverButtonAction.Type.class);
        if (type == null) {
            type = DriverButtonAction.Type.UNKNOWN;
        }
        int i8 = WhenMappings.f41360a[type.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return DriverButtonAction.Unknown.f41359a;
                }
                throw new NoWhenBranchMatchedException();
            }
            Object deserialize = context.deserialize(json, DriverButtonAction.DeepLink.class);
            Intrinsics.e(deserialize, "context.deserialize(json…ion.DeepLink::class.java)");
            return (DriverButtonAction) deserialize;
        }
        return DriverButtonAction.Close.f41357a;
    }
}
