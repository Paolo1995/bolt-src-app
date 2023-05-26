package org.webrtc;

/* loaded from: classes4.dex */
public class Size {
    public int height;
    public int width;

    public Size(int i8, int i9) {
        this.width = i8;
        this.height = i9;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Size) {
            Size size = (Size) obj;
            return this.width == size.width && this.height == size.height;
        }
        return false;
    }

    public int hashCode() {
        return (this.width * 65537) + 1 + this.height;
    }

    public String toString() {
        return this.width + "x" + this.height;
    }
}
