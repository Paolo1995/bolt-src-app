package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.DeepRecursiveFunction;
import kotlin.DeepRecursiveKt;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: JsonTreeReader.kt */
/* loaded from: classes5.dex */
public final class JsonTreeReader {

    /* renamed from: a  reason: collision with root package name */
    private final AbstractJsonLexer f52408a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f52409b;

    /* renamed from: c  reason: collision with root package name */
    private int f52410c;

    public JsonTreeReader(JsonConfiguration configuration, AbstractJsonLexer lexer) {
        Intrinsics.f(configuration, "configuration");
        Intrinsics.f(lexer, "lexer");
        this.f52408a = lexer;
        this.f52409b = configuration.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonElement f() {
        boolean z7;
        int i8;
        byte m8 = this.f52408a.m();
        if (this.f52408a.E() != 4) {
            ArrayList arrayList = new ArrayList();
            while (this.f52408a.f()) {
                arrayList.add(e());
                m8 = this.f52408a.m();
                if (m8 != 4) {
                    AbstractJsonLexer abstractJsonLexer = this.f52408a;
                    if (m8 == 9) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    i8 = abstractJsonLexer.f52364a;
                    if (!z7) {
                        AbstractJsonLexer.y(abstractJsonLexer, "Expected end of the array or comma", i8, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                }
            }
            if (m8 == 8) {
                this.f52408a.n((byte) 9);
            } else if (m8 == 4) {
                AbstractJsonLexer.y(this.f52408a, "Unexpected trailing comma", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            return new JsonArray(arrayList);
        }
        AbstractJsonLexer.y(this.f52408a, "Unexpected leading comma", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final JsonElement g() {
        return (JsonElement) DeepRecursiveKt.b(new DeepRecursiveFunction(new JsonTreeReader$readDeepRecursive$1(this, null)), Unit.f50853a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x009c -> B:27:0x00a6). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(kotlin.DeepRecursiveScope<kotlin.Unit, kotlinx.serialization.json.JsonElement> r21, kotlin.coroutines.Continuation<? super kotlinx.serialization.json.JsonElement> r22) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.JsonTreeReader.h(kotlin.DeepRecursiveScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final JsonElement i() {
        String q8;
        byte n8 = this.f52408a.n((byte) 6);
        if (this.f52408a.E() != 4) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (true) {
                if (!this.f52408a.f()) {
                    break;
                }
                if (this.f52409b) {
                    q8 = this.f52408a.s();
                } else {
                    q8 = this.f52408a.q();
                }
                this.f52408a.n((byte) 5);
                linkedHashMap.put(q8, e());
                n8 = this.f52408a.m();
                if (n8 != 4) {
                    if (n8 != 7) {
                        AbstractJsonLexer.y(this.f52408a, "Expected end of the object or comma", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    }
                }
            }
            if (n8 == 6) {
                this.f52408a.n((byte) 7);
            } else if (n8 == 4) {
                AbstractJsonLexer.y(this.f52408a, "Unexpected trailing comma", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            return new JsonObject(linkedHashMap);
        }
        AbstractJsonLexer.y(this.f52408a, "Unexpected leading comma", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonPrimitive j(boolean z7) {
        String s7;
        if (!this.f52409b && z7) {
            s7 = this.f52408a.q();
        } else {
            s7 = this.f52408a.s();
        }
        if (!z7 && Intrinsics.a(s7, "null")) {
            return JsonNull.INSTANCE;
        }
        return new JsonLiteral(s7, z7);
    }

    public final JsonElement e() {
        JsonElement i8;
        byte E = this.f52408a.E();
        if (E == 1) {
            return j(true);
        }
        if (E == 0) {
            return j(false);
        }
        if (E == 6) {
            int i9 = this.f52410c + 1;
            this.f52410c = i9;
            if (i9 == 200) {
                i8 = g();
            } else {
                i8 = i();
            }
            this.f52410c--;
            return i8;
        } else if (E == 8) {
            return f();
        } else {
            AbstractJsonLexer.y(this.f52408a, "Cannot begin reading element, unexpected token: " + ((int) E), 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }
}
