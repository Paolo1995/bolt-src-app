package com.hivemq.client.internal.mqtt.handler.publish.outgoing;

import com.hivemq.client.internal.mqtt.datatypes.MqttTopicImpl;
import com.hivemq.client.internal.mqtt.handler.publish.outgoing.MqttTopicAliasAutoMapping;
import com.hivemq.client.internal.util.collections.Index;
import j$.util.function.Function;
import okhttp3.internal.http2.Settings;

/* loaded from: classes3.dex */
public class MqttTopicAliasAutoMapping implements MqttTopicAliasMapping {

    /* renamed from: i  reason: collision with root package name */
    private static final Index.Spec<Entry, String> f18308i = new Index.Spec<>(new Function() { // from class: com.hivemq.client.internal.mqtt.handler.publish.outgoing.e
        @Override // j$.util.function.Function
        public /* synthetic */ Function andThen(Function function) {
            return Function.CC.$default$andThen(this, function);
        }

        @Override // j$.util.function.Function
        public final Object apply(Object obj) {
            String str;
            str = ((MqttTopicAliasAutoMapping.Entry) obj).f18317a;
            return str;
        }

        @Override // j$.util.function.Function
        public /* synthetic */ Function compose(Function function) {
            return Function.CC.$default$compose(this, function);
        }
    });

    /* renamed from: a  reason: collision with root package name */
    private final int f18309a;

    /* renamed from: c  reason: collision with root package name */
    private Entry f18311c;

    /* renamed from: d  reason: collision with root package name */
    private long f18312d;

    /* renamed from: e  reason: collision with root package name */
    private byte f18313e;

    /* renamed from: g  reason: collision with root package name */
    private byte f18315g;

    /* renamed from: b  reason: collision with root package name */
    private final Index<Entry, String> f18310b = new Index<>(f18308i);

    /* renamed from: f  reason: collision with root package name */
    private byte f18314f = 2;

    /* renamed from: h  reason: collision with root package name */
    private byte f18316h = 2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Entry {

        /* renamed from: a  reason: collision with root package name */
        final String f18317a;

        /* renamed from: b  reason: collision with root package name */
        int f18318b = 0;

        /* renamed from: c  reason: collision with root package name */
        private long f18319c = 1;

        /* renamed from: d  reason: collision with root package name */
        private long f18320d;

        /* renamed from: e  reason: collision with root package name */
        Entry f18321e;

        /* renamed from: f  reason: collision with root package name */
        Entry f18322f;

        Entry(String str, long j8) {
            this.f18317a = str;
            this.f18320d = j8;
        }

        void a(long j8) {
            this.f18318b &= Settings.DEFAULT_INITIAL_WINDOW_SIZE;
            this.f18319c = b(j8) + 1;
            this.f18320d = j8;
        }

        long b(long j8) {
            return Math.max(this.f18319c - Math.max((j8 - this.f18320d) - 8, 0L), 0L);
        }

        void c(int i8) {
            this.f18318b = i8 | 65536;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("{topic='");
            sb.append(this.f18317a);
            sb.append('\'');
            String str2 = "";
            if (this.f18318b == 0) {
                str = "";
            } else {
                str = ", alias=" + (this.f18318b & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            }
            sb.append(str);
            if ((this.f18318b & 65536) != 0) {
                str2 = ", new ";
            }
            sb.append(str2);
            sb.append(", used = ");
            sb.append(this.f18319c);
            sb.append(", access = ");
            sb.append(this.f18320d);
            sb.append('}');
            return sb.toString();
        }
    }

    public MqttTopicAliasAutoMapping(int i8) {
        this.f18309a = i8;
    }

    private void e(Entry entry, long j8) {
        Entry entry2 = entry.f18321e;
        if (entry2 == null) {
            return;
        }
        Entry entry3 = entry.f18322f;
        long b8 = entry.b(j8);
        while (entry2.b(j8) < b8) {
            if (entry.f18318b == 0 && entry2.f18318b != 0) {
                byte b9 = (byte) (this.f18313e + 1);
                this.f18313e = b9;
                byte b10 = this.f18314f;
                if (b9 >= b10) {
                    this.f18313e = (byte) 0;
                    if (b10 < 126) {
                        this.f18314f = (byte) (b10 + ((byte) Math.min(2, 126 - b10)));
                    }
                    entry.c(entry2.f18318b);
                    entry2.f18318b = 0;
                } else {
                    return;
                }
            }
            Entry entry4 = entry2.f18321e;
            entry2.f18321e = entry;
            entry.f18322f = entry2;
            if (entry3 == null) {
                entry2.f18322f = null;
                this.f18311c = entry2;
            } else {
                entry3.f18321e = entry2;
                entry2.f18322f = entry3;
            }
            if (entry4 == null) {
                entry.f18321e = null;
                return;
            }
            entry.f18321e = entry4;
            entry4.f18322f = entry;
            entry3 = entry2;
            entry2 = entry4;
        }
    }

    @Override // com.hivemq.client.internal.mqtt.handler.publish.outgoing.MqttTopicAliasMapping
    public int a() {
        return this.f18309a;
    }

    @Override // com.hivemq.client.internal.mqtt.handler.publish.outgoing.MqttTopicAliasMapping
    public int b(MqttTopicImpl mqttTopicImpl) {
        long j8 = this.f18312d + 1;
        this.f18312d = j8;
        String mqttUtf8StringImpl = mqttTopicImpl.toString();
        Entry g8 = this.f18310b.g(mqttUtf8StringImpl);
        if (g8 != null) {
            g8.a(j8);
            if (g8.f18318b != 0) {
                byte b8 = this.f18314f;
                if (b8 > 2) {
                    this.f18314f = (byte) (b8 - 1);
                }
                byte b9 = this.f18316h;
                if (b9 > 2) {
                    this.f18316h = (byte) (b9 - 1);
                }
                Entry entry = g8.f18322f;
                if (entry != null) {
                    if (entry.f18318b == 0) {
                        this.f18313e = (byte) 0;
                    }
                } else {
                    this.f18315g = (byte) 0;
                }
            }
            e(g8, j8);
            return g8.f18318b;
        }
        Entry entry2 = new Entry(mqttUtf8StringImpl, j8);
        if (this.f18310b.m() < this.f18309a + 4) {
            if (this.f18310b.m() < this.f18309a) {
                entry2.c(this.f18310b.m() + 1);
            }
            this.f18310b.h(entry2);
            Entry entry3 = this.f18311c;
            if (entry3 != null) {
                entry2.f18321e = entry3;
                entry3.f18322f = entry2;
            }
        } else {
            Entry entry4 = this.f18311c;
            if (entry2.b(j8) <= entry4.b(j8)) {
                return 0;
            }
            byte b10 = (byte) (this.f18315g + 1);
            this.f18315g = b10;
            byte b11 = this.f18316h;
            if (b10 < b11) {
                return 0;
            }
            this.f18315g = (byte) 0;
            if (b11 < 126) {
                this.f18316h = (byte) (b11 + ((byte) Math.min(2, 126 - b11)));
            }
            int i8 = entry4.f18318b;
            if (i8 != 0) {
                entry2.c(i8);
            }
            this.f18310b.j(entry4.f18317a);
            this.f18310b.h(entry2);
            Entry entry5 = entry4.f18321e;
            entry2.f18321e = entry5;
            if (entry5 != null) {
                entry5.f18322f = entry2;
            }
        }
        this.f18311c = entry2;
        e(entry2, j8);
        return entry2.f18318b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Entry entry = this.f18311c; entry != null; entry = entry.f18321e) {
            sb.append("\n  ");
            sb.append(entry);
        }
        sb.append("\n}");
        return sb.toString();
    }
}
