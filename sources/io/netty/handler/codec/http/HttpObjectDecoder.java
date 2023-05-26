package io.netty.handler.codec.http;

import androidx.fragment.app.FragmentTransaction;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.PrematureChannelClosureException;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.AppendableCharSequence;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class HttpObjectDecoder extends ByteToMessageDecoder {
    private long chunkSize;
    private final boolean chunkedSupported;
    private long contentLength;
    private State currentState;
    private final HeaderParser headerParser;
    private final LineParser lineParser;
    private final int maxChunkSize;
    private HttpMessage message;
    private CharSequence name;
    private volatile boolean resetRequested;
    private LastHttpContent trailer;
    protected final boolean validateHeaders;
    private CharSequence value;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.codec.http.HttpObjectDecoder$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State = iArr;
            try {
                iArr[State.SKIP_CONTROL_CHARS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_SIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_INITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_HEADER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_VARIABLE_LENGTH_CONTENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_FIXED_LENGTH_CONTENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNKED_CONTENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_DELIMITER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_FOOTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.BAD_MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.UPGRADED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class HeaderParser implements ByteProcessor {
        private final int maxLength;
        private final AppendableCharSequence seq;
        private int size;

        HeaderParser(AppendableCharSequence appendableCharSequence, int i8) {
            this.seq = appendableCharSequence;
            this.maxLength = i8;
        }

        protected final void increaseCount() {
            int i8 = this.size + 1;
            this.size = i8;
            int i9 = this.maxLength;
            if (i8 <= i9) {
                return;
            }
            throw newException(i9);
        }

        protected TooLongFrameException newException(int i8) {
            return new TooLongFrameException("HTTP header is larger than " + i8 + " bytes.");
        }

        public AppendableCharSequence parse(ByteBuf byteBuf) {
            int i8 = this.size;
            this.seq.reset();
            int forEachByte = byteBuf.forEachByte(this);
            if (forEachByte == -1) {
                this.size = i8;
                return null;
            }
            byteBuf.readerIndex(forEachByte + 1);
            return this.seq;
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b8) throws Exception {
            char c8 = (char) (b8 & 255);
            if (c8 == '\n') {
                int length = this.seq.length();
                if (length >= 1) {
                    int i8 = length - 1;
                    if (this.seq.charAtUnsafe(i8) == '\r') {
                        this.size--;
                        this.seq.setLength(i8);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            increaseCount();
            this.seq.append(c8);
            return true;
        }

        public void reset() {
            this.size = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class LineParser extends HeaderParser {
        LineParser(AppendableCharSequence appendableCharSequence, int i8) {
            super(appendableCharSequence, i8);
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder.HeaderParser
        protected TooLongFrameException newException(int i8) {
            return new TooLongFrameException("An HTTP line is larger than " + i8 + " bytes.");
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder.HeaderParser
        public AppendableCharSequence parse(ByteBuf byteBuf) {
            reset();
            return super.parse(byteBuf);
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder.HeaderParser, io.netty.util.ByteProcessor
        public boolean process(byte b8) throws Exception {
            if (HttpObjectDecoder.this.currentState == State.SKIP_CONTROL_CHARS) {
                char c8 = (char) (b8 & 255);
                if (!Character.isISOControl(c8) && !Character.isWhitespace(c8)) {
                    HttpObjectDecoder.this.currentState = State.READ_INITIAL;
                } else {
                    increaseCount();
                    return true;
                }
            }
            return super.process(b8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum State {
        SKIP_CONTROL_CHARS,
        READ_INITIAL,
        READ_HEADER,
        READ_VARIABLE_LENGTH_CONTENT,
        READ_FIXED_LENGTH_CONTENT,
        READ_CHUNK_SIZE,
        READ_CHUNKED_CONTENT,
        READ_CHUNK_DELIMITER,
        READ_CHUNK_FOOTER,
        BAD_MESSAGE,
        UPGRADED
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpObjectDecoder() {
        this(4096, FragmentTransaction.TRANSIT_EXIT_MASK, FragmentTransaction.TRANSIT_EXIT_MASK, true);
    }

    private long contentLength() {
        if (this.contentLength == Long.MIN_VALUE) {
            this.contentLength = HttpUtil.getContentLength(this.message, -1L);
        }
        return this.contentLength;
    }

    private static int findEndOfString(AppendableCharSequence appendableCharSequence) {
        for (int length = appendableCharSequence.length() - 1; length > 0; length--) {
            if (!Character.isWhitespace(appendableCharSequence.charAtUnsafe(length))) {
                return length + 1;
            }
        }
        return 0;
    }

    private static int findNonSPLenient(AppendableCharSequence appendableCharSequence, int i8) {
        while (i8 < appendableCharSequence.length()) {
            char charAtUnsafe = appendableCharSequence.charAtUnsafe(i8);
            if (isSPLenient(charAtUnsafe)) {
                i8++;
            } else if (!Character.isWhitespace(charAtUnsafe)) {
                return i8;
            } else {
                throw new IllegalArgumentException("Invalid separator");
            }
        }
        return appendableCharSequence.length();
    }

    private static int findNonWhitespace(AppendableCharSequence appendableCharSequence, int i8, boolean z7) {
        while (i8 < appendableCharSequence.length()) {
            char charAtUnsafe = appendableCharSequence.charAtUnsafe(i8);
            if (!Character.isWhitespace(charAtUnsafe)) {
                return i8;
            }
            if (z7 && !isOWS(charAtUnsafe)) {
                throw new IllegalArgumentException("Invalid separator, only a single space or horizontal tab allowed, but received a '" + charAtUnsafe + "'");
            }
            i8++;
        }
        return appendableCharSequence.length();
    }

    private static int findSPLenient(AppendableCharSequence appendableCharSequence, int i8) {
        while (i8 < appendableCharSequence.length()) {
            if (isSPLenient(appendableCharSequence.charAtUnsafe(i8))) {
                return i8;
            }
            i8++;
        }
        return appendableCharSequence.length();
    }

    private static int getChunkSize(String str) {
        String trim = str.trim();
        for (int i8 = 0; i8 < trim.length(); i8++) {
            char charAt = trim.charAt(i8);
            if (charAt == ';' || Character.isWhitespace(charAt) || Character.isISOControl(charAt)) {
                trim = trim.substring(0, i8);
                break;
            }
        }
        return Integer.parseInt(trim, 16);
    }

    private HttpContent invalidChunk(ByteBuf byteBuf, Exception exc) {
        this.currentState = State.BAD_MESSAGE;
        byteBuf.skipBytes(byteBuf.readableBytes());
        DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER);
        defaultLastHttpContent.setDecoderResult(DecoderResult.failure(exc));
        this.message = null;
        this.trailer = null;
        return defaultLastHttpContent;
    }

    private HttpMessage invalidMessage(ByteBuf byteBuf, Exception exc) {
        this.currentState = State.BAD_MESSAGE;
        byteBuf.skipBytes(byteBuf.readableBytes());
        if (this.message == null) {
            this.message = createInvalidMessage();
        }
        this.message.setDecoderResult(DecoderResult.failure(exc));
        HttpMessage httpMessage = this.message;
        this.message = null;
        return httpMessage;
    }

    private static boolean isOWS(char c8) {
        return c8 == ' ' || c8 == '\t';
    }

    private static boolean isSPLenient(char c8) {
        return c8 == ' ' || c8 == '\t' || c8 == 11 || c8 == '\f' || c8 == '\r';
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private io.netty.handler.codec.http.HttpObjectDecoder.State readHeaders(io.netty.buffer.ByteBuf r10) {
        /*
            r9 = this;
            io.netty.handler.codec.http.HttpMessage r0 = r9.message
            io.netty.handler.codec.http.HttpHeaders r1 = r0.headers()
            io.netty.handler.codec.http.HttpObjectDecoder$HeaderParser r2 = r9.headerParser
            io.netty.util.internal.AppendableCharSequence r2 = r2.parse(r10)
            r3 = 0
            if (r2 != 0) goto L10
            return r3
        L10:
            int r4 = r2.length()
            r5 = 0
            if (r4 <= 0) goto L63
        L17:
            char r4 = r2.charAtUnsafe(r5)
            java.lang.CharSequence r6 = r9.name
            if (r6 == 0) goto L4a
            r7 = 32
            if (r4 == r7) goto L27
            r8 = 9
            if (r4 != r8) goto L4a
        L27:
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r2.trim()
            java.lang.CharSequence r4 = r9.value
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            r6.append(r7)
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            r9.value = r2
            goto L54
        L4a:
            if (r6 == 0) goto L51
            java.lang.CharSequence r4 = r9.value
            r1.add(r6, r4)
        L51:
            r9.splitHeader(r2)
        L54:
            io.netty.handler.codec.http.HttpObjectDecoder$HeaderParser r2 = r9.headerParser
            io.netty.util.internal.AppendableCharSequence r2 = r2.parse(r10)
            if (r2 != 0) goto L5d
            return r3
        L5d:
            int r4 = r2.length()
            if (r4 > 0) goto L17
        L63:
            java.lang.CharSequence r10 = r9.name
            if (r10 == 0) goto L6c
            java.lang.CharSequence r2 = r9.value
            r1.add(r10, r2)
        L6c:
            r9.name = r3
            r9.value = r3
            io.netty.util.AsciiString r10 = io.netty.handler.codec.http.HttpHeaderNames.CONTENT_LENGTH
            java.util.List r10 = r1.getAll(r10)
            int r1 = r10.size()
            if (r1 <= 0) goto L9c
            r2 = 1
            if (r1 <= r2) goto L90
            io.netty.handler.codec.http.HttpVersion r2 = r0.protocolVersion()
            io.netty.handler.codec.http.HttpVersion r3 = io.netty.handler.codec.http.HttpVersion.HTTP_1_1
            if (r2 == r3) goto L88
            goto L90
        L88:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Multiple Content-Length headers found"
            r10.<init>(r0)
            throw r10
        L90:
            java.lang.Object r10 = r10.get(r5)
            java.lang.String r10 = (java.lang.String) r10
            long r2 = java.lang.Long.parseLong(r10)
            r9.contentLength = r2
        L9c:
            boolean r10 = r9.isContentAlwaysEmpty(r0)
            if (r10 == 0) goto La8
            io.netty.handler.codec.http.HttpUtil.setTransferEncodingChunked(r0, r5)
            io.netty.handler.codec.http.HttpObjectDecoder$State r10 = io.netty.handler.codec.http.HttpObjectDecoder.State.SKIP_CONTROL_CHARS
            return r10
        La8:
            boolean r10 = io.netty.handler.codec.http.HttpUtil.isTransferEncodingChunked(r0)
            if (r10 == 0) goto Lbe
            if (r1 <= 0) goto Lbb
            io.netty.handler.codec.http.HttpVersion r10 = r0.protocolVersion()
            io.netty.handler.codec.http.HttpVersion r1 = io.netty.handler.codec.http.HttpVersion.HTTP_1_1
            if (r10 != r1) goto Lbb
            r9.handleTransferEncodingChunkedWithContentLength(r0)
        Lbb:
            io.netty.handler.codec.http.HttpObjectDecoder$State r10 = io.netty.handler.codec.http.HttpObjectDecoder.State.READ_CHUNK_SIZE
            return r10
        Lbe:
            long r0 = r9.contentLength()
            r2 = 0
            int r10 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r10 < 0) goto Lcb
            io.netty.handler.codec.http.HttpObjectDecoder$State r10 = io.netty.handler.codec.http.HttpObjectDecoder.State.READ_FIXED_LENGTH_CONTENT
            return r10
        Lcb:
            io.netty.handler.codec.http.HttpObjectDecoder$State r10 = io.netty.handler.codec.http.HttpObjectDecoder.State.READ_VARIABLE_LENGTH_CONTENT
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.HttpObjectDecoder.readHeaders(io.netty.buffer.ByteBuf):io.netty.handler.codec.http.HttpObjectDecoder$State");
    }

    private LastHttpContent readTrailingHeaders(ByteBuf byteBuf) {
        int size;
        AppendableCharSequence parse = this.headerParser.parse(byteBuf);
        if (parse == null) {
            return null;
        }
        LastHttpContent lastHttpContent = this.trailer;
        if (parse.length() == 0 && lastHttpContent == null) {
            return LastHttpContent.EMPTY_LAST_CONTENT;
        }
        if (lastHttpContent == null) {
            lastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER, this.validateHeaders);
            this.trailer = lastHttpContent;
        }
        CharSequence charSequence = null;
        while (parse.length() > 0) {
            char charAtUnsafe = parse.charAtUnsafe(0);
            if (charSequence != null && (charAtUnsafe == ' ' || charAtUnsafe == '\t')) {
                List<String> all = lastHttpContent.trailingHeaders().getAll(charSequence);
                if (!all.isEmpty()) {
                    all.set(all.size() - 1, all.get(size) + parse.toString().trim());
                }
            } else {
                splitHeader(parse);
                CharSequence charSequence2 = this.name;
                if (!HttpHeaderNames.CONTENT_LENGTH.contentEqualsIgnoreCase(charSequence2) && !HttpHeaderNames.TRANSFER_ENCODING.contentEqualsIgnoreCase(charSequence2) && !HttpHeaderNames.TRAILER.contentEqualsIgnoreCase(charSequence2)) {
                    lastHttpContent.trailingHeaders().add(charSequence2, this.value);
                }
                charSequence = this.name;
                this.name = null;
                this.value = null;
            }
            parse = this.headerParser.parse(byteBuf);
            if (parse == null) {
                return null;
            }
        }
        this.trailer = null;
        return lastHttpContent;
    }

    private void resetNow() {
        HttpResponse httpResponse;
        HttpMessage httpMessage = this.message;
        this.message = null;
        this.name = null;
        this.value = null;
        this.contentLength = Long.MIN_VALUE;
        this.lineParser.reset();
        this.headerParser.reset();
        this.trailer = null;
        if (!isDecodingRequest() && (httpResponse = (HttpResponse) httpMessage) != null && isSwitchingToNonHttp1Protocol(httpResponse)) {
            this.currentState = State.UPGRADED;
            return;
        }
        this.resetRequested = false;
        this.currentState = State.SKIP_CONTROL_CHARS;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
        r4 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        if (r4 >= r0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
        if (r7.charAtUnsafe(r4) != ':') goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
        r6.name = r7.subStringUnsafe(r1, r2);
        r1 = findNonWhitespace(r7, r4, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
        if (r1 != r0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
        r6.value = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
        r6.value = r7.subStringUnsafe(r1, findEndOfString(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void splitHeader(io.netty.util.internal.AppendableCharSequence r7) {
        /*
            r6 = this;
            int r0 = r7.length()
            r1 = 0
            int r1 = findNonWhitespace(r7, r1, r1)
            r2 = r1
        La:
            r3 = 58
            if (r2 >= r0) goto L24
            char r4 = r7.charAtUnsafe(r2)
            if (r4 == r3) goto L24
            boolean r5 = r6.isDecodingRequest()
            if (r5 != 0) goto L21
            boolean r4 = isOWS(r4)
            if (r4 == 0) goto L21
            goto L24
        L21:
            int r2 = r2 + 1
            goto La
        L24:
            if (r2 == r0) goto L52
            r4 = r2
        L27:
            if (r4 >= r0) goto L35
            char r5 = r7.charAtUnsafe(r4)
            if (r5 != r3) goto L32
            int r4 = r4 + 1
            goto L35
        L32:
            int r4 = r4 + 1
            goto L27
        L35:
            java.lang.String r1 = r7.subStringUnsafe(r1, r2)
            r6.name = r1
            r1 = 1
            int r1 = findNonWhitespace(r7, r4, r1)
            if (r1 != r0) goto L47
            java.lang.String r7 = ""
            r6.value = r7
            goto L51
        L47:
            int r0 = findEndOfString(r7)
            java.lang.String r7 = r7.subStringUnsafe(r1, r0)
            r6.value = r7
        L51:
            return
        L52:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "No colon found"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.HttpObjectDecoder.splitHeader(io.netty.util.internal.AppendableCharSequence):void");
    }

    private static String[] splitInitialLine(AppendableCharSequence appendableCharSequence) {
        String str;
        int findNonSPLenient = findNonSPLenient(appendableCharSequence, 0);
        int findSPLenient = findSPLenient(appendableCharSequence, findNonSPLenient);
        int findNonSPLenient2 = findNonSPLenient(appendableCharSequence, findSPLenient);
        int findSPLenient2 = findSPLenient(appendableCharSequence, findNonSPLenient2);
        int findNonSPLenient3 = findNonSPLenient(appendableCharSequence, findSPLenient2);
        int findEndOfString = findEndOfString(appendableCharSequence);
        String[] strArr = new String[3];
        strArr[0] = appendableCharSequence.subStringUnsafe(findNonSPLenient, findSPLenient);
        strArr[1] = appendableCharSequence.subStringUnsafe(findNonSPLenient2, findSPLenient2);
        if (findNonSPLenient3 < findEndOfString) {
            str = appendableCharSequence.subStringUnsafe(findNonSPLenient3, findEndOfString);
        } else {
            str = "";
        }
        strArr[2] = str;
        return strArr;
    }

    protected abstract HttpMessage createInvalidMessage();

    protected abstract HttpMessage createMessage(String[] strArr) throws Exception;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0106 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0139 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x013a A[Catch: Exception -> 0x0197, TryCatch #3 {Exception -> 0x0197, blocks: (B:69:0x0133, B:72:0x013a, B:76:0x0148, B:80:0x0156, B:83:0x015d, B:85:0x0166, B:87:0x0169, B:89:0x0177, B:91:0x017b, B:93:0x0181, B:94:0x0188, B:95:0x0189), top: B:107:0x0133 }] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void decode(io.netty.channel.ChannelHandlerContext r8, io.netty.buffer.ByteBuf r9, java.util.List<java.lang.Object> r10) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 452
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.HttpObjectDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decodeLast(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        super.decodeLast(channelHandlerContext, byteBuf, list);
        if (this.resetRequested) {
            resetNow();
        }
        HttpMessage httpMessage = this.message;
        if (httpMessage != null) {
            boolean isTransferEncodingChunked = HttpUtil.isTransferEncodingChunked(httpMessage);
            if (this.currentState == State.READ_VARIABLE_LENGTH_CONTENT && !byteBuf.isReadable() && !isTransferEncodingChunked) {
                list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                resetNow();
            } else if (this.currentState == State.READ_HEADER) {
                list.add(invalidMessage(Unpooled.EMPTY_BUFFER, new PrematureChannelClosureException("Connection closed before received headers")));
                resetNow();
            } else {
                boolean z7 = true;
                if (!isDecodingRequest() && !isTransferEncodingChunked && contentLength() <= 0) {
                    z7 = false;
                }
                if (!z7) {
                    list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                }
                resetNow();
            }
        }
    }

    protected void handleTransferEncodingChunkedWithContentLength(HttpMessage httpMessage) {
        httpMessage.headers().remove(HttpHeaderNames.CONTENT_LENGTH);
        this.contentLength = Long.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
        if (httpMessage instanceof HttpResponse) {
            HttpResponse httpResponse = (HttpResponse) httpMessage;
            int code = httpResponse.status().code();
            if (code >= 100 && code < 200) {
                if (code == 101 && !httpResponse.headers().contains(HttpHeaderNames.SEC_WEBSOCKET_ACCEPT) && httpResponse.headers().contains((CharSequence) HttpHeaderNames.UPGRADE, (CharSequence) HttpHeaderValues.WEBSOCKET, true)) {
                    return false;
                }
                return true;
            } else if (code == 204 || code == 304) {
                return true;
            }
        }
        return false;
    }

    protected abstract boolean isDecodingRequest();

    protected boolean isSwitchingToNonHttp1Protocol(HttpResponse httpResponse) {
        if (httpResponse.status().code() != HttpResponseStatus.SWITCHING_PROTOCOLS.code()) {
            return false;
        }
        String str = httpResponse.headers().get(HttpHeaderNames.UPGRADE);
        if (str != null && (str.contains(HttpVersion.HTTP_1_0.text()) || str.contains(HttpVersion.HTTP_1_1.text()))) {
            return false;
        }
        return true;
    }

    public void reset() {
        this.resetRequested = true;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        int i8;
        if ((obj instanceof HttpExpectationFailedEvent) && ((i8 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[this.currentState.ordinal()]) == 2 || i8 == 5 || i8 == 6)) {
            reset();
        }
        super.userEventTriggered(channelHandlerContext, obj);
    }

    protected HttpObjectDecoder(int i8, int i9, int i10, boolean z7) {
        this(i8, i9, i10, z7, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpObjectDecoder(int i8, int i9, int i10, boolean z7, boolean z8) {
        this(i8, i9, i10, z7, z8, 128);
    }

    protected HttpObjectDecoder(int i8, int i9, int i10, boolean z7, boolean z8, int i11) {
        this.contentLength = Long.MIN_VALUE;
        this.currentState = State.SKIP_CONTROL_CHARS;
        ObjectUtil.checkPositive(i8, "maxInitialLineLength");
        ObjectUtil.checkPositive(i9, "maxHeaderSize");
        ObjectUtil.checkPositive(i10, "maxChunkSize");
        AppendableCharSequence appendableCharSequence = new AppendableCharSequence(i11);
        this.lineParser = new LineParser(appendableCharSequence, i8);
        this.headerParser = new HeaderParser(appendableCharSequence, i9);
        this.maxChunkSize = i10;
        this.chunkedSupported = z7;
        this.validateHeaders = z8;
    }
}
