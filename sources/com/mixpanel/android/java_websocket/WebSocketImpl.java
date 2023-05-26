package com.mixpanel.android.java_websocket;

import android.annotation.SuppressLint;
import com.mixpanel.android.java_websocket.WebSocket;
import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.drafts.Draft_10;
import com.mixpanel.android.java_websocket.drafts.Draft_17;
import com.mixpanel.android.java_websocket.drafts.Draft_75;
import com.mixpanel.android.java_websocket.drafts.Draft_76;
import com.mixpanel.android.java_websocket.exceptions.IncompleteHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.WebsocketNotConnectedException;
import com.mixpanel.android.java_websocket.framing.CloseFrame;
import com.mixpanel.android.java_websocket.framing.CloseFrameBuilder;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import com.mixpanel.android.java_websocket.util.Charsetfunctions;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@SuppressLint({"Assert"})
/* loaded from: classes3.dex */
public class WebSocketImpl implements WebSocket {

    /* renamed from: w  reason: collision with root package name */
    public static int f18971w = 16384;

    /* renamed from: x  reason: collision with root package name */
    public static boolean f18972x = false;

    /* renamed from: y  reason: collision with root package name */
    public static final List<Draft> f18973y;

    /* renamed from: f  reason: collision with root package name */
    public SelectionKey f18974f;

    /* renamed from: g  reason: collision with root package name */
    public ByteChannel f18975g;

    /* renamed from: h  reason: collision with root package name */
    public final BlockingQueue<ByteBuffer> f18976h;

    /* renamed from: i  reason: collision with root package name */
    public final BlockingQueue<ByteBuffer> f18977i;

    /* renamed from: l  reason: collision with root package name */
    private final WebSocketListener f18980l;

    /* renamed from: m  reason: collision with root package name */
    private List<Draft> f18981m;

    /* renamed from: n  reason: collision with root package name */
    private Draft f18982n;

    /* renamed from: o  reason: collision with root package name */
    private WebSocket.Role f18983o;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f18978j = false;

    /* renamed from: k  reason: collision with root package name */
    private WebSocket.READYSTATE f18979k = WebSocket.READYSTATE.NOT_YET_CONNECTED;

    /* renamed from: p  reason: collision with root package name */
    private Framedata.Opcode f18984p = null;

    /* renamed from: q  reason: collision with root package name */
    private ByteBuffer f18985q = ByteBuffer.allocate(0);

    /* renamed from: r  reason: collision with root package name */
    private ClientHandshake f18986r = null;

    /* renamed from: s  reason: collision with root package name */
    private String f18987s = null;

    /* renamed from: t  reason: collision with root package name */
    private Integer f18988t = null;

    /* renamed from: u  reason: collision with root package name */
    private Boolean f18989u = null;

    /* renamed from: v  reason: collision with root package name */
    private String f18990v = null;

    static {
        ArrayList arrayList = new ArrayList(4);
        f18973y = arrayList;
        arrayList.add(new Draft_17());
        arrayList.add(new Draft_10());
        arrayList.add(new Draft_76());
        arrayList.add(new Draft_75());
    }

    public WebSocketImpl(WebSocketListener webSocketListener, Draft draft) {
        this.f18982n = null;
        if (webSocketListener != null && (draft != null || this.f18983o != WebSocket.Role.SERVER)) {
            this.f18976h = new LinkedBlockingQueue();
            this.f18977i = new LinkedBlockingQueue();
            this.f18980l = webSocketListener;
            this.f18983o = WebSocket.Role.CLIENT;
            if (draft != null) {
                this.f18982n = draft.f();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("parameters must not be null");
    }

    private void b(int i8, String str, boolean z7) {
        WebSocket.READYSTATE readystate = this.f18979k;
        WebSocket.READYSTATE readystate2 = WebSocket.READYSTATE.CLOSING;
        if (readystate != readystate2 && readystate != WebSocket.READYSTATE.CLOSED) {
            if (readystate == WebSocket.READYSTATE.OPEN) {
                if (i8 == 1006) {
                    this.f18979k = readystate2;
                    l(i8, str, false);
                    return;
                }
                if (this.f18982n.j() != Draft.CloseHandshakeType.NONE) {
                    try {
                        if (!z7) {
                            try {
                                this.f18980l.l(this, i8, str);
                            } catch (RuntimeException e8) {
                                this.f18980l.i(this, e8);
                            }
                        }
                        q(new CloseFrameBuilder(i8, str));
                    } catch (InvalidDataException e9) {
                        this.f18980l.i(this, e9);
                        l(1006, "generated frame is invalid", false);
                    }
                }
                l(i8, str, z7);
            } else if (i8 == -3) {
                l(-3, str, true);
            } else {
                l(-1, str, false);
            }
            if (i8 == 1002) {
                l(i8, str, z7);
            }
            this.f18979k = WebSocket.READYSTATE.CLOSING;
            this.f18985q = null;
        }
    }

    private void i(ByteBuffer byteBuffer) {
        try {
        } catch (InvalidDataException e8) {
            this.f18980l.i(this, e8);
            c(e8);
            return;
        }
        for (Framedata framedata : this.f18982n.q(byteBuffer)) {
            if (f18972x) {
                PrintStream printStream = System.out;
                printStream.println("matched frame: " + framedata);
            }
            Framedata.Opcode b8 = framedata.b();
            boolean d8 = framedata.d();
            if (b8 == Framedata.Opcode.CLOSING) {
                int i8 = 1005;
                String str = "";
                if (framedata instanceof CloseFrame) {
                    CloseFrame closeFrame = (CloseFrame) framedata;
                    i8 = closeFrame.e();
                    str = closeFrame.getMessage();
                }
                if (this.f18979k == WebSocket.READYSTATE.CLOSING) {
                    e(i8, str, true);
                } else if (this.f18982n.j() == Draft.CloseHandshakeType.TWOWAY) {
                    b(i8, str, true);
                } else {
                    l(i8, str, false);
                }
            } else if (b8 == Framedata.Opcode.PING) {
                this.f18980l.n(this, framedata);
            } else if (b8 == Framedata.Opcode.PONG) {
                this.f18980l.j(this, framedata);
            } else {
                if (d8 && b8 != Framedata.Opcode.CONTINUOUS) {
                    if (this.f18984p == null) {
                        if (b8 == Framedata.Opcode.TEXT) {
                            try {
                                this.f18980l.f(this, Charsetfunctions.c(framedata.f()));
                            } catch (RuntimeException e9) {
                                this.f18980l.i(this, e9);
                            }
                        } else if (b8 == Framedata.Opcode.BINARY) {
                            try {
                                this.f18980l.o(this, framedata.f());
                            } catch (RuntimeException e10) {
                                this.f18980l.i(this, e10);
                            }
                        } else {
                            throw new InvalidDataException(1002, "non control or continious frame expected");
                        }
                        this.f18980l.i(this, e8);
                        c(e8);
                        return;
                    }
                    throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
                }
                if (b8 != Framedata.Opcode.CONTINUOUS) {
                    if (this.f18984p == null) {
                        this.f18984p = b8;
                    } else {
                        throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                    }
                } else if (d8) {
                    if (this.f18984p != null) {
                        this.f18984p = null;
                    } else {
                        throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                    }
                } else if (this.f18984p == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                try {
                    this.f18980l.m(this, framedata);
                } catch (RuntimeException e11) {
                    this.f18980l.i(this, e11);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean j(java.nio.ByteBuffer r12) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.java_websocket.WebSocketImpl.j(java.nio.ByteBuffer):boolean");
    }

    private Draft.HandshakeState p(ByteBuffer byteBuffer) throws IncompleteHandshakeException {
        byteBuffer.mark();
        int limit = byteBuffer.limit();
        byte[] bArr = Draft.f19005d;
        if (limit > bArr.length) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        if (byteBuffer.limit() >= bArr.length) {
            int i8 = 0;
            while (byteBuffer.hasRemaining()) {
                if (Draft.f19005d[i8] != byteBuffer.get()) {
                    byteBuffer.reset();
                    return Draft.HandshakeState.NOT_MATCHED;
                }
                i8++;
            }
            return Draft.HandshakeState.MATCHED;
        }
        throw new IncompleteHandshakeException(bArr.length);
    }

    private void t(Handshakedata handshakedata) {
        if (f18972x) {
            PrintStream printStream = System.out;
            printStream.println("open using draft: " + this.f18982n.getClass().getSimpleName());
        }
        this.f18979k = WebSocket.READYSTATE.OPEN;
        try {
            this.f18980l.e(this, handshakedata);
        } catch (RuntimeException e8) {
            this.f18980l.i(this, e8);
        }
    }

    private void u(Collection<Framedata> collection) {
        if (s()) {
            for (Framedata framedata : collection) {
                q(framedata);
            }
            return;
        }
        throw new WebsocketNotConnectedException();
    }

    private void x(ByteBuffer byteBuffer) {
        String str;
        if (f18972x) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("write(");
            sb.append(byteBuffer.remaining());
            sb.append("): {");
            if (byteBuffer.remaining() > 1000) {
                str = "too big to display";
            } else {
                str = new String(byteBuffer.array());
            }
            sb.append(str);
            sb.append("}");
            printStream.println(sb.toString());
        }
        this.f18976h.add(byteBuffer);
        this.f18980l.a(this);
    }

    private void y(List<ByteBuffer> list) {
        for (ByteBuffer byteBuffer : list) {
            x(byteBuffer);
        }
    }

    public void a(int i8, String str) {
        b(i8, str, false);
    }

    public void c(InvalidDataException invalidDataException) {
        b(invalidDataException.a(), invalidDataException.getMessage(), false);
    }

    public void d(int i8, String str) {
        e(i8, str, false);
    }

    protected synchronized void e(int i8, String str, boolean z7) {
        if (this.f18979k == WebSocket.READYSTATE.CLOSED) {
            return;
        }
        SelectionKey selectionKey = this.f18974f;
        if (selectionKey != null) {
            selectionKey.cancel();
        }
        ByteChannel byteChannel = this.f18975g;
        if (byteChannel != null) {
            try {
                byteChannel.close();
            } catch (IOException e8) {
                this.f18980l.i(this, e8);
            }
        }
        try {
            this.f18980l.g(this, i8, str, z7);
        } catch (RuntimeException e9) {
            this.f18980l.i(this, e9);
        }
        Draft draft = this.f18982n;
        if (draft != null) {
            draft.o();
        }
        this.f18986r = null;
        this.f18979k = WebSocket.READYSTATE.CLOSED;
        this.f18976h.clear();
    }

    protected void f(int i8, boolean z7) {
        e(i8, "", z7);
    }

    public void g(ByteBuffer byteBuffer) {
        String str;
        if (f18972x) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("process(");
            sb.append(byteBuffer.remaining());
            sb.append("): {");
            if (byteBuffer.remaining() > 1000) {
                str = "too big to display";
            } else {
                str = new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
            }
            sb.append(str);
            sb.append("}");
            printStream.println(sb.toString());
        }
        if (this.f18979k != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            i(byteBuffer);
        } else if (j(byteBuffer)) {
            if (byteBuffer.hasRemaining()) {
                i(byteBuffer);
            } else if (this.f18985q.hasRemaining()) {
                i(this.f18985q);
            }
        }
    }

    @Override // com.mixpanel.android.java_websocket.WebSocket
    public InetSocketAddress h() {
        return this.f18980l.r(this);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void k() {
        if (m() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            f(-1, true);
        } else if (this.f18978j) {
            e(this.f18988t.intValue(), this.f18987s, this.f18989u.booleanValue());
        } else if (this.f18982n.j() == Draft.CloseHandshakeType.NONE) {
            f(1000, true);
        } else if (this.f18982n.j() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.f18983o == WebSocket.Role.SERVER) {
                f(1006, true);
            } else {
                f(1000, true);
            }
        } else {
            f(1006, true);
        }
    }

    protected synchronized void l(int i8, String str, boolean z7) {
        if (this.f18978j) {
            return;
        }
        this.f18988t = Integer.valueOf(i8);
        this.f18987s = str;
        this.f18989u = Boolean.valueOf(z7);
        this.f18978j = true;
        this.f18980l.a(this);
        try {
            this.f18980l.c(this, i8, str, z7);
        } catch (RuntimeException e8) {
            this.f18980l.i(this, e8);
        }
        Draft draft = this.f18982n;
        if (draft != null) {
            draft.o();
        }
        this.f18986r = null;
    }

    public WebSocket.READYSTATE m() {
        return this.f18979k;
    }

    public boolean n() {
        if (this.f18979k == WebSocket.READYSTATE.CLOSED) {
            return true;
        }
        return false;
    }

    public boolean o() {
        if (this.f18979k == WebSocket.READYSTATE.CLOSING) {
            return true;
        }
        return false;
    }

    @Override // com.mixpanel.android.java_websocket.WebSocket
    public void q(Framedata framedata) {
        if (f18972x) {
            PrintStream printStream = System.out;
            printStream.println("send frame: " + framedata);
        }
        x(this.f18982n.g(framedata));
    }

    public boolean r() {
        return this.f18978j;
    }

    public boolean s() {
        if (this.f18979k == WebSocket.READYSTATE.OPEN) {
            return true;
        }
        return false;
    }

    public String toString() {
        return super.toString();
    }

    public void v(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z7) {
        u(this.f18982n.e(opcode, byteBuffer, z7));
    }

    public void w(ClientHandshakeBuilder clientHandshakeBuilder) throws InvalidHandshakeException {
        this.f18986r = this.f18982n.k(clientHandshakeBuilder);
        this.f18990v = clientHandshakeBuilder.c();
        try {
            this.f18980l.k(this, this.f18986r);
            y(this.f18982n.h(this.f18986r, this.f18983o));
        } catch (InvalidDataException unused) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        } catch (RuntimeException e8) {
            this.f18980l.i(this, e8);
            throw new InvalidHandshakeException("rejected because of" + e8);
        }
    }
}
