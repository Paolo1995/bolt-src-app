package eu.bolt.driver.earnings.network;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import eu.bolt.driver.earnings.network.EarningLandingItem;
import java.lang.reflect.Type;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningLandingItemDeserializer.kt */
/* loaded from: classes5.dex */
public final class EarningLandingItemDeserializer implements JsonDeserializer<EarningLandingItem> {

    /* compiled from: EarningLandingItemDeserializer.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41442a;

        static {
            int[] iArr = new int[EarningLandingItem.Type.values().length];
            try {
                iArr[EarningLandingItem.Type.BALANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EarningLandingItem.Type.PIE_CHART.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EarningLandingItem.Type.ACTIVITY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EarningLandingItem.Type.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f41442a = iArr;
        }
    }

    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public EarningLandingItem deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        Intrinsics.f(json, "json");
        Intrinsics.f(typeOfT, "typeOfT");
        Intrinsics.f(context, "context");
        EarningLandingItem.Type type = (EarningLandingItem.Type) context.deserialize(json.getAsJsonObject().get("type"), EarningLandingItem.Type.class);
        if (type == null) {
            type = EarningLandingItem.Type.UNKNOWN;
        }
        int i8 = WhenMappings.f41442a[type.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4) {
                        return EarningLandingItem.Empty.f41437a;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                Object deserialize = context.deserialize(json, EarningLandingItem.ActivityItem.class);
                Intrinsics.e(deserialize, "context.deserialize(json…ActivityItem::class.java)");
                return (EarningLandingItem) deserialize;
            }
            Object deserialize2 = context.deserialize(json, EarningLandingItem.PieChart.class);
            Intrinsics.e(deserialize2, "context.deserialize(json…tem.PieChart::class.java)");
            return (EarningLandingItem) deserialize2;
        }
        Object deserialize3 = context.deserialize(json, EarningLandingItem.BalanceItem.class);
        Intrinsics.e(deserialize3, "context.deserialize(json….BalanceItem::class.java)");
        return (EarningLandingItem) deserialize3;
    }
}
