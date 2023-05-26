package com.sinch.gson;

import com.sinch.gson.internal.bind.JsonTreeReader;
import com.sinch.gson.internal.bind.JsonTreeWriter;
import com.sinch.gson.stream.JsonReader;
import com.sinch.gson.stream.JsonToken;
import com.sinch.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* loaded from: classes3.dex */
public abstract class TypeAdapter<T> {
    public final T fromJson(Reader reader) throws IOException {
        return read(new JsonReader(reader));
    }

    public final T fromJson(String str) throws IOException {
        return fromJson(new StringReader(str));
    }

    public final T fromJsonTree(JsonElement jsonElement) {
        try {
            return read(new JsonTreeReader(jsonElement));
        } catch (IOException e8) {
            throw new JsonIOException(e8);
        }
    }

    public final TypeAdapter<T> nullSafe() {
        return new TypeAdapter<T>() { // from class: com.sinch.gson.TypeAdapter.1
            @Override // com.sinch.gson.TypeAdapter
            public T read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return (T) TypeAdapter.this.read(jsonReader);
            }

            @Override // com.sinch.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, T t7) throws IOException {
                if (t7 == null) {
                    jsonWriter.nullValue();
                } else {
                    TypeAdapter.this.write(jsonWriter, t7);
                }
            }
        };
    }

    public abstract T read(JsonReader jsonReader) throws IOException;

    public final String toJson(T t7) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t7);
            return stringWriter.toString();
        } catch (IOException e8) {
            throw new AssertionError(e8);
        }
    }

    public final void toJson(Writer writer, T t7) throws IOException {
        write(new JsonWriter(writer), t7);
    }

    public final JsonElement toJsonTree(T t7) {
        try {
            JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
            write(jsonTreeWriter, t7);
            return jsonTreeWriter.get();
        } catch (IOException e8) {
            throw new JsonIOException(e8);
        }
    }

    public abstract void write(JsonWriter jsonWriter, T t7) throws IOException;
}
