package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes.dex */
public class LazyFieldLite {

    /* renamed from: e  reason: collision with root package name */
    private static final ExtensionRegistryLite f15138e = ExtensionRegistryLite.b();

    /* renamed from: a  reason: collision with root package name */
    private ByteString f15139a;

    /* renamed from: b  reason: collision with root package name */
    private ExtensionRegistryLite f15140b;

    /* renamed from: c  reason: collision with root package name */
    protected volatile MessageLite f15141c;

    /* renamed from: d  reason: collision with root package name */
    private volatile ByteString f15142d;

    protected void a(MessageLite messageLite) {
        if (this.f15141c != null) {
            return;
        }
        synchronized (this) {
            if (this.f15141c != null) {
                return;
            }
            try {
                if (this.f15139a != null) {
                    this.f15141c = messageLite.getParserForType().b(this.f15139a, this.f15140b);
                    this.f15142d = this.f15139a;
                } else {
                    this.f15141c = messageLite;
                    this.f15142d = ByteString.f14989g;
                }
            } catch (InvalidProtocolBufferException unused) {
                this.f15141c = messageLite;
                this.f15142d = ByteString.f14989g;
            }
        }
    }

    public int b() {
        if (this.f15142d != null) {
            return this.f15142d.size();
        }
        ByteString byteString = this.f15139a;
        if (byteString != null) {
            return byteString.size();
        }
        if (this.f15141c != null) {
            return this.f15141c.getSerializedSize();
        }
        return 0;
    }

    public MessageLite c(MessageLite messageLite) {
        a(messageLite);
        return this.f15141c;
    }

    public MessageLite d(MessageLite messageLite) {
        MessageLite messageLite2 = this.f15141c;
        this.f15139a = null;
        this.f15142d = null;
        this.f15141c = messageLite;
        return messageLite2;
    }

    public ByteString e() {
        if (this.f15142d != null) {
            return this.f15142d;
        }
        ByteString byteString = this.f15139a;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            if (this.f15142d != null) {
                return this.f15142d;
            }
            if (this.f15141c == null) {
                this.f15142d = ByteString.f14989g;
            } else {
                this.f15142d = this.f15141c.toByteString();
            }
            return this.f15142d;
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
        MessageLite messageLite = this.f15141c;
        MessageLite messageLite2 = lazyFieldLite.f15141c;
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
