package eu.bolt.driver.earnings.network;

import android.graphics.Color;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HexColorStringDeserializer.kt */
/* loaded from: classes5.dex */
public final class HexColorStringDeserializer implements JsonDeserializer<Integer> {
    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a */
    public Integer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        Intrinsics.f(json, "json");
        Intrinsics.f(typeOfT, "typeOfT");
        Intrinsics.f(context, "context");
        return Integer.valueOf(Color.parseColor(json.getAsString()));
    }
}
