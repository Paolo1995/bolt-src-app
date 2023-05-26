package com.google.crypto.tink;

import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public class KeyManagerImpl<PrimitiveT, KeyProtoT extends MessageLite> implements KeyManager<PrimitiveT> {

    /* renamed from: a  reason: collision with root package name */
    private final KeyTypeManager<KeyProtoT> f14797a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<PrimitiveT> f14798b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class KeyFactoryHelper<KeyFormatProtoT extends MessageLite, KeyProtoT extends MessageLite> {

        /* renamed from: a  reason: collision with root package name */
        final KeyTypeManager.KeyFactory<KeyFormatProtoT, KeyProtoT> f14799a;

        KeyFactoryHelper(KeyTypeManager.KeyFactory<KeyFormatProtoT, KeyProtoT> keyFactory) {
            this.f14799a = keyFactory;
        }

        private KeyProtoT b(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException {
            this.f14799a.d(keyformatprotot);
            return this.f14799a.a(keyformatprotot);
        }

        KeyProtoT a(ByteString byteString) throws GeneralSecurityException, InvalidProtocolBufferException {
            return b(this.f14799a.c(byteString));
        }
    }

    public KeyManagerImpl(KeyTypeManager<KeyProtoT> keyTypeManager, Class<PrimitiveT> cls) {
        if (!keyTypeManager.h().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", keyTypeManager.toString(), cls.getName()));
        }
        this.f14797a = keyTypeManager;
        this.f14798b = cls;
    }

    private KeyFactoryHelper<?, KeyProtoT> f() {
        return new KeyFactoryHelper<>(this.f14797a.e());
    }

    private PrimitiveT g(KeyProtoT keyprotot) throws GeneralSecurityException {
        if (!Void.class.equals(this.f14798b)) {
            this.f14797a.i(keyprotot);
            return (PrimitiveT) this.f14797a.d(keyprotot, (Class<PrimitiveT>) this.f14798b);
        }
        throw new GeneralSecurityException("Cannot create a primitive for Void");
    }

    @Override // com.google.crypto.tink.KeyManager
    public final boolean a(String str) {
        return str.equals(e());
    }

    @Override // com.google.crypto.tink.KeyManager
    public final KeyData b(ByteString byteString) throws GeneralSecurityException {
        try {
            return KeyData.N().r(e()).s(f().a(byteString).toByteString()).q(this.f14797a.f()).build();
        } catch (InvalidProtocolBufferException e8) {
            throw new GeneralSecurityException("Unexpected proto", e8);
        }
    }

    @Override // com.google.crypto.tink.KeyManager
    public final PrimitiveT c(ByteString byteString) throws GeneralSecurityException {
        try {
            return g(this.f14797a.g(byteString));
        } catch (InvalidProtocolBufferException e8) {
            throw new GeneralSecurityException("Failures parsing proto of type " + this.f14797a.b().getName(), e8);
        }
    }

    @Override // com.google.crypto.tink.KeyManager
    public final MessageLite d(ByteString byteString) throws GeneralSecurityException {
        try {
            return f().a(byteString);
        } catch (InvalidProtocolBufferException e8) {
            throw new GeneralSecurityException("Failures parsing proto of type " + this.f14797a.e().b().getName(), e8);
        }
    }

    public final String e() {
        return this.f14797a.c();
    }
}
