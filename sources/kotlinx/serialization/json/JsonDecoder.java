package kotlinx.serialization.json;

import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;

/* compiled from: JsonDecoder.kt */
/* loaded from: classes5.dex */
public interface JsonDecoder extends Decoder, CompositeDecoder {
    Json d();

    JsonElement g();
}
