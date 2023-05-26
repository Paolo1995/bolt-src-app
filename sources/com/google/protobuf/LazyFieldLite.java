package com.google.protobuf;

/* loaded from: classes3.dex */
public class LazyFieldLite {

    /* renamed from: e  reason: collision with root package name */
    private static final ExtensionRegistryLite f17485e = ExtensionRegistryLite.b();

    /* renamed from: a  reason: collision with root package name */
    private ByteString f17486a;

    /* renamed from: b  reason: collision with root package name */
    private ExtensionRegistryLite f17487b;

    /* renamed from: c  reason: collision with root package name */
    protected volatile MessageLite f17488c;

    /* renamed from: d  reason: collision with root package name */
    private volatile ByteString f17489d;

    protected void a(MessageLite messageLite) {
        if (this.f17488c != null) {
            return;
        }
        synchronized (this) {
            if (this.f17488c != null) {
                return;
            }
            try {
                if (this.f17486a != null) {
                    this.f17488c = messageLite.getParserForType().a(this.f17486a, this.f17487b);
                    this.f17489d = this.f17486a;
                } else {
                    this.f17488c = messageLite;
                    this.f17489d = ByteString.f17177g;
                }
            } catch (InvalidProtocolBufferException unused) {
                this.f17488c = messageLite;
                this.f17489d = ByteString.f17177g;
            }
        }
    }

    public int b() {
        if (this.f17489d != null) {
            return this.f17489d.size();
        }
        ByteString byteString = this.f17486a;
        if (byteString != null) {
            return byteString.size();
        }
        if (this.f17488c != null) {
            return this.f17488c.getSerializedSize();
        }
        return 0;
    }

    public MessageLite c(MessageLite messageLite) {
        a(messageLite);
        return this.f17488c;
    }

    public MessageLite d(MessageLite messageLite) {
        MessageLite messageLite2 = this.f17488c;
        this.f17486a = null;
        this.f17489d = null;
        this.f17488c = messageLite;
        return messageLite2;
    }

    public ByteString e() {
        if (this.f17489d != null) {
            return this.f17489d;
        }
        ByteString byteString = this.f17486a;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            if (this.f17489d != null) {
                return this.f17489d;
            }
            if (this.f17488c == null) {
                this.f17489d = ByteString.f17177g;
            } else {
                this.f17489d = this.f17488c.toByteString();
            }
            return this.f17489d;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyFieldLite)) {
            return false;
        }
        LazyFieldLite lazyFieldLite = (LazyFieldLite) obj;
        MessageLite messageLite = this.f17488c;
        MessageLite messageLite2 = lazyFieldLite.f17488c;
        if (messageLite == null && messageLite2 == null) {
            return e().equals(lazyFieldLite.e());
        }
        if (messageLite != null && messageLite2 != null) {
            return messageLite.equals(messageLite2);
        }
        if (messageLite != null) {
            return messageLite.equals(lazyFieldLite.c(messageLite.getDefaultInstanceForType()));
        }
        return c(messageLite2.getDefaultInstanceForType()).equals(messageLite2);
    }

    public int hashCode() {
        return 1;
    }
}
