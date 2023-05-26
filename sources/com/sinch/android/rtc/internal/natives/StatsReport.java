package com.sinch.android.rtc.internal.natives;

/* loaded from: classes3.dex */
public class StatsReport {
    public final String id;
    public final double timestamp;
    public final String type;
    public final Value[] values;

    /* loaded from: classes3.dex */
    public static class Value {
        public final String name;
        public final String value;

        public Value(String str, String str2) {
            this.name = str;
            this.value = str2;
        }

        public String toString() {
            return "[" + this.name + ": " + this.value + "]";
        }
    }

    public StatsReport(String str, String str2, double d8, Value[] valueArr) {
        this.id = str;
        this.type = str2;
        this.timestamp = d8;
        this.values = valueArr;
    }

    public String getValue(String str) {
        int i8 = 0;
        while (true) {
            Value[] valueArr = this.values;
            if (i8 >= valueArr.length) {
                return null;
            }
            if (valueArr[i8].name.equalsIgnoreCase(str)) {
                return this.values[i8].value;
            }
            i8++;
        }
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
