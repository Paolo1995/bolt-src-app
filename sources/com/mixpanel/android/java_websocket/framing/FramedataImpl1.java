package com.mixpanel.android.java_websocket.framing;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.util.Charsetfunctions;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class FramedataImpl1 implements FrameBuilder {

    /* renamed from: e  reason: collision with root package name */
    protected static byte[] f19039e = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    protected boolean f19040a;

    /* renamed from: b  reason: collision with root package name */
    protected Framedata.Opcode f19041b;

    /* renamed from: c  reason: collision with root package name */
    private ByteBuffer f19042c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f19043d;

    public FramedataImpl1() {
    }

    @Override // com.mixpanel.android.java_websocket.framing.Framedata
    public boolean a() {
        return this.f19043d;
    }

    @Override // com.mixpanel.android.java_websocket.framing.Framedata
    public Framedata.Opcode b() {
        return this.f19041b;
    }

    @Override // com.mixpanel.android.java_websocket.framing.FrameBuilder
    public void c(boolean z7) {
        this.f19040a = z7;
    }

    @Override // com.mixpanel.android.java_websocket.framing.Framedata
    public boolean d() {
        return this.f19040a;
    }

    @Override // com.mixpanel.android.java_websocket.framing.Framedata
    public ByteBuffer f() {
        return this.f19042c;
    }

    @Override // com.mixpanel.android.java_websocket.framing.FrameBuilder
    public void g(Framedata.Opcode opcode) {
        this.f19041b = opcode;
    }

    @Override // com.mixpanel.android.java_websocket.framing.FrameBuilder
    public void h(ByteBuffer byteBuffer) throws InvalidDataException {
        this.f19042c = byteBuffer;
    }

    public String toString() {
        return "Framedata{ optcode:" + b() + ", fin:" + d() + ", payloadlength:[pos:" + this.f19042c.position() + ", len:" + this.f19042c.remaining() + "], payload:" + Arrays.toString(Charsetfunctions.d(new String(this.f19042c.array()))) + "}";
    }

    public FramedataImpl1(Framedata.Opcode opcode) {
        this.f19041b = opcode;
        this.f19042c = ByteBuffer.wrap(f19039e);
    }

    public FramedataImpl1(Framedata framedata) {
        this.f19040a = framedata.d();
        this.f19041b = framedata.b();
        this.f19042c = framedata.f();
        this.f19043d = framedata.a();
    }
}
