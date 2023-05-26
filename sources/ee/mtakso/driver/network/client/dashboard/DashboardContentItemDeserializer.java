package ee.mtakso.driver.network.client.dashboard;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import ee.mtakso.driver.network.client.dashboard.DashboardContentItem;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DashboardContentItemDeserializer.kt */
/* loaded from: classes3.dex */
public final class DashboardContentItemDeserializer implements JsonDeserializer<DashboardContentItem> {

    /* compiled from: DashboardContentItemDeserializer.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f21837a;

        static {
            int[] iArr = new int[DashboardContentItemType.values().length];
            try {
                iArr[DashboardContentItemType.ICON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DashboardContentItemType.TAGS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DashboardContentItemType.SEPARATOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DashboardContentItemType.COUNTERS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DashboardContentItemType.LINK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DashboardContentItemType.BONUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DashboardContentItemType.TEXT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[DashboardContentItemType.BADGES.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[DashboardContentItemType.BUTTON.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f21837a = iArr;
        }
    }

    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public DashboardContentItem deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext jsonContext) throws JsonParseException {
        int i8;
        Intrinsics.f(json, "json");
        Intrinsics.f(typeOfT, "typeOfT");
        Intrinsics.f(jsonContext, "jsonContext");
        DashboardContentItemType dashboardContentItemType = (DashboardContentItemType) jsonContext.deserialize(json.getAsJsonObject().get("type"), DashboardContentItemType.class);
        if (dashboardContentItemType == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f21837a[dashboardContentItemType.ordinal()];
        }
        switch (i8) {
            case 1:
                return (DashboardContentItem) jsonContext.deserialize(json, DashboardContentItem.Icon.class);
            case 2:
                return (DashboardContentItem) jsonContext.deserialize(json, DashboardContentItem.Tags.class);
            case 3:
                return new DashboardContentItem.Separator();
            case 4:
                return (DashboardContentItem) jsonContext.deserialize(json, DashboardContentItem.Counters.class);
            case 5:
                return (DashboardContentItem) jsonContext.deserialize(json, DashboardContentItem.Link.class);
            case 6:
                return (DashboardContentItem) jsonContext.deserialize(json, DashboardContentItem.Bonus.class);
            case 7:
                return (DashboardContentItem) jsonContext.deserialize(json, DashboardContentItem.Text.class);
            case 8:
                return (DashboardContentItem) jsonContext.deserialize(json, DashboardContentItem.BadgeGroup.class);
            case 9:
                return (DashboardContentItem) jsonContext.deserialize(json, DashboardContentItem.Button.class);
            default:
                return DashboardContentItem.Unknown.f21836a;
        }
    }
}
