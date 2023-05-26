package okio;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: PeekSource.kt */
/* loaded from: classes5.dex */
public final class PeekSource implements Source {

    /* renamed from: f  reason: collision with root package name */
    private final BufferedSource f52617f;

    /* renamed from: g  reason: collision with root package name */
    private final Buffer f52618g;

    /* renamed from: h  reason: collision with root package name */
    private Segment f52619h;

    /* renamed from: i  reason: collision with root package name */
    private int f52620i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f52621j;

    /* renamed from: k  reason: collision with root package name */
    private long f52622k;

    public PeekSource(BufferedSource upstream) {
        int i8;
        Intrinsics.f(upstream, "upstream");
        this.f52617f = upstream;
        Buffer b8 = upstream.b();
        this.f52618g = b8;
        Segment segment = b8.f52580f;
        this.f52619h = segment;
        if (segment == null) {
            i8 = -1;
        } else {
            i8 = segment.f52632b;
        }
        this.f52620i = i8;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f52621j = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
        if (r5 == r6.f52632b) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006f  */
    @Override // okio.Source
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long read(okio.Buffer r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.Intrinsics.f(r9, r0)
            r0 = 0
            r1 = 0
            r3 = 1
            int r4 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r4 < 0) goto Lf
            r5 = 1
            goto L10
        Lf:
            r5 = 0
        L10:
            if (r5 == 0) goto L87
            boolean r5 = r8.f52621j
            r5 = r5 ^ r3
            if (r5 == 0) goto L7b
            okio.Segment r5 = r8.f52619h
            if (r5 == 0) goto L2a
            okio.Buffer r6 = r8.f52618g
            okio.Segment r6 = r6.f52580f
            if (r5 != r6) goto L2b
            int r5 = r8.f52620i
            kotlin.jvm.internal.Intrinsics.c(r6)
            int r6 = r6.f52632b
            if (r5 != r6) goto L2b
        L2a:
            r0 = 1
        L2b:
            if (r0 == 0) goto L6f
            if (r4 != 0) goto L30
            return r1
        L30:
            okio.BufferedSource r0 = r8.f52617f
            long r1 = r8.f52622k
            r3 = 1
            long r1 = r1 + r3
            boolean r0 = r0.f(r1)
            if (r0 != 0) goto L40
            r9 = -1
            return r9
        L40:
            okio.Segment r0 = r8.f52619h
            if (r0 != 0) goto L53
            okio.Buffer r0 = r8.f52618g
            okio.Segment r0 = r0.f52580f
            if (r0 == 0) goto L53
            r8.f52619h = r0
            kotlin.jvm.internal.Intrinsics.c(r0)
            int r0 = r0.f52632b
            r8.f52620i = r0
        L53:
            okio.Buffer r0 = r8.f52618g
            long r0 = r0.size()
            long r2 = r8.f52622k
            long r0 = r0 - r2
            long r10 = java.lang.Math.min(r10, r0)
            okio.Buffer r2 = r8.f52618g
            long r4 = r8.f52622k
            r3 = r9
            r6 = r10
            r2.j(r3, r4, r6)
            long r0 = r8.f52622k
            long r0 = r0 + r10
            r8.f52622k = r0
            return r10
        L6f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L7b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L87:
            java.lang.Long r9 = java.lang.Long.valueOf(r10)
            java.lang.String r10 = "byteCount < 0: "
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.n(r10, r9)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.PeekSource.read(okio.Buffer, long):long");
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.f52617f.timeout();
    }
}
