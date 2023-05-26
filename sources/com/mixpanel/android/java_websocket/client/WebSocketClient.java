package com.mixpanel.android.java_websocket.client;

import android.annotation.SuppressLint;
import com.mixpanel.android.java_websocket.WebSocket;
import com.mixpanel.android.java_websocket.WebSocketAdapter;
import com.mixpanel.android.java_websocket.WebSocketImpl;
import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.handshake.HandshakeImpl1Client;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

@SuppressLint({"Assert"})
/* loaded from: classes3.dex */
public abstract class WebSocketClient extends WebSocketAdapter implements Runnable, WebSocket {

    /* renamed from: f  reason: collision with root package name */
    protected URI f18991f;

    /* renamed from: g  reason: collision with root package name */
    private WebSocketImpl f18992g;

    /* renamed from: i  reason: collision with root package name */
    private InputStream f18994i;

    /* renamed from: j  reason: collision with root package name */
    private OutputStream f18995j;

    /* renamed from: l  reason: collision with root package name */
    private Thread f18997l;

    /* renamed from: m  reason: collision with root package name */
    private Draft f18998m;

    /* renamed from: n  reason: collision with root package name */
    private Map<String, String> f18999n;

    /* renamed from: q  reason: collision with root package name */
    private int f19002q;

    /* renamed from: h  reason: collision with root package name */
    private Socket f18993h = null;

    /* renamed from: k  reason: collision with root package name */
    private Proxy f18996k = Proxy.NO_PROXY;

    /* renamed from: o  reason: collision with root package name */
    private CountDownLatch f19000o = new CountDownLatch(1);

    /* renamed from: p  reason: collision with root package name */
    private CountDownLatch f19001p = new CountDownLatch(1);

    /* loaded from: classes3.dex */
    private class WebsocketWriteThread implements Runnable {
        private WebsocketWriteThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("WebsocketWriteThread");
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer take = WebSocketClient.this.f18992g.f18976h.take();
                    WebSocketClient.this.f18995j.write(take.array(), 0, take.limit());
                    WebSocketClient.this.f18995j.flush();
                } catch (IOException unused) {
                    WebSocketClient.this.f18992g.k();
                    return;
                } catch (InterruptedException unused2) {
                    return;
                }
            }
        }
    }

    public WebSocketClient(URI uri, Draft draft, Map<String, String> map, int i8) {
        this.f18991f = null;
        this.f18992g = null;
        this.f19002q = 0;
        if (uri != null) {
            if (draft != null) {
                this.f18991f = uri;
                this.f18998m = draft;
                this.f18999n = map;
                this.f19002q = i8;
                this.f18992g = new WebSocketImpl(this, draft);
                return;
            }
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        }
        throw new IllegalArgumentException();
    }

    private void K() throws InvalidHandshakeException {
        String str;
        String path = this.f18991f.getPath();
        String query = this.f18991f.getQuery();
        path = (path == null || path.length() == 0) ? "/" : "/";
        if (query != null) {
            path = path + "?" + query;
        }
        int w7 = w();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f18991f.getHost());
        if (w7 != 80) {
            str = ":" + w7;
        } else {
            str = "";
        }
        sb.append(str);
        String sb2 = sb.toString();
        HandshakeImpl1Client handshakeImpl1Client = new HandshakeImpl1Client();
        handshakeImpl1Client.f(path);
        handshakeImpl1Client.put("Host", sb2);
        Map<String, String> map = this.f18999n;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                handshakeImpl1Client.put(entry.getKey(), entry.getValue());
            }
        }
        this.f18992g.w(handshakeImpl1Client);
    }

    private int w() {
        int port = this.f18991f.getPort();
        if (port == -1) {
            String scheme = this.f18991f.getScheme();
            if (scheme.equals("wss")) {
                return 443;
            }
            if (scheme.equals("ws")) {
                return 80;
            }
            throw new RuntimeException("unkonow scheme" + scheme);
        }
        return port;
    }

    public boolean A() {
        return this.f18992g.s();
    }

    public abstract void B(int i8, String str, boolean z7);

    public void C(int i8, String str) {
    }

    public void D(int i8, String str, boolean z7) {
    }

    public abstract void E(Exception exc);

    public void F(Framedata framedata) {
    }

    public abstract void G(String str);

    public void H(ByteBuffer byteBuffer) {
    }

    public abstract void I(ServerHandshake serverHandshake);

    public void J(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z7) {
        this.f18992g.v(opcode, byteBuffer, z7);
    }

    public void L(Socket socket) {
        if (this.f18993h == null) {
            this.f18993h = socket;
            return;
        }
        throw new IllegalStateException("socket has already been set");
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public final void a(WebSocket webSocket) {
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public void c(WebSocket webSocket, int i8, String str, boolean z7) {
        D(i8, str, z7);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public final void e(WebSocket webSocket, Handshakedata handshakedata) {
        this.f19000o.countDown();
        I((ServerHandshake) handshakedata);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public final void f(WebSocket webSocket, String str) {
        G(str);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public final void g(WebSocket webSocket, int i8, String str, boolean z7) {
        this.f19000o.countDown();
        this.f19001p.countDown();
        Thread thread = this.f18997l;
        if (thread != null) {
            thread.interrupt();
        }
        try {
            Socket socket = this.f18993h;
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e8) {
            i(this, e8);
        }
        B(i8, str, z7);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocket
    public InetSocketAddress h() {
        return this.f18992g.h();
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public final void i(WebSocket webSocket, Exception exc) {
        E(exc);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public void l(WebSocket webSocket, int i8, String str) {
        C(i8, str);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketAdapter, com.mixpanel.android.java_websocket.WebSocketListener
    public void m(WebSocket webSocket, Framedata framedata) {
        F(framedata);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public final void o(WebSocket webSocket, ByteBuffer byteBuffer) {
        H(byteBuffer);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocket
    public void q(Framedata framedata) {
        this.f18992g.q(framedata);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public InetSocketAddress r(WebSocket webSocket) {
        Socket socket = this.f18993h;
        if (socket != null) {
            return (InetSocketAddress) socket.getLocalSocketAddress();
        }
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        int read;
        try {
            Socket socket = this.f18993h;
            if (socket == null) {
                this.f18993h = new Socket(this.f18996k);
            } else if (socket.isClosed()) {
                throw new IOException();
            }
            if (!this.f18993h.isBound()) {
                this.f18993h.connect(new InetSocketAddress(this.f18991f.getHost(), w()), this.f19002q);
            }
            this.f18994i = this.f18993h.getInputStream();
            this.f18995j = this.f18993h.getOutputStream();
            K();
            Thread thread = new Thread(new WebsocketWriteThread());
            this.f18997l = thread;
            thread.start();
            byte[] bArr = new byte[WebSocketImpl.f18971w];
            while (!x() && (read = this.f18994i.read(bArr)) != -1) {
                try {
                    this.f18992g.g(ByteBuffer.wrap(bArr, 0, read));
                } catch (IOException unused) {
                    this.f18992g.k();
                    return;
                } catch (RuntimeException e8) {
                    E(e8);
                    this.f18992g.d(1006, e8.getMessage());
                    return;
                }
            }
            this.f18992g.k();
        } catch (Exception e9) {
            i(this.f18992g, e9);
            this.f18992g.d(-1, e9.getMessage());
        }
    }

    public void u() {
        if (this.f18997l == null) {
            Thread thread = new Thread(this);
            this.f18997l = thread;
            thread.start();
            return;
        }
        throw new IllegalStateException("WebSocketClient objects are not reuseable");
    }

    public boolean v() throws InterruptedException {
        u();
        this.f19000o.await();
        return this.f18992g.s();
    }

    public boolean x() {
        return this.f18992g.n();
    }

    public boolean y() {
        return this.f18992g.o();
    }

    public boolean z() {
        return this.f18992g.r();
    }
}
