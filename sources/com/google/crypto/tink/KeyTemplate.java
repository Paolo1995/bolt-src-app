package com.google.crypto.tink;

import com.google.crypto.tink.shaded.protobuf.ByteString;

/* loaded from: classes.dex */
public final class KeyTemplate {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.crypto.tink.proto.KeyTemplate f14800a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.crypto.tink.KeyTemplate$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14801a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f14802b;

        static {
            int[] iArr = new int[OutputPrefixType.values().length];
            f14802b = iArr;
            try {
                iArr[OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14802b[OutputPrefixType.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14802b[OutputPrefixType.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14802b[OutputPrefixType.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[com.google.crypto.tink.proto.OutputPrefixType.values().length];
            f14801a = iArr2;
            try {
                iArr2[com.google.crypto.tink.proto.OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14801a[com.google.crypto.tink.proto.OutputPrefixType.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14801a[com.google.crypto.tink.proto.OutputPrefixType.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f14801a[com.google.crypto.tink.proto.OutputPrefixType.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum OutputPrefixType {
        TINK,
        LEGACY,
        RAW,
        CRUNCHY
    }

    private KeyTemplate(com.google.crypto.tink.proto.KeyTemplate keyTemplate) {
        this.f14800a = keyTemplate;
    }

    public static KeyTemplate a(String str, byte[] bArr, OutputPrefixType outputPrefixType) {
        return new KeyTemplate(com.google.crypto.tink.proto.KeyTemplate.N().r(str).s(ByteString.i(bArr)).q(c(outputPrefixType)).build());
    }

    private static com.google.crypto.tink.proto.OutputPrefixType c(OutputPrefixType outputPrefixType) {
        int i8 = AnonymousClass1.f14802b[outputPrefixType.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4) {
                        return com.google.crypto.tink.proto.OutputPrefixType.CRUNCHY;
                    }
                    throw new IllegalArgumentException("Unknown output prefix type");
                }
                return com.google.crypto.tink.proto.OutputPrefixType.RAW;
            }
            return com.google.crypto.tink.proto.OutputPrefixType.LEGACY;
        }
        return com.google.crypto.tink.proto.OutputPrefixType.TINK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.crypto.tink.proto.KeyTemplate b() {
        return this.f14800a;
    }
}
