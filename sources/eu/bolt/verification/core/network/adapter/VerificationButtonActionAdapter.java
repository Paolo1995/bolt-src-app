package eu.bolt.verification.core.network.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import eu.bolt.verification.sdk.internal.sm;
import java.lang.reflect.Type;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class VerificationButtonActionAdapter implements JsonDeserializer<sm> {

    /* renamed from: a  reason: collision with root package name */
    private static final a f41911a = new a(null);

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public sm deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) {
        String asString;
        Type type2;
        Intrinsics.f(context, "context");
        JsonObject asJsonObject = jsonElement != null ? jsonElement.getAsJsonObject() : null;
        if (asJsonObject == null || (asString = asJsonObject.get("type").getAsString()) == null) {
            return null;
        }
        switch (asString.hashCode()) {
            case -2061966677:
                if (asString.equals("close_form")) {
                    type2 = sm.a.class;
                    break;
                } else {
                    return null;
                }
            case -1803020853:
                if (asString.equals("go_to_next_step")) {
                    type2 = sm.c.class;
                    break;
                } else {
                    return null;
                }
            case -1596605669:
                if (asString.equals("submit_user_data_and_close_form")) {
                    type2 = sm.i.class;
                    break;
                } else {
                    return null;
                }
            case -1536227339:
                if (asString.equals("upload_multifrom_request")) {
                    type2 = sm.l.class;
                    break;
                } else {
                    return null;
                }
            case -1420193210:
                if (asString.equals("support_web_app")) {
                    type2 = sm.j.class;
                    break;
                } else {
                    return null;
                }
            case -982294473:
                if (asString.equals("submit_user_data")) {
                    type2 = sm.h.class;
                    break;
                } else {
                    return null;
                }
            case 192184798:
                if (asString.equals("go_back")) {
                    type2 = sm.b.class;
                    break;
                } else {
                    return null;
                }
            case 431874012:
                if (asString.equals("try_again")) {
                    type2 = sm.k.class;
                    break;
                } else {
                    return null;
                }
            case 992323911:
                if (asString.equals("send_post_request")) {
                    type2 = sm.f.class;
                    break;
                } else {
                    return null;
                }
            case 1203051040:
                if (asString.equals("open_bottom_sheet")) {
                    type2 = sm.d.class;
                    break;
                } else {
                    return null;
                }
            case 1491376901:
                if (asString.equals("open_web_view")) {
                    type2 = sm.e.class;
                    break;
                } else {
                    return null;
                }
            case 1685513244:
                if (asString.equals("submit_predefined_data")) {
                    type2 = sm.g.class;
                    break;
                } else {
                    return null;
                }
            default:
                return null;
        }
        return (sm) context.deserialize(asJsonObject, type2);
    }
}
