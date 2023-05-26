package ee.mtakso.driver.network.client.order;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import ee.mtakso.driver.network.client.order.ScheduledRideDetailsComponent;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledRideDetailsComponentDeserializer.kt */
/* loaded from: classes3.dex */
public final class ScheduledRideDetailsComponentDeserializer implements JsonDeserializer<ScheduledRideDetailsComponent> {

    /* compiled from: ScheduledRideDetailsComponentDeserializer.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22578a;

        static {
            int[] iArr = new int[ScheduledRideDetailsComponent.Type.values().length];
            try {
                iArr[ScheduledRideDetailsComponent.Type.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScheduledRideDetailsComponent.Type.TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScheduledRideDetailsComponent.Type.LIST_ITEM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ScheduledRideDetailsComponent.Type.LINK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ScheduledRideDetailsComponent.Type.BUTTON.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ScheduledRideDetailsComponent.Type.SECTION_DIVIDER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f22578a = iArr;
        }
    }

    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public ScheduledRideDetailsComponent deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        int i8;
        Intrinsics.f(json, "json");
        Intrinsics.f(typeOfT, "typeOfT");
        Intrinsics.f(context, "context");
        ScheduledRideDetailsComponent.Type type = (ScheduledRideDetailsComponent.Type) context.deserialize(json.getAsJsonObject().get("type"), ScheduledRideDetailsComponent.Type.class);
        if (type == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f22578a[type.ordinal()];
        }
        switch (i8) {
            case 1:
                Object deserialize = context.deserialize(json, ScheduledRideDetailsComponent.Header.class);
                Intrinsics.e(deserialize, "context.deserialize(json…onent.Header::class.java)");
                return (ScheduledRideDetailsComponent) deserialize;
            case 2:
                Object deserialize2 = context.deserialize(json, ScheduledRideDetailsComponent.Text.class);
                Intrinsics.e(deserialize2, "context.deserialize(json…mponent.Text::class.java)");
                return (ScheduledRideDetailsComponent) deserialize2;
            case 3:
                Object deserialize3 = context.deserialize(json, ScheduledRideDetailsComponent.ListItem.class);
                Intrinsics.e(deserialize3, "context.deserialize(json…ent.ListItem::class.java)");
                return (ScheduledRideDetailsComponent) deserialize3;
            case 4:
                Object deserialize4 = context.deserialize(json, ScheduledRideDetailsComponent.Link.class);
                Intrinsics.e(deserialize4, "context.deserialize(json…mponent.Link::class.java)");
                return (ScheduledRideDetailsComponent) deserialize4;
            case 5:
                Object deserialize5 = context.deserialize(json, ScheduledRideDetailsComponent.Button.class);
                Intrinsics.e(deserialize5, "context.deserialize(json…onent.Button::class.java)");
                return (ScheduledRideDetailsComponent) deserialize5;
            case 6:
                return ScheduledRideDetailsComponent.SectionDivider.f22576a;
            default:
                return ScheduledRideDetailsComponent.Empty.f22563a;
        }
    }
}
