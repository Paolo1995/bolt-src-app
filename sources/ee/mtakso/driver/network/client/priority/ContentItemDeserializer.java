package ee.mtakso.driver.network.client.priority;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import ee.mtakso.driver.network.client.priority.ContentItem;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentItemDeserializer.kt */
/* loaded from: classes3.dex */
public final class ContentItemDeserializer implements JsonDeserializer<ContentItem> {

    /* compiled from: ContentItemDeserializer.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22669a;

        static {
            int[] iArr = new int[ContentItemType.values().length];
            try {
                iArr[ContentItemType.SEPARATOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ContentItemType.TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ContentItemType.LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f22669a = iArr;
        }
    }

    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public ContentItem deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext jsonContext) throws JsonParseException {
        int i8;
        Intrinsics.f(json, "json");
        Intrinsics.f(typeOfT, "typeOfT");
        Intrinsics.f(jsonContext, "jsonContext");
        ContentItemType contentItemType = (ContentItemType) jsonContext.deserialize(json.getAsJsonObject().get("type"), ContentItemType.class);
        if (contentItemType == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f22669a[contentItemType.ordinal()];
        }
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    return ContentItem.Unknown.f22668a;
                }
                return (ContentItem) jsonContext.deserialize(json, ContentItem.Link.class);
            }
            return (ContentItem) jsonContext.deserialize(json, ContentItem.Text.class);
        }
        return new ContentItem.Separator();
    }
}
