package io.ktor.websocket;

import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.StringsKt;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DisposableHandle;

/* compiled from: Frame.kt */
/* loaded from: classes5.dex */
public abstract class Frame {

    /* renamed from: i  reason: collision with root package name */
    public static final Companion f47538i = new Companion(null);

    /* renamed from: j  reason: collision with root package name */
    private static final byte[] f47539j = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    private final boolean f47540a;

    /* renamed from: b  reason: collision with root package name */
    private final FrameType f47541b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f47542c;

    /* renamed from: d  reason: collision with root package name */
    private final DisposableHandle f47543d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f47544e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f47545f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f47546g;

    /* renamed from: h  reason: collision with root package name */
    private final ByteBuffer f47547h;

    /* compiled from: Frame.kt */
    /* loaded from: classes5.dex */
    public static final class Binary extends Frame {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Binary(boolean z7, byte[] data, boolean z8, boolean z9, boolean z10) {
            super(z7, FrameType.BINARY, data, NonDisposableHandle.f47560f, z8, z9, z10, null);
            Intrinsics.f(data, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Binary(boolean z7, byte[] data) {
            this(z7, data, false, false, false);
            Intrinsics.f(data, "data");
        }
    }

    /* compiled from: Frame.kt */
    /* loaded from: classes5.dex */
    public static final class Close extends Frame {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Close(byte[] data) {
            super(true, FrameType.CLOSE, data, NonDisposableHandle.f47560f, false, false, false, null);
            Intrinsics.f(data, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Close(ByteReadPacket packet) {
            this(StringsKt.c(packet, 0, 1, null));
            Intrinsics.f(packet, "packet");
        }

        public Close() {
            this(Frame.f47539j);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Close(io.ktor.websocket.CloseReason r9) {
            /*
                r8 = this;
                java.lang.String r0 = "reason"
                kotlin.jvm.internal.Intrinsics.f(r9, r0)
                io.ktor.utils.io.core.BytePacketBuilder r0 = new io.ktor.utils.io.core.BytePacketBuilder
                r1 = 0
                r2 = 1
                r0.<init>(r1, r2, r1)
                short r1 = r9.a()     // Catch: java.lang.Throwable -> L29
                io.ktor.utils.io.core.OutputPrimitivesKt.a(r0, r1)     // Catch: java.lang.Throwable -> L29
                java.lang.String r2 = r9.c()     // Catch: java.lang.Throwable -> L29
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 14
                r7 = 0
                r1 = r0
                io.ktor.utils.io.core.StringsKt.i(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L29
                io.ktor.utils.io.core.ByteReadPacket r9 = r0.K0()     // Catch: java.lang.Throwable -> L29
                r8.<init>(r9)
                return
            L29:
                r9 = move-exception
                r0.release()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.Frame.Close.<init>(io.ktor.websocket.CloseReason):void");
        }
    }

    /* compiled from: Frame.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: Frame.kt */
    /* loaded from: classes5.dex */
    public static final class Text extends Frame {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Text(boolean z7, byte[] data, boolean z8, boolean z9, boolean z10) {
            super(z7, FrameType.TEXT, data, NonDisposableHandle.f47560f, z8, z9, z10, null);
            Intrinsics.f(data, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Text(boolean z7, byte[] data) {
            this(z7, data, false, false, false);
            Intrinsics.f(data, "data");
        }
    }

    private Frame(boolean z7, FrameType frameType, byte[] bArr, DisposableHandle disposableHandle, boolean z8, boolean z9, boolean z10) {
        this.f47540a = z7;
        this.f47541b = frameType;
        this.f47542c = bArr;
        this.f47543d = disposableHandle;
        this.f47544e = z8;
        this.f47545f = z9;
        this.f47546g = z10;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        Intrinsics.e(wrap, "wrap(data)");
        this.f47547h = wrap;
    }

    public /* synthetic */ Frame(boolean z7, FrameType frameType, byte[] bArr, DisposableHandle disposableHandle, boolean z8, boolean z9, boolean z10, DefaultConstructorMarker defaultConstructorMarker) {
        this(z7, frameType, bArr, disposableHandle, z8, z9, z10);
    }

    public final byte[] b() {
        return this.f47542c;
    }

    public String toString() {
        return "Frame " + this.f47541b + " (fin=" + this.f47540a + ", buffer len = " + this.f47542c.length + ')';
    }
}
