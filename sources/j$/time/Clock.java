package j$.time;

/* loaded from: classes2.dex */
public abstract class Clock {
    public static Clock systemUTC() {
        return new c(ZoneOffset.UTC);
    }

    public long a() {
        return instant().toEpochMilli();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public abstract Instant instant();
}
