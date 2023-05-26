package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public final class JsonStreamParser implements Iterator<JsonElement>, j$.util.Iterator {
    private final Object lock;
    private final JsonReader parser;

    public JsonStreamParser(String str) {
        this(new StringReader(str));
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // java.util.Iterator
    public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super JsonElement> consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public boolean hasNext() {
        boolean z7;
        synchronized (this.lock) {
            try {
                try {
                    try {
                        if (this.parser.peek() != JsonToken.END_DOCUMENT) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                    } catch (MalformedJsonException e8) {
                        throw new JsonSyntaxException(e8);
                    }
                } catch (IOException e9) {
                    throw new JsonIOException(e9);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z7;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public JsonStreamParser(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        this.parser = jsonReader;
        jsonReader.setLenient(true);
        this.lock = new Object();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public JsonElement next() throws JsonParseException {
        if (hasNext()) {
            try {
                return Streams.parse(this.parser);
            } catch (JsonParseException e8) {
                if (e8.getCause() instanceof EOFException) {
                    throw new NoSuchElementException();
                }
                throw e8;
            } catch (OutOfMemoryError e9) {
                throw new JsonParseException("Failed parsing JSON source to Json", e9);
            } catch (StackOverflowError e10) {
                throw new JsonParseException("Failed parsing JSON source to Json", e10);
            }
        }
        throw new NoSuchElementException();
    }
}
