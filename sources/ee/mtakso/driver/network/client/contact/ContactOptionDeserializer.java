package ee.mtakso.driver.network.client.contact;

import com.appsflyer.AppsFlyerProperties;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import ee.mtakso.driver.network.client.contact.ContactOption;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactOptionDeserializer.kt */
/* loaded from: classes3.dex */
public final class ContactOptionDeserializer implements JsonDeserializer<ContactOption> {

    /* compiled from: ContactOptionDeserializer.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f21789a;

        static {
            int[] iArr = new int[Channel.values().length];
            try {
                iArr[Channel.PHONE_CALL_SUPPORT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Channel.PHONE_CALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Channel.SIMPLE_MESSAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Channel.VOIP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Channel.CHAT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f21789a = iArr;
        }
    }

    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public ContactOption deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext jsonContext) throws JsonParseException {
        int i8;
        Intrinsics.f(json, "json");
        Intrinsics.f(typeOfT, "typeOfT");
        Intrinsics.f(jsonContext, "jsonContext");
        Channel channel = (Channel) jsonContext.deserialize(json.getAsJsonObject().get(AppsFlyerProperties.CHANNEL), Channel.class);
        if (channel == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f21789a[channel.ordinal()];
        }
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        if (i8 != 5) {
                            return null;
                        }
                        return (ContactOption) jsonContext.deserialize(json, ContactOption.Chat.class);
                    }
                    return (ContactOption) jsonContext.deserialize(json, ContactOption.Voip.class);
                }
                return (ContactOption) jsonContext.deserialize(json, ContactOption.SimpleMessage.class);
            }
            return (ContactOption) jsonContext.deserialize(json, ContactOption.PhoneCall.class);
        }
        return (ContactOption) jsonContext.deserialize(json, ContactOption.PhoneCallSuport.class);
    }
}
