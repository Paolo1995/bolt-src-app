package ee.mtakso.driver.network.client.dashboard;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import ee.mtakso.driver.network.client.dashboard.HomeScreenItemPayload;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HomeScreenItemDeserializer.kt */
/* loaded from: classes3.dex */
public final class HomeScreenItemDeserializer implements JsonDeserializer<HomeScreenItem> {

    /* compiled from: HomeScreenItemDeserializer.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f21843a;

        static {
            int[] iArr = new int[HomeScreenItemType.values().length];
            try {
                iArr[HomeScreenItemType.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HomeScreenItemType.TILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f21843a = iArr;
        }
    }

    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public HomeScreenItem deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext jsonContext) throws JsonParseException {
        int i8;
        HomeScreenItemPayload payload;
        Intrinsics.f(json, "json");
        Intrinsics.f(typeOfT, "typeOfT");
        Intrinsics.f(jsonContext, "jsonContext");
        JsonObject asJsonObject = json.getAsJsonObject();
        JsonElement jsonElement = asJsonObject.get("type");
        JsonElement jsonElement2 = asJsonObject.get("payload");
        ItemLayout layout = (ItemLayout) jsonContext.deserialize(asJsonObject.get("layout"), ItemLayout.class);
        HomeScreenItemType homeScreenItemType = (HomeScreenItemType) jsonContext.deserialize(jsonElement, HomeScreenItemType.class);
        if (homeScreenItemType == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f21843a[homeScreenItemType.ordinal()];
        }
        if (i8 != 1) {
            if (i8 == 2) {
                payload = (HomeScreenItemPayload) jsonContext.deserialize(jsonElement2, HomeScreenItemPayload.Title.class);
            } else {
                throw new IllegalArgumentException("No payload provided");
            }
        } else {
            payload = (HomeScreenItemPayload) jsonContext.deserialize(jsonElement2, HomeScreenItemPayload.Banner.class);
        }
        Intrinsics.e(layout, "layout");
        Intrinsics.e(payload, "payload");
        return new HomeScreenItem(layout, payload);
    }
}
