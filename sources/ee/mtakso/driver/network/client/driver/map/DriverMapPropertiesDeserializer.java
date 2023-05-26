package ee.mtakso.driver.network.client.driver.map;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import ee.mtakso.driver.network.client.driver.map.DriverMapProperties;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverMapPropertiesDeserializer.kt */
/* loaded from: classes3.dex */
public final class DriverMapPropertiesDeserializer implements JsonDeserializer<DriverMapProperties> {

    /* compiled from: DriverMapPropertiesDeserializer.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22045a;

        static {
            int[] iArr = new int[DriverMapPropertiesType.values().length];
            try {
                iArr[DriverMapPropertiesType.LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverMapPropertiesType.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DriverMapPropertiesType.LOCATION_AWARE_POLYGON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DriverMapPropertiesType.LOCATION_AWARE_LINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f22045a = iArr;
        }
    }

    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public DriverMapProperties deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        int i8;
        Intrinsics.f(json, "json");
        Intrinsics.f(typeOfT, "typeOfT");
        Intrinsics.f(context, "context");
        DriverMapPropertiesType driverMapPropertiesType = (DriverMapPropertiesType) context.deserialize(json.getAsJsonObject().get("type"), DriverMapPropertiesType.class);
        if (driverMapPropertiesType == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f22045a[driverMapPropertiesType.ordinal()];
        }
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        return DriverMapProperties.Unknown.f22044a;
                    }
                    Object deserialize = context.deserialize(json, DriverMapProperties.LocationAwareLine.class);
                    Intrinsics.e(deserialize, "context.deserialize(json…ionAwareLine::class.java)");
                    return (DriverMapProperties) deserialize;
                }
                Object deserialize2 = context.deserialize(json, DriverMapProperties.LocationAwarePolygon.class);
                Intrinsics.e(deserialize2, "context.deserialize(json…AwarePolygon::class.java)");
                return (DriverMapProperties) deserialize2;
            }
            Object deserialize3 = context.deserialize(json, DriverMapProperties.Polygon.class);
            Intrinsics.e(deserialize3, "context.deserialize(json…ties.Polygon::class.java)");
            return (DriverMapProperties) deserialize3;
        }
        Object deserialize4 = context.deserialize(json, DriverMapProperties.Label.class);
        Intrinsics.e(deserialize4, "context.deserialize(json…erties.Label::class.java)");
        return (DriverMapProperties) deserialize4;
    }
}
