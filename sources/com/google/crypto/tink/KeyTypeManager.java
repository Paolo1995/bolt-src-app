package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class KeyTypeManager<KeyProtoT extends MessageLite> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<KeyProtoT> f14808a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, PrimitiveFactory<?, KeyProtoT>> f14809b;

    /* renamed from: c  reason: collision with root package name */
    private final Class<?> f14810c;

    /* loaded from: classes.dex */
    public static abstract class KeyFactory<KeyFormatProtoT extends MessageLite, KeyT> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<KeyFormatProtoT> f14811a;

        public KeyFactory(Class<KeyFormatProtoT> cls) {
            this.f14811a = cls;
        }

        public abstract KeyT a(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;

        public final Class<KeyFormatProtoT> b() {
            return this.f14811a;
        }

        public abstract KeyFormatProtoT c(ByteString byteString) throws InvalidProtocolBufferException;

        public abstract void d(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static abstract class PrimitiveFactory<PrimitiveT, KeyT> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<PrimitiveT> f14812a;

        public PrimitiveFactory(Class<PrimitiveT> cls) {
            this.f14812a = cls;
        }

        public abstract PrimitiveT a(KeyT keyt) throws GeneralSecurityException;

        final Class<PrimitiveT> b() {
            return this.f14812a;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SafeVarargs
    public KeyTypeManager(Class<KeyProtoT> cls, PrimitiveFactory<?, KeyProtoT>... primitiveFactoryArr) {
        this.f14808a = cls;
        HashMap hashMap = new HashMap();
        for (PrimitiveFactory<?, KeyProtoT> primitiveFactory : primitiveFactoryArr) {
            if (!hashMap.containsKey(primitiveFactory.b())) {
                hashMap.put(primitiveFactory.b(), primitiveFactory);
            } else {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + primitiveFactory.b().getCanonicalName());
            }
        }
        if (primitiveFactoryArr.length > 0) {
            this.f14810c = primitiveFactoryArr[0].b();
        } else {
            this.f14810c = Void.class;
        }
        this.f14809b = Collections.unmodifiableMap(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Class<?> a() {
        return this.f14810c;
    }

    public final Class<KeyProtoT> b() {
        return this.f14808a;
    }

    public abstract String c();

    public final <P> P d(KeyProtoT keyprotot, Class<P> cls) throws GeneralSecurityException {
        PrimitiveFactory<?, KeyProtoT> primitiveFactory = this.f14809b.get(cls);
        if (primitiveFactory != null) {
            return (P) primitiveFactory.a(keyprotot);
        }
        throw new IllegalArgumentException("Requested primitive class " + cls.getCanonicalName() + " not supported.");
    }

    public abstract KeyFactory<?, KeyProtoT> e();

    public abstract KeyData.KeyMaterialType f();

    public abstract KeyProtoT g(ByteString byteString) throws InvalidProtocolBufferException;

    public final Set<Class<?>> h() {
        return this.f14809b.keySet();
    }

    public abstract void i(KeyProtoT keyprotot) throws GeneralSecurityException;
}
