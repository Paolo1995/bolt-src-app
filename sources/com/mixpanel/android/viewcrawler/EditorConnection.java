package com.mixpanel.android.viewcrawler;

import com.mixpanel.android.java_websocket.client.WebSocketClient;
import com.mixpanel.android.java_websocket.drafts.Draft_17;
import com.mixpanel.android.java_websocket.exceptions.NotSendableException;
import com.mixpanel.android.java_websocket.exceptions.WebsocketNotConnectedException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.util.MPLog;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class EditorConnection {

    /* renamed from: d  reason: collision with root package name */
    private static final ByteBuffer f19467d = ByteBuffer.allocate(0);

    /* renamed from: a  reason: collision with root package name */
    private final Editor f19468a;

    /* renamed from: b  reason: collision with root package name */
    private final EditorClient f19469b;

    /* renamed from: c  reason: collision with root package name */
    private final URI f19470c;

    /* loaded from: classes3.dex */
    public interface Editor {
        void a(JSONObject jSONObject);

        void b();

        void c(JSONObject jSONObject);

        void d(JSONObject jSONObject);

        void e();

        void f(JSONObject jSONObject);

        void g(JSONObject jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class EditorClient extends WebSocketClient {
        public EditorClient(URI uri, int i8, Socket socket) throws InterruptedException {
            super(uri, new Draft_17(), null, i8);
            L(socket);
        }

        @Override // com.mixpanel.android.java_websocket.client.WebSocketClient
        public void B(int i8, String str, boolean z7) {
            MPLog.i("MixpanelAPI.EditorCnctn", "WebSocket closed. Code: " + i8 + ", reason: " + str + "\nURI: " + EditorConnection.this.f19470c);
            EditorConnection.this.f19468a.b();
        }

        @Override // com.mixpanel.android.java_websocket.client.WebSocketClient
        public void E(Exception exc) {
            if (exc != null && exc.getMessage() != null) {
                MPLog.c("MixpanelAPI.EditorCnctn", "Websocket Error: " + exc.getMessage());
                return;
            }
            MPLog.c("MixpanelAPI.EditorCnctn", "Unknown websocket error occurred");
        }

        @Override // com.mixpanel.android.java_websocket.client.WebSocketClient
        public void G(String str) {
            MPLog.i("MixpanelAPI.EditorCnctn", "Received message from editor:\n" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("type");
                if (string.equals("device_info_request")) {
                    EditorConnection.this.f19468a.e();
                } else if (string.equals("snapshot_request")) {
                    EditorConnection.this.f19468a.a(jSONObject);
                } else if (string.equals("change_request")) {
                    EditorConnection.this.f19468a.c(jSONObject);
                } else if (string.equals("event_binding_request")) {
                    EditorConnection.this.f19468a.f(jSONObject);
                } else if (string.equals("clear_request")) {
                    EditorConnection.this.f19468a.g(jSONObject);
                } else if (string.equals("tweak_request")) {
                    EditorConnection.this.f19468a.d(jSONObject);
                }
            } catch (JSONException e8) {
                MPLog.d("MixpanelAPI.EditorCnctn", "Bad JSON received:" + str, e8);
            }
        }

        @Override // com.mixpanel.android.java_websocket.client.WebSocketClient
        public void I(ServerHandshake serverHandshake) {
            MPLog.i("MixpanelAPI.EditorCnctn", "Websocket connected");
        }
    }

    /* loaded from: classes3.dex */
    public class EditorConnectionException extends IOException {
        public EditorConnectionException(Throwable th) {
            super(th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class WebSocketOutputStream extends OutputStream {
        private WebSocketOutputStream() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws EditorConnectionException {
            try {
                EditorConnection.this.f19469b.J(Framedata.Opcode.TEXT, EditorConnection.f19467d, true);
            } catch (NotSendableException e8) {
                throw new EditorConnectionException(e8);
            } catch (WebsocketNotConnectedException e9) {
                throw new EditorConnectionException(e9);
            }
        }

        @Override // java.io.OutputStream
        public void write(int i8) throws EditorConnectionException {
            write(new byte[]{(byte) i8}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws EditorConnectionException {
            write(bArr, 0, bArr.length);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i8, int i9) throws EditorConnectionException {
            try {
                EditorConnection.this.f19469b.J(Framedata.Opcode.TEXT, ByteBuffer.wrap(bArr, i8, i9), false);
            } catch (NotSendableException e8) {
                throw new EditorConnectionException(e8);
            } catch (WebsocketNotConnectedException e9) {
                throw new EditorConnectionException(e9);
            }
        }
    }

    public EditorConnection(URI uri, Editor editor, Socket socket) throws EditorConnectionException {
        this.f19468a = editor;
        this.f19470c = uri;
        try {
            EditorClient editorClient = new EditorClient(uri, 5000, socket);
            this.f19469b = editorClient;
            editorClient.v();
        } catch (InterruptedException e8) {
            throw new EditorConnectionException(e8);
        }
    }

    public BufferedOutputStream e() {
        return new BufferedOutputStream(new WebSocketOutputStream());
    }

    public boolean f() {
        return this.f19469b.A();
    }

    public boolean g() {
        if (!this.f19469b.x() && !this.f19469b.y() && !this.f19469b.z()) {
            return true;
        }
        return false;
    }
}
