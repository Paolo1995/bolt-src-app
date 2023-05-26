package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class FieldDescriptor {

    /* renamed from: a  reason: collision with root package name */
    private final String f16203a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, Object> f16204b;

    /* loaded from: classes3.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final String f16205a;

        /* renamed from: b  reason: collision with root package name */
        private Map<Class<?>, Object> f16206b = null;

        Builder(String str) {
            this.f16205a = str;
        }

        @NonNull
        public FieldDescriptor a() {
            Map unmodifiableMap;
            String str = this.f16205a;
            if (this.f16206b == null) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(new HashMap(this.f16206b));
            }
            return new FieldDescriptor(str, unmodifiableMap);
        }

        @NonNull
        public <T extends Annotation> Builder b(@NonNull T t7) {
            if (this.f16206b == null) {
                this.f16206b = new HashMap();
            }
            this.f16206b.put(t7.annotationType(), t7);
            return this;
        }
    }

    @NonNull
    public static Builder a(@NonNull String str) {
        return new Builder(str);
    }

    @NonNull
    public static FieldDescriptor d(@NonNull String str) {
        return new FieldDescriptor(str, Collections.emptyMap());
    }

    @NonNull
    public String b() {
        return this.f16203a;
    }

    public <T extends Annotation> T c(@NonNull Class<T> cls) {
        return (T) this.f16204b.get(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldDescriptor)) {
            return false;
        }
        FieldDescriptor fieldDescriptor = (FieldDescriptor) obj;
        if (this.f16203a.equals(fieldDescriptor.f16203a) && this.f16204b.equals(fieldDescriptor.f16204b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f16203a.hashCode() * 31) + this.f16204b.hashCode();
    }

    @NonNull
    public String toString() {
        return "FieldDescriptor{name=" + this.f16203a + ", properties=" + this.f16204b.values() + "}";
    }

    private FieldDescriptor(String str, Map<Class<?>, Object> map) {
        this.f16203a = str;
        this.f16204b = map;
    }
}
