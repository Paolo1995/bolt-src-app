package ee.mtakso.driver.network.client.driver.navigation;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import ee.mtakso.driver.network.client.driver.navigation.DynamicNavigationOption;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DynamicOptionDeserializer.kt */
/* loaded from: classes3.dex */
public final class DynamicOptionDeserializer implements JsonDeserializer<DynamicNavigationOption> {

    /* compiled from: DynamicOptionDeserializer.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22079a;

        static {
            int[] iArr = new int[DynamicNavigationOption.DynamicNavigationType.values().length];
            try {
                iArr[DynamicNavigationOption.DynamicNavigationType.NATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DynamicNavigationOption.DynamicNavigationType.THIRD_PARTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f22079a = iArr;
        }
    }

    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public DynamicNavigationOption deserialize(JsonElement json, Type type, JsonDeserializationContext context) {
        int i8;
        Intrinsics.f(json, "json");
        Intrinsics.f(context, "context");
        DynamicNavigationOption.DynamicNavigationType dynamicNavigationType = (DynamicNavigationOption.DynamicNavigationType) context.deserialize(json.getAsJsonObject().get("type"), DynamicNavigationOption.DynamicNavigationType.class);
        if (dynamicNavigationType == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f22079a[dynamicNavigationType.ordinal()];
        }
        if (i8 != 1) {
            if (i8 != 2) {
                return DynamicNavigationOption.Unknown.f22078a;
            }
            Object deserialize = context.deserialize(json, DynamicNavigationOption.ThirdParty.class);
            Intrinsics.e(deserialize, "context.deserialize<Dyna…:class.java\n            )");
            return (DynamicNavigationOption) deserialize;
        }
        Object deserialize2 = context.deserialize(json, DynamicNavigationOption.Native.class);
        Intrinsics.e(deserialize2, "context.deserialize<Dyna…:class.java\n            )");
        return (DynamicNavigationOption) deserialize2;
    }
}
