package org.webrtc;

/* loaded from: classes4.dex */
public class StatsReport {
    public final String id;
    public final double timestamp;
    public final String type;
    public final Value[] values;

    /* loaded from: classes4.dex */
    public static class Value {
        public final String name;
        public final String value;

        @CalledByNative("Value")
        public Value(String str, String str2) {
            this.name = str;
            this.value = str2;
        }

        public String toString() {
            return "[" + this.name + ": " + this.value + "]";
        }
    }

    @CalledByNative
    public StatsReport(String str, String str2, double d8, Value[] valueArr) {
        this.id = str;
        this.type = str2;
        this.timestamp = d8;
        this.values = valueArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(this.id);
        sb.append(", type: ");
        sb.append(this.type);
        sb.append(", timestamp: ");
        sb.append(this.timestamp);
        sb.append(", values: ");
        int i8 = 0;
        while (true) {
            Value[] valueArr = this.values;
            if (i8 >= valueArr.length) {
                return sb.toString();
            }
            sb.append(valueArr[i8].toString());
            sb.append(", ");
            i8++;
        }
    }
}
