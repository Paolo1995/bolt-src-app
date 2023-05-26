package org.slf4j.event;

/* loaded from: classes5.dex */
public enum Level {
    ERROR(40, "ERROR"),
    WARN(30, "WARN"),
    INFO(20, "INFO"),
    DEBUG(10, "DEBUG"),
    TRACE(0, "TRACE");
    

    /* renamed from: f  reason: collision with root package name */
    private int f52828f;

    /* renamed from: g  reason: collision with root package name */
    private String f52829g;

    Level(int i8, String str) {
        this.f52828f = i8;
        this.f52829g = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f52829g;
    }
}
