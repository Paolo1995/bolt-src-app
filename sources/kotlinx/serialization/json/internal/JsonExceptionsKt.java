package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: JsonExceptions.kt */
/* loaded from: classes5.dex */
public final class JsonExceptionsKt {
    public static final JsonDecodingException a(Number value, String key, String output) {
        Intrinsics.f(value, "value");
        Intrinsics.f(key, "key");
        Intrinsics.f(output, "output");
        return d(-1, j(value, key, output));
    }

    public static final JsonEncodingException b(Number value, String output) {
        Intrinsics.f(value, "value");
        Intrinsics.f(output, "output");
        return new JsonEncodingException("Unexpected special floating-point value " + value + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) h(output, 0, 1, null)));
    }

    public static final JsonEncodingException c(SerialDescriptor keyDescriptor) {
        Intrinsics.f(keyDescriptor, "keyDescriptor");
        return new JsonEncodingException("Value of type '" + keyDescriptor.i() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + keyDescriptor.d() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    public static final JsonDecodingException d(int i8, String message) {
        Intrinsics.f(message, "message");
        if (i8 >= 0) {
            message = "Unexpected JSON token at offset " + i8 + ": " + message;
        }
        return new JsonDecodingException(message);
    }

    public static final JsonDecodingException e(int i8, String message, CharSequence input) {
        Intrinsics.f(message, "message");
        Intrinsics.f(input, "input");
        return d(i8, message + "\nJSON input: " + ((Object) g(input, i8)));
    }

    public static final JsonDecodingException f(String key, String input) {
        Intrinsics.f(key, "key");
        Intrinsics.f(input, "input");
        return d(-1, "Encountered unknown key '" + key + "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: " + ((Object) h(input, 0, 1, null)));
    }

    private static final CharSequence g(CharSequence charSequence, int i8) {
        String str;
        int d8;
        int g8;
        int length;
        if (charSequence.length() < 200) {
            return charSequence;
        }
        String str2 = ".....";
        if (i8 == -1) {
            if (charSequence.length() - 60 <= 0) {
                return charSequence;
            }
            return "....." + charSequence.subSequence(length, charSequence.length()).toString();
        }
        int i9 = i8 - 30;
        int i10 = i8 + 30;
        if (i9 > 0) {
            str = ".....";
        } else {
            str = "";
        }
        if (i10 >= charSequence.length()) {
            str2 = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        d8 = RangesKt___RangesKt.d(i9, 0);
        g8 = RangesKt___RangesKt.g(i10, charSequence.length());
        sb.append(charSequence.subSequence(d8, g8).toString());
        sb.append(str2);
        return sb.toString();
    }

    static /* synthetic */ CharSequence h(CharSequence charSequence, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = -1;
        }
        return g(charSequence, i8);
    }

    public static final Void i(AbstractJsonLexer abstractJsonLexer, Number result) {
        Intrinsics.f(abstractJsonLexer, "<this>");
        Intrinsics.f(result, "result");
        AbstractJsonLexer.y(abstractJsonLexer, "Unexpected special floating-point value " + result + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2, null);
        throw new KotlinNothingValueException();
    }

    private static final String j(Number number, String str, String str2) {
        return "Unexpected special floating-point value " + number + " with key " + str + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) h(str2, 0, 1, null));
    }
}
