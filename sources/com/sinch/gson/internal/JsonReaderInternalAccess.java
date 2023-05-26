package com.sinch.gson.internal;

import com.sinch.gson.stream.JsonReader;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class JsonReaderInternalAccess {
    public static JsonReaderInternalAccess INSTANCE;

    public abstract void promoteNameToValue(JsonReader jsonReader) throws IOException;
}
