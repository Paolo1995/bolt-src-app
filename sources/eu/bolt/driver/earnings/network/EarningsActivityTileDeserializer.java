package eu.bolt.driver.earnings.network;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import eu.bolt.driver.earnings.network.EarningsActivityTile;
import java.lang.reflect.Type;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsActivityTileDeserializer.kt */
/* loaded from: classes5.dex */
public final class EarningsActivityTileDeserializer implements JsonDeserializer<EarningsActivityTile> {

    /* compiled from: EarningsActivityTileDeserializer.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41470a;

        static {
            int[] iArr = new int[EarningsActivityTile.Type.values().length];
            try {
                iArr[EarningsActivityTile.Type.CHART.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EarningsActivityTile.Type.TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EarningsActivityTile.Type.TEXT_WITH_ICON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EarningsActivityTile.Type.PROGRESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EarningsActivityTile.Type.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f41470a = iArr;
        }
    }

    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public EarningsActivityTile deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        Intrinsics.f(json, "json");
        Intrinsics.f(typeOfT, "typeOfT");
        Intrinsics.f(context, "context");
        EarningsActivityTile.Type type = (EarningsActivityTile.Type) context.deserialize(json.getAsJsonObject().get("type"), EarningsActivityTile.Type.class);
        if (type == null) {
            type = EarningsActivityTile.Type.UNKNOWN;
        }
        int i8 = WhenMappings.f41470a[type.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        if (i8 == 5) {
                            return EarningsActivityTile.Empty.f41456a;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    Object deserialize = context.deserialize(json, EarningsActivityTile.Progress.class);
                    Intrinsics.e(deserialize, "context.deserialize(json…ile.Progress::class.java)");
                    return (EarningsActivityTile) deserialize;
                }
                Object deserialize2 = context.deserialize(json, EarningsActivityTile.TextWithIcon.class);
                Intrinsics.e(deserialize2, "context.deserialize(json…TextWithIcon::class.java)");
                return (EarningsActivityTile) deserialize2;
            }
            Object deserialize3 = context.deserialize(json, EarningsActivityTile.Text.class);
            Intrinsics.e(deserialize3, "context.deserialize(json…ityTile.Text::class.java)");
            return (EarningsActivityTile) deserialize3;
        }
        Object deserialize4 = context.deserialize(json, EarningsActivityTile.Chart.class);
        Intrinsics.e(deserialize4, "context.deserialize(json…tyTile.Chart::class.java)");
        return (EarningsActivityTile) deserialize4;
    }
}
