package com.sinch.gson.internal;

import com.sinch.gson.JsonElement;
import com.sinch.gson.JsonIOException;
import com.sinch.gson.JsonNull;
import com.sinch.gson.JsonParseException;
import com.sinch.gson.JsonSyntaxException;
import com.sinch.gson.internal.bind.TypeAdapters;
import com.sinch.gson.stream.JsonReader;
import com.sinch.gson.stream.JsonWriter;
import com.sinch.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes3.dex */
public final class Streams {

    /* loaded from: classes3.dex */
    public static final class AppendableWriter extends Writer {
        private final Appendable appendable;
        private final CurrentWrite currentWrite = new CurrentWrite();

        /* loaded from: classes3.dex */
        public static class CurrentWrite implements CharSequence {
            public char[] chars;

            @Override // java.lang.CharSequence
            public char charAt(int i8) {
                return this.chars[i8];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.chars.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i8, int i9) {
                return new String(this.chars, i8, i9 - i8);
            }
        }

        public AppendableWriter(Appendable appendable) {
            this.appendable = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int i8) throws IOException {
            this.appendable.append((char) i8);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i8, int i9) throws IOException {
            CurrentWrite currentWrite = this.currentWrite;
            currentWrite.chars = cArr;
            this.appendable.append(currentWrite, i8, i9 + i8);
        }
    }

    private Streams() {
        throw new UnsupportedOperationException();
    }

    public static JsonElement parse(JsonReader jsonReader) throws JsonParseException {
        boolean z7;
        try {
            try {
                jsonReader.peek();
                z7 = false;
                try {
                    return TypeAdapters.JSON_ELEMENT.read(jsonReader);
                } catch (EOFException e8) {
                    e = e8;
                    if (z7) {
                        return JsonNull.INSTANCE;
                    }
                    throw new JsonSyntaxException(e);
                }
            } catch (MalformedJsonException e9) {
                throw new JsonSyntaxException(e9);
            } catch (IOException e10) {
                throw new JsonIOException(e10);
            } catch (NumberFormatException e11) {
                throw new JsonSyntaxException(e11);
            }
        } catch (EOFException e12) {
            e = e12;
            z7 = true;
        }
    }

    public static void write(JsonElement jsonElement, JsonWriter jsonWriter) throws IOException {
        TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonElement);
    }

    public static Writer writerForAppendable(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new AppendableWriter(appendable);
    }
}
