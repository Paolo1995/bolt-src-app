package eu.bolt.client.network.model.common;

import android.graphics.Color;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.annotations.JsonAdapter;
import eu.bolt.verification.sdk.internal.a2;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

@JsonAdapter(NetworkColorDeserializer.class)
/* loaded from: classes5.dex */
public final class RGBAColorResponse {

    /* renamed from: a  reason: collision with root package name */
    private final int f40267a;

    /* loaded from: classes5.dex */
    public static final class NetworkColorDeserializer implements JsonDeserializer<RGBAColorResponse>, JsonSerializer<RGBAColorResponse> {
        private final String c(String str) {
            if (str.length() == 1) {
                return "0" + str;
            }
            return str;
        }

        @Override // com.google.gson.JsonSerializer
        /* renamed from: a */
        public JsonElement serialize(RGBAColorResponse rGBAColorResponse, Type type, JsonSerializationContext jsonSerializationContext) {
            if (rGBAColorResponse == null) {
                JsonNull INSTANCE = JsonNull.INSTANCE;
                Intrinsics.e(INSTANCE, "INSTANCE");
                return INSTANCE;
            }
            String c8 = c(Util.toHexString(Color.alpha(rGBAColorResponse.a())));
            String c9 = c(Util.toHexString(Color.red(rGBAColorResponse.a())));
            String c10 = c(Util.toHexString(Color.green(rGBAColorResponse.a())));
            String c11 = c(Util.toHexString(Color.blue(rGBAColorResponse.a())));
            return new JsonPrimitive("#" + c9 + c10 + c11 + c8);
        }

        @Override // com.google.gson.JsonDeserializer
        /* renamed from: b */
        public RGBAColorResponse deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            Integer a8 = a2.a(a2.f41941a, jsonElement != null ? jsonElement.getAsString() : null, 0, 2, null);
            if (a8 != null) {
                return new RGBAColorResponse(a8.intValue());
            }
            return null;
        }
    }

    public RGBAColorResponse(int i8) {
        this.f40267a = i8;
    }

    public final int a() {
        return this.f40267a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RGBAColorResponse) && this.f40267a == ((RGBAColorResponse) obj).f40267a;
    }

    public int hashCode() {
        return this.f40267a;
    }

    public String toString() {
        int i8 = this.f40267a;
        return "RGBAColorResponse(color=" + i8 + ")";
    }
}
