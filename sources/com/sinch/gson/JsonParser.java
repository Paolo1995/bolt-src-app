package com.sinch.gson;

import com.sinch.gson.internal.Streams;
import com.sinch.gson.stream.JsonReader;
import com.sinch.gson.stream.JsonToken;
import com.sinch.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* loaded from: classes3.dex */
public final class JsonParser {
    public JsonElement parse(JsonReader jsonReader) throws JsonIOException, JsonSyntaxException {
        boolean isLenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            try {
                return Streams.parse(jsonReader);
            } catch (OutOfMemoryError e8) {
                throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e8);
            } catch (StackOverflowError e9) {
                throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e9);
            }
        } finally {
            jsonReader.setLenient(isLenient);
        }
    }

    public JsonElement parse(Reader reader) throws JsonIOException, JsonSyntaxException {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            JsonElement parse = parse(jsonReader);
            if (!parse.isJsonNull() && jsonReader.peek() != JsonToken.END_DOCUMENT) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
            return parse;
        } catch (MalformedJsonException e8) {
            throw new JsonSyntaxException(e8);
        } catch (IOException e9) {
            throw new JsonIOException(e9);
        } catch (NumberFormatException e10) {
            throw new JsonSyntaxException(e10);
        }
    }

    public JsonElement parse(String str) throws JsonSyntaxException {
        return parse(new StringReader(str));
    }
}
