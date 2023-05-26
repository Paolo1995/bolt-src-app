package com.sinch.gson;

import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public interface JsonSerializer<T> {
    JsonElement serialize(T t7, Type type, JsonSerializationContext jsonSerializationContext);
}
