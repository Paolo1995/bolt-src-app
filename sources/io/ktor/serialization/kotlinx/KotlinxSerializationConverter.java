package io.ktor.serialization.kotlinx;

import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.content.ByteArrayContent;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.serialization.ContentConverter;
import io.ktor.util.reflect.TypeInfo;
import java.nio.charset.Charset;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialFormat;
import kotlinx.serialization.StringFormat;

/* compiled from: KotlinxSerializationConverter.kt */
/* loaded from: classes5.dex */
public final class KotlinxSerializationConverter implements ContentConverter {

    /* renamed from: a  reason: collision with root package name */
    private final SerialFormat f46976a;

    /* renamed from: b  reason: collision with root package name */
    private final KotlinxSerializationConverter$serializationBase$1 f46977b;

    /* JADX WARN: Type inference failed for: r0v6, types: [io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializationBase$1] */
    public KotlinxSerializationConverter(final SerialFormat format) {
        boolean z7;
        Intrinsics.f(format, "format");
        this.f46976a = format;
        if (!(format instanceof BinaryFormat) && !(format instanceof StringFormat)) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            this.f46977b = new KotlinxSerializationBase<OutgoingContent.ByteArrayContent>(format) { // from class: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializationBase$1
                @Override // io.ktor.serialization.kotlinx.KotlinxSerializationBase
                public Object b(SerializationParameters serializationParameters, Continuation<? super OutgoingContent.ByteArrayContent> continuation) {
                    OutgoingContent.ByteArrayContent d8;
                    if (serializationParameters instanceof SerializationNegotiationParameters) {
                        d8 = KotlinxSerializationConverter.this.d(serializationParameters.c(), serializationParameters.b(), serializationParameters.e(), ((SerializationNegotiationParameters) serializationParameters).g(), serializationParameters.a());
                        return d8;
                    }
                    throw new IllegalStateException(("parameters type is " + Reflection.b(serializationParameters.getClass()).d() + ", but expected " + Reflection.b(SerializationNegotiationParameters.class).d()).toString());
                }
            };
            return;
        }
        throw new IllegalArgumentException(("Only binary and string formats are supported, " + format + " is not supported.").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OutgoingContent.ByteArrayContent d(KSerializer<?> kSerializer, SerialFormat serialFormat, Object obj, ContentType contentType, Charset charset) {
        if (serialFormat instanceof StringFormat) {
            return new TextContent(((StringFormat) serialFormat).d(kSerializer, obj), ContentTypesKt.c(contentType, charset), null, 4, null);
        }
        if (serialFormat instanceof BinaryFormat) {
            return new ByteArrayContent(((BinaryFormat) serialFormat).c(kSerializer, obj), contentType, null, 4, null);
        }
        throw new IllegalStateException(("Unsupported format " + serialFormat).toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d A[Catch: all -> 0x00a8, TryCatch #0 {all -> 0x00a8, blocks: (B:19:0x0065, B:21:0x006d, B:22:0x0079, B:24:0x007d, B:26:0x0088, B:27:0x00a7), top: B:31:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0079 A[Catch: all -> 0x00a8, TryCatch #0 {all -> 0x00a8, blocks: (B:19:0x0065, B:21:0x006d, B:22:0x0079, B:24:0x007d, B:26:0x0088, B:27:0x00a7), top: B:31:0x0065 }] */
    @Override // io.ktor.serialization.ContentConverter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(java.nio.charset.Charset r10, io.ktor.util.reflect.TypeInfo r11, io.ktor.utils.io.ByteReadChannel r12, kotlin.coroutines.Continuation<java.lang.Object> r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof io.ktor.serialization.kotlinx.KotlinxSerializationConverter$deserialize$1
            if (r0 == 0) goto L13
            r0 = r13
            io.ktor.serialization.kotlinx.KotlinxSerializationConverter$deserialize$1 r0 = (io.ktor.serialization.kotlinx.KotlinxSerializationConverter$deserialize$1) r0
            int r1 = r0.f46983k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f46983k = r1
            goto L18
        L13:
            io.ktor.serialization.kotlinx.KotlinxSerializationConverter$deserialize$1 r0 = new io.ktor.serialization.kotlinx.KotlinxSerializationConverter$deserialize$1
            r0.<init>(r9, r13)
        L18:
            r4 = r0
            java.lang.Object r13 = r4.f46981i
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r1 = r4.f46983k
            r7 = 1
            if (r1 == 0) goto L3e
            if (r1 != r7) goto L36
            java.lang.Object r10 = r4.f46980h
            kotlinx.serialization.KSerializer r10 = (kotlinx.serialization.KSerializer) r10
            java.lang.Object r11 = r4.f46979g
            java.nio.charset.Charset r11 = (java.nio.charset.Charset) r11
            java.lang.Object r12 = r4.f46978f
            io.ktor.serialization.kotlinx.KotlinxSerializationConverter r12 = (io.ktor.serialization.kotlinx.KotlinxSerializationConverter) r12
            kotlin.ResultKt.b(r13)
            goto L63
        L36:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3e:
            kotlin.ResultKt.b(r13)
            kotlinx.serialization.SerialFormat r13 = r9.f46976a
            kotlinx.serialization.modules.SerializersModule r13 = r13.a()
            kotlinx.serialization.KSerializer r11 = io.ktor.serialization.kotlinx.SerializerLookupKt.d(r11, r13)
            r2 = 0
            r5 = 1
            r6 = 0
            r4.f46978f = r9
            r4.f46979g = r10
            r4.f46980h = r11
            r4.f46983k = r7
            r1 = r12
            java.lang.Object r13 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.a(r1, r2, r4, r5, r6)
            if (r13 != r0) goto L5f
            return r0
        L5f:
            r12 = r9
            r8 = r11
            r11 = r10
            r10 = r8
        L63:
            io.ktor.utils.io.core.ByteReadPacket r13 = (io.ktor.utils.io.core.ByteReadPacket) r13
            kotlinx.serialization.SerialFormat r0 = r12.f46976a     // Catch: java.lang.Throwable -> La8
            boolean r1 = r0 instanceof kotlinx.serialization.StringFormat     // Catch: java.lang.Throwable -> La8
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L79
            kotlinx.serialization.StringFormat r0 = (kotlinx.serialization.StringFormat) r0     // Catch: java.lang.Throwable -> La8
            r12 = 2
            java.lang.String r11 = io.ktor.utils.io.core.StringsKt.e(r13, r11, r3, r12, r2)     // Catch: java.lang.Throwable -> La8
            java.lang.Object r10 = r0.b(r10, r11)     // Catch: java.lang.Throwable -> La8
            goto L87
        L79:
            boolean r11 = r0 instanceof kotlinx.serialization.BinaryFormat     // Catch: java.lang.Throwable -> La8
            if (r11 == 0) goto L88
            kotlinx.serialization.BinaryFormat r0 = (kotlinx.serialization.BinaryFormat) r0     // Catch: java.lang.Throwable -> La8
            byte[] r11 = io.ktor.utils.io.core.StringsKt.c(r13, r3, r7, r2)     // Catch: java.lang.Throwable -> La8
            java.lang.Object r10 = r0.e(r10, r11)     // Catch: java.lang.Throwable -> La8
        L87:
            return r10
        L88:
            io.ktor.utils.io.core.InputKt.a(r13)     // Catch: java.lang.Throwable -> La8
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La8
            r10.<init>()     // Catch: java.lang.Throwable -> La8
            java.lang.String r11 = "Unsupported format "
            r10.append(r11)     // Catch: java.lang.Throwable -> La8
            kotlinx.serialization.SerialFormat r11 = r12.f46976a     // Catch: java.lang.Throwable -> La8
            r10.append(r11)     // Catch: java.lang.Throwable -> La8
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> La8
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> La8
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> La8
            r11.<init>(r10)     // Catch: java.lang.Throwable -> La8
            throw r11     // Catch: java.lang.Throwable -> La8
        La8:
            r10 = move-exception
            io.ktor.serialization.JsonConvertException r11 = new io.ktor.serialization.JsonConvertException
            java.lang.String r12 = "Illegal input"
            r11.<init>(r12, r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.serialization.kotlinx.KotlinxSerializationConverter.a(java.nio.charset.Charset, io.ktor.util.reflect.TypeInfo, io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.serialization.ContentConverter
    public Object b(ContentType contentType, Charset charset, TypeInfo typeInfo, Object obj, Continuation<? super OutgoingContent> continuation) {
        return a(new SerializationNegotiationParameters(this.f46976a, obj, typeInfo, charset, contentType), continuation);
    }
}
