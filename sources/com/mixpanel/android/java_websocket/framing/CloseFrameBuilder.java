package com.mixpanel.android.java_websocket.framing;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidFrameException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.util.Charsetfunctions;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class CloseFrameBuilder extends FramedataImpl1 implements CloseFrame {

    /* renamed from: h  reason: collision with root package name */
    static final ByteBuffer f19029h = ByteBuffer.allocate(0);

    /* renamed from: f  reason: collision with root package name */
    private int f19030f;

    /* renamed from: g  reason: collision with root package name */
    private String f19031g;

    public CloseFrameBuilder() {
        super(Framedata.Opcode.CLOSING);
        c(true);
    }

    private void i() throws InvalidFrameException {
        this.f19030f = 1005;
        ByteBuffer f8 = super.f();
        f8.mark();
        if (f8.remaining() >= 2) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.position(2);
            allocate.putShort(f8.getShort());
            allocate.position(0);
            int i8 = allocate.getInt();
            this.f19030f = i8;
            if (i8 == 1006 || i8 == 1015 || i8 == 1005 || i8 > 4999 || i8 < 1000 || i8 == 1004) {
                throw new InvalidFrameException("closecode must not be sent over the wire: " + this.f19030f);
            }
        }
        f8.reset();
    }

    private void j() throws InvalidDataException {
        if (this.f19030f == 1005) {
            this.f19031g = Charsetfunctions.c(super.f());
            return;
        }
        ByteBuffer f8 = super.f();
        int position = f8.position();
        try {
            try {
                f8.position(f8.position() + 2);
                this.f19031g = Charsetfunctions.c(f8);
            } catch (IllegalArgumentException e8) {
                throw new InvalidFrameException(e8);
            }
        } finally {
            f8.position(position);
        }
    }

    private void k(int i8, String str) throws InvalidDataException {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (i8 == 1015) {
            i8 = 1005;
        } else {
            str2 = str;
        }
        if (i8 == 1005) {
            if (str2.length() <= 0) {
                return;
            }
            throw new InvalidDataException(1002, "A close frame must have a closecode if it has a reason");
        }
        byte[] d8 = Charsetfunctions.d(str2);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i8);
        allocate.position(2);
        ByteBuffer allocate2 = ByteBuffer.allocate(d8.length + 2);
        allocate2.put(allocate);
        allocate2.put(d8);
        allocate2.rewind();
        h(allocate2);
    }

    @Override // com.mixpanel.android.java_websocket.framing.CloseFrame
    public int e() {
        return this.f19030f;
    }

    @Override // com.mixpanel.android.java_websocket.framing.FramedataImpl1, com.mixpanel.android.java_websocket.framing.Framedata
    public ByteBuffer f() {
        if (this.f19030f == 1005) {
            return f19029h;
        }
        return super.f();
    }

    @Override // com.mixpanel.android.java_websocket.framing.CloseFrame
    public String getMessage() {
        return this.f19031g;
    }

    @Override // com.mixpanel.android.java_websocket.framing.FramedataImpl1, com.mixpanel.android.java_websocket.framing.FrameBuilder
    public void h(ByteBuffer byteBuffer) throws InvalidDataException {
        super.h(byteBuffer);
        i();
        j();
    }

    @Override // com.mixpanel.android.java_websocket.framing.FramedataImpl1
    public String toString() {
        return super.toString() + "code: " + this.f19030f;
    }

    public CloseFrameBuilder(int i8) throws InvalidDataException {
        super(Framedata.Opcode.CLOSING);
        c(true);
        k(i8, "");
    }

    public CloseFrameBuilder(int i8, String str) throws InvalidDataException {
        super(Framedata.Opcode.CLOSING);
        c(true);
        k(i8, str);
    }
}
