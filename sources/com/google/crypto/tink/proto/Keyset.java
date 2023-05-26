package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class Keyset extends GeneratedMessageLite<Keyset, Builder> implements MessageLiteOrBuilder {
    private static final Keyset DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile Parser<Keyset> PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private Internal.ProtobufList<Key> key_ = GeneratedMessageLite.o();
    private int primaryKeyId_;

    /* renamed from: com.google.crypto.tink.proto.Keyset$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14952a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f14952a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14952a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14952a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14952a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14952a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14952a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14952a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Keyset, Builder> implements MessageLiteOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder q(Key key) {
            k();
            ((Keyset) this.f15094g).H(key);
            return this;
        }

        public Key r(int i8) {
            return ((Keyset) this.f15094g).K(i8);
        }

        public int s() {
            return ((Keyset) this.f15094g).L();
        }

        public List<Key> t() {
            return Collections.unmodifiableList(((Keyset) this.f15094g).M());
        }

        public Builder u(int i8) {
            k();
            ((Keyset) this.f15094g).Q(i8);
            return this;
        }

        private Builder() {
            super(Keyset.DEFAULT_INSTANCE);
        }
    }

    /* loaded from: classes.dex */
    public static final class Key extends GeneratedMessageLite<Key, Builder> implements MessageLiteOrBuilder {
        private static final Key DEFAULT_INSTANCE;
        public static final int KEY_DATA_FIELD_NUMBER = 1;
        public static final int KEY_ID_FIELD_NUMBER = 3;
        public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
        private static volatile Parser<Key> PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 2;
        private KeyData keyData_;
        private int keyId_;
        private int outputPrefixType_;
        private int status_;

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Key, Builder> implements MessageLiteOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder q(KeyData keyData) {
                k();
                ((Key) this.f15094g).Q(keyData);
                return this;
            }

            public Builder r(int i8) {
                k();
                ((Key) this.f15094g).R(i8);
                return this;
            }

            public Builder s(OutputPrefixType outputPrefixType) {
                k();
                ((Key) this.f15094g).S(outputPrefixType);
                return this;
            }

            public Builder t(KeyStatusType keyStatusType) {
                k();
                ((Key) this.f15094g).T(keyStatusType);
                return this;
            }

            private Builder() {
                super(Key.DEFAULT_INSTANCE);
            }
        }

        static {
            Key key = new Key();
            DEFAULT_INSTANCE = key;
            GeneratedMessageLite.C(Key.class, key);
        }

        private Key() {
        }

        public static Builder P() {
            return DEFAULT_INSTANCE.k();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q(KeyData keyData) {
            keyData.getClass();
            this.keyData_ = keyData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R(int i8) {
            this.keyId_ = i8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S(OutputPrefixType outputPrefixType) {
            this.outputPrefixType_ = outputPrefixType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T(KeyStatusType keyStatusType) {
            this.status_ = keyStatusType.getNumber();
        }

        public KeyData K() {
            KeyData keyData = this.keyData_;
            if (keyData == null) {
                return KeyData.J();
            }
            return keyData;
        }

        public int L() {
            return this.keyId_;
        }

        public OutputPrefixType M() {
            OutputPrefixType a8 = OutputPrefixType.a(this.outputPrefixType_);
            if (a8 == null) {
                return OutputPrefixType.UNRECOGNIZED;
            }
            return a8;
        }

        public KeyStatusType N() {
            KeyStatusType a8 = KeyStatusType.a(this.status_);
            if (a8 == null) {
                return KeyStatusType.UNRECOGNIZED;
            }
            return a8;
        }

        public boolean O() {
            if (this.keyData_ != null) {
                return true;
            }
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
        protected final Object n(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f14952a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Key();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.w(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"keyData_", "status_", "keyId_", "outputPrefixType_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Key> parser = PARSER;
                    if (parser == null) {
                        synchronized (Key.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    static {
        Keyset keyset = new Keyset();
        DEFAULT_INSTANCE = keyset;
        GeneratedMessageLite.C(Keyset.class, keyset);
    }

    private Keyset() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(Key key) {
        key.getClass();
        J();
        this.key_.add(key);
    }

    private void J() {
        if (!this.key_.h()) {
            this.key_ = GeneratedMessageLite.u(this.key_);
        }
    }

    public static Builder O() {
        return DEFAULT_INSTANCE.k();
    }

    public static Keyset P(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Keyset) GeneratedMessageLite.y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i8) {
        this.primaryKeyId_ = i8;
    }

    public Key K(int i8) {
        return this.key_.get(i8);
    }

    public int L() {
        return this.key_.size();
    }

    public List<Key> M() {
        return this.key_;
    }

    public int N() {
        return this.primaryKeyId_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object n(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f14952a[methodToInvoke.ordinal()]) {
            case 1:
                return new Keyset();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.w(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "key_", Key.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Keyset> parser = PARSER;
                if (parser == null) {
                    synchronized (Keyset.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
