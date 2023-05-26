package com.sinch.gson;

/* loaded from: classes3.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.sinch.gson.LongSerializationPolicy.1
        @Override // com.sinch.gson.LongSerializationPolicy
        public JsonElement serialize(Long l8) {
            return new JsonPrimitive((Number) l8);
        }
    },
    STRING { // from class: com.sinch.gson.LongSerializationPolicy.2
        @Override // com.sinch.gson.LongSerializationPolicy
        public JsonElement serialize(Long l8) {
            return new JsonPrimitive(String.valueOf(l8));
        }
    };

    public abstract JsonElement serialize(Long l8);
}
