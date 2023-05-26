package com.google.crypto.tink;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import j$.util.concurrent.ConcurrentHashMap;
import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class Registry {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f14825a = Logger.getLogger(Registry.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final ConcurrentMap<String, KeyManagerContainer> f14826b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private static final ConcurrentMap<String, KeyDeriverContainer> f14827c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    private static final ConcurrentMap<String, Boolean> f14828d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    private static final ConcurrentMap<String, Object> f14829e = new ConcurrentHashMap();

    /* renamed from: f  reason: collision with root package name */
    private static final ConcurrentMap<Class<?>, PrimitiveWrapper<?, ?>> f14830f = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface KeyDeriverContainer {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface KeyManagerContainer {
        Class<?> a();

        Set<Class<?>> b();

        <P> KeyManager<P> c(Class<P> cls) throws GeneralSecurityException;

        KeyManager<?> d();
    }

    private Registry() {
    }

    private static <T> T a(T t7) {
        t7.getClass();
        return t7;
    }

    private static <KeyProtoT extends MessageLite> KeyManagerContainer b(final KeyTypeManager<KeyProtoT> keyTypeManager) {
        return new KeyManagerContainer() { // from class: com.google.crypto.tink.Registry.2
            @Override // com.google.crypto.tink.Registry.KeyManagerContainer
            public Class<?> a() {
                return KeyTypeManager.this.getClass();
            }

            @Override // com.google.crypto.tink.Registry.KeyManagerContainer
            public Set<Class<?>> b() {
                return KeyTypeManager.this.h();
            }

            @Override // com.google.crypto.tink.Registry.KeyManagerContainer
            public <Q> KeyManager<Q> c(Class<Q> cls) throws GeneralSecurityException {
                try {
                    return new KeyManagerImpl(KeyTypeManager.this, cls);
                } catch (IllegalArgumentException e8) {
                    throw new GeneralSecurityException("Primitive type not supported", e8);
                }
            }

            @Override // com.google.crypto.tink.Registry.KeyManagerContainer
            public KeyManager<?> d() {
                KeyTypeManager keyTypeManager2 = KeyTypeManager.this;
                return new KeyManagerImpl(keyTypeManager2, keyTypeManager2.a());
            }
        };
    }

    private static <KeyProtoT extends MessageLite> KeyDeriverContainer c(final KeyTypeManager<KeyProtoT> keyTypeManager) {
        return new KeyDeriverContainer() { // from class: com.google.crypto.tink.Registry.4
        };
    }

    private static synchronized void d(String str, Class<?> cls, boolean z7) throws GeneralSecurityException {
        synchronized (Registry.class) {
            ConcurrentMap<String, KeyManagerContainer> concurrentMap = f14826b;
            if (!concurrentMap.containsKey(str)) {
                return;
            }
            KeyManagerContainer keyManagerContainer = concurrentMap.get(str);
            if (keyManagerContainer.a().equals(cls)) {
                if (z7 && !f14828d.get(str).booleanValue()) {
                    throw new GeneralSecurityException("New keys are already disallowed for key type " + str);
                }
                return;
            }
            Logger logger = f14825a;
            logger.warning("Attempted overwrite of a registered key manager for key type " + str);
            throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", str, keyManagerContainer.a().getName(), cls.getName()));
        }
    }

    public static Class<?> e(Class<?> cls) {
        PrimitiveWrapper<?, ?> primitiveWrapper = f14830f.get(cls);
        if (primitiveWrapper == null) {
            return null;
        }
        return primitiveWrapper.b();
    }

    private static synchronized KeyManagerContainer f(String str) throws GeneralSecurityException {
        KeyManagerContainer keyManagerContainer;
        synchronized (Registry.class) {
            ConcurrentMap<String, KeyManagerContainer> concurrentMap = f14826b;
            if (concurrentMap.containsKey(str)) {
                keyManagerContainer = concurrentMap.get(str);
            } else {
                throw new GeneralSecurityException("No key manager found for key type " + str);
            }
        }
        return keyManagerContainer;
    }

    private static <P> KeyManager<P> g(String str, Class<P> cls) throws GeneralSecurityException {
        KeyManagerContainer f8 = f(str);
        if (cls == null) {
            return (KeyManager<P>) f8.d();
        }
        if (f8.b().contains(cls)) {
            return f8.c(cls);
        }
        throw new GeneralSecurityException("Primitive type " + cls.getName() + " not supported by key manager of type " + f8.a() + ", supported primitives: " + s(f8.b()));
    }

    public static <P> P h(String str, ByteString byteString, Class<P> cls) throws GeneralSecurityException {
        return (P) j(str, byteString, (Class) a(cls));
    }

    public static <P> P i(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return (P) h(str, ByteString.i(bArr), cls);
    }

    private static <P> P j(String str, ByteString byteString, Class<P> cls) throws GeneralSecurityException {
        return (P) g(str, cls).c(byteString);
    }

    public static <P> PrimitiveSet<P> k(KeysetHandle keysetHandle, KeyManager<P> keyManager, Class<P> cls) throws GeneralSecurityException {
        return m(keysetHandle, keyManager, (Class) a(cls));
    }

    public static <P> PrimitiveSet<P> l(KeysetHandle keysetHandle, Class<P> cls) throws GeneralSecurityException {
        return k(keysetHandle, null, cls);
    }

    private static <P> PrimitiveSet<P> m(KeysetHandle keysetHandle, KeyManager<P> keyManager, Class<P> cls) throws GeneralSecurityException {
        P p8;
        Util.d(keysetHandle.f());
        PrimitiveSet<P> f8 = PrimitiveSet.f(cls);
        for (Keyset.Key key : keysetHandle.f().M()) {
            if (key.N() == KeyStatusType.ENABLED) {
                if (keyManager != null && keyManager.a(key.K().L())) {
                    p8 = keyManager.c(key.K().M());
                } else {
                    p8 = (P) j(key.K().L(), key.K().M(), cls);
                }
                PrimitiveSet.Entry<P> a8 = f8.a(p8, key);
                if (key.L() == keysetHandle.f().N()) {
                    f8.g(a8);
                }
            }
        }
        return f8;
    }

    public static KeyManager<?> n(String str) throws GeneralSecurityException {
        return f(str).d();
    }

    public static synchronized MessageLite o(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        MessageLite d8;
        synchronized (Registry.class) {
            KeyManager<?> n8 = n(keyTemplate.L());
            if (f14828d.get(keyTemplate.L()).booleanValue()) {
                d8 = n8.d(keyTemplate.M());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.L());
            }
        }
        return d8;
    }

    public static synchronized KeyData p(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeyData b8;
        synchronized (Registry.class) {
            KeyManager<?> n8 = n(keyTemplate.L());
            if (f14828d.get(keyTemplate.L()).booleanValue()) {
                b8 = n8.b(keyTemplate.M());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.L());
            }
        }
        return b8;
    }

    public static synchronized <KeyProtoT extends MessageLite> void q(KeyTypeManager<KeyProtoT> keyTypeManager, boolean z7) throws GeneralSecurityException {
        synchronized (Registry.class) {
            if (keyTypeManager != null) {
                String c8 = keyTypeManager.c();
                d(c8, keyTypeManager.getClass(), z7);
                ConcurrentMap<String, KeyManagerContainer> concurrentMap = f14826b;
                if (!concurrentMap.containsKey(c8)) {
                    concurrentMap.put(c8, b(keyTypeManager));
                    f14827c.put(c8, c(keyTypeManager));
                }
                f14828d.put(c8, Boolean.valueOf(z7));
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }

    public static synchronized <B, P> void r(PrimitiveWrapper<B, P> primitiveWrapper) throws GeneralSecurityException {
        synchronized (Registry.class) {
            if (primitiveWrapper != null) {
                Class<P> c8 = primitiveWrapper.c();
                ConcurrentMap<Class<?>, PrimitiveWrapper<?, ?>> concurrentMap = f14830f;
                if (concurrentMap.containsKey(c8)) {
                    PrimitiveWrapper<?, ?> primitiveWrapper2 = concurrentMap.get(c8);
                    if (!primitiveWrapper.getClass().equals(primitiveWrapper2.getClass())) {
                        Logger logger = f14825a;
                        logger.warning("Attempted overwrite of a registered SetWrapper for type " + c8);
                        throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", c8.getName(), primitiveWrapper2.getClass().getName(), primitiveWrapper.getClass().getName()));
                    }
                }
                concurrentMap.put(c8, primitiveWrapper);
            } else {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
        }
    }

    private static String s(Set<Class<?>> set) {
        StringBuilder sb = new StringBuilder();
        boolean z7 = true;
        for (Class<?> cls : set) {
            if (!z7) {
                sb.append(", ");
            }
            sb.append(cls.getCanonicalName());
            z7 = false;
        }
        return sb.toString();
    }

    public static <B, P> P t(PrimitiveSet<B> primitiveSet, Class<P> cls) throws GeneralSecurityException {
        PrimitiveWrapper<?, ?> primitiveWrapper = f14830f.get(cls);
        if (primitiveWrapper != null) {
            if (primitiveWrapper.b().equals(primitiveSet.d())) {
                return (P) primitiveWrapper.a(primitiveSet);
            }
            throw new GeneralSecurityException("Wrong input primitive class, expected " + primitiveWrapper.b() + ", got " + primitiveSet.d());
        }
        throw new GeneralSecurityException("No wrapper found for " + primitiveSet.d().getName());
    }
}
