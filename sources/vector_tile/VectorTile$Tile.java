package vector_tile;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes4.dex */
public final class VectorTile$Tile extends GeneratedMessageLite.ExtendableMessage<VectorTile$Tile, Builder> {
    private static final VectorTile$Tile DEFAULT_INSTANCE;
    public static final int LAYERS_FIELD_NUMBER = 3;
    private static volatile Parser<VectorTile$Tile> PARSER;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<Layer> layers_ = GeneratedMessageLite.emptyProtobufList();

    /* loaded from: classes4.dex */
    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<VectorTile$Tile, Builder> {
        private Builder() {
            super(VectorTile$Tile.DEFAULT_INSTANCE);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Feature extends GeneratedMessageLite<Feature, Builder> implements FeatureOrBuilder {
        private static final Feature DEFAULT_INSTANCE;
        public static final int GEOMETRY_FIELD_NUMBER = 4;
        public static final int ID_FIELD_NUMBER = 1;
        private static volatile Parser<Feature> PARSER = null;
        public static final int TAGS_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 3;
        private int bitField0_;
        private long id_;
        private int type_;
        private int tagsMemoizedSerializedSize = -1;
        private int geometryMemoizedSerializedSize = -1;
        private Internal.IntList tags_ = GeneratedMessageLite.emptyIntList();
        private Internal.IntList geometry_ = GeneratedMessageLite.emptyIntList();

        /* loaded from: classes4.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Feature, Builder> implements FeatureOrBuilder {
            private Builder() {
                super(Feature.DEFAULT_INSTANCE);
            }
        }

        static {
            Feature feature = new Feature();
            DEFAULT_INSTANCE = feature;
            GeneratedMessageLite.registerDefaultInstance(Feature.class, feature);
        }

        private Feature() {
        }

        private void addAllGeometry(Iterable<? extends Integer> iterable) {
            ensureGeometryIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.geometry_);
        }

        private void addAllTags(Iterable<? extends Integer> iterable) {
            ensureTagsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.tags_);
        }

        private void addGeometry(int i8) {
            ensureGeometryIsMutable();
            this.geometry_.s0(i8);
        }

        private void addTags(int i8) {
            ensureTagsIsMutable();
            this.tags_.s0(i8);
        }

        private void clearGeometry() {
            this.geometry_ = GeneratedMessageLite.emptyIntList();
        }

        private void clearId() {
            this.bitField0_ &= -2;
            this.id_ = 0L;
        }

        private void clearTags() {
            this.tags_ = GeneratedMessageLite.emptyIntList();
        }

        private void clearType() {
            this.bitField0_ &= -3;
            this.type_ = 0;
        }

        private void ensureGeometryIsMutable() {
            Internal.IntList intList = this.geometry_;
            if (!intList.h()) {
                this.geometry_ = GeneratedMessageLite.mutableCopy(intList);
            }
        }

        private void ensureTagsIsMutable() {
            Internal.IntList intList = this.tags_;
            if (!intList.h()) {
                this.tags_ = GeneratedMessageLite.mutableCopy(intList);
            }
        }

        public static Feature getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Feature parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Feature) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Feature parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Feature) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<Feature> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        private void setGeometry(int i8, int i9) {
            ensureGeometryIsMutable();
            this.geometry_.q(i8, i9);
        }

        private void setId(long j8) {
            this.bitField0_ |= 1;
            this.id_ = j8;
        }

        private void setTags(int i8, int i9) {
            ensureTagsIsMutable();
            this.tags_.q(i8, i9);
        }

        private void setType(GeomType geomType) {
            this.type_ = geomType.getNumber();
            this.bitField0_ |= 2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (VectorTile$1.f53130a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Feature();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဃ\u0000\u0002+\u0003ဌ\u0001\u0004+", new Object[]{"bitField0_", "id_", "tags_", "type_", GeomType.c(), "geometry_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Feature> parser = PARSER;
                    if (parser == null) {
                        synchronized (Feature.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public int getGeometry(int i8) {
            return this.geometry_.getInt(i8);
        }

        public int getGeometryCount() {
            return this.geometry_.size();
        }

        public List<Integer> getGeometryList() {
            return this.geometry_;
        }

        public long getId() {
            return this.id_;
        }

        public int getTags(int i8) {
            return this.tags_.getInt(i8);
        }

        public int getTagsCount() {
            return this.tags_.size();
        }

        public List<Integer> getTagsList() {
            return this.tags_;
        }

        public GeomType getType() {
            GeomType a8 = GeomType.a(this.type_);
            if (a8 == null) {
                return GeomType.UNKNOWN;
            }
            return a8;
        }

        public boolean hasId() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasType() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(Feature feature) {
            return DEFAULT_INSTANCE.createBuilder(feature);
        }

        public static Feature parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Feature) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Feature parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Feature) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Feature parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Feature) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Feature parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Feature) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Feature parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Feature) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Feature parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Feature) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Feature parseFrom(InputStream inputStream) throws IOException {
            return (Feature) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Feature parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Feature) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Feature parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Feature) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Feature parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Feature) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes4.dex */
    public interface FeatureOrBuilder extends MessageLiteOrBuilder {
    }

    /* loaded from: classes4.dex */
    public enum GeomType implements Internal.EnumLite {
        UNKNOWN(0),
        POINT(1),
        LINESTRING(2),
        POLYGON(3);
        

        /* renamed from: k  reason: collision with root package name */
        private static final Internal.EnumLiteMap<GeomType> f53135k = new Internal.EnumLiteMap<GeomType>() { // from class: vector_tile.VectorTile.Tile.GeomType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* renamed from: b */
            public GeomType a(int i8) {
                return GeomType.a(i8);
            }
        };

        /* renamed from: f  reason: collision with root package name */
        private final int f53137f;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes4.dex */
        public static final class GeomTypeVerifier implements Internal.EnumVerifier {

            /* renamed from: a  reason: collision with root package name */
            static final Internal.EnumVerifier f53138a = new GeomTypeVerifier();

            private GeomTypeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean a(int i8) {
                if (GeomType.a(i8) != null) {
                    return true;
                }
                return false;
            }
        }

        GeomType(int i8) {
            this.f53137f = i8;
        }

        public static GeomType a(int i8) {
            if (i8 != 0) {
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 != 3) {
                            return null;
                        }
                        return POLYGON;
                    }
                    return LINESTRING;
                }
                return POINT;
            }
            return UNKNOWN;
        }

        public static Internal.EnumVerifier c() {
            return GeomTypeVerifier.f53138a;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.f53137f;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Layer extends GeneratedMessageLite.ExtendableMessage<Layer, Builder> implements LayerOrBuilder {
        private static final Layer DEFAULT_INSTANCE;
        public static final int EXTENT_FIELD_NUMBER = 5;
        public static final int FEATURES_FIELD_NUMBER = 2;
        public static final int KEYS_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 1;
        private static volatile Parser<Layer> PARSER = null;
        public static final int VALUES_FIELD_NUMBER = 4;
        public static final int VERSION_FIELD_NUMBER = 15;
        private int bitField0_;
        private byte memoizedIsInitialized = 2;
        private int version_ = 1;
        private String name_ = "";
        private Internal.ProtobufList<Feature> features_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> keys_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<Value> values_ = GeneratedMessageLite.emptyProtobufList();
        private int extent_ = 4096;

        /* loaded from: classes4.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Layer, Builder> implements LayerOrBuilder {
            private Builder() {
                super(Layer.DEFAULT_INSTANCE);
            }
        }

        static {
            Layer layer = new Layer();
            DEFAULT_INSTANCE = layer;
            GeneratedMessageLite.registerDefaultInstance(Layer.class, layer);
        }

        private Layer() {
        }

        private void addAllFeatures(Iterable<? extends Feature> iterable) {
            ensureFeaturesIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.features_);
        }

        private void addAllKeys(Iterable<String> iterable) {
            ensureKeysIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.keys_);
        }

        private void addAllValues(Iterable<? extends Value> iterable) {
            ensureValuesIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.values_);
        }

        private void addFeatures(Feature feature) {
            feature.getClass();
            ensureFeaturesIsMutable();
            this.features_.add(feature);
        }

        private void addKeys(String str) {
            str.getClass();
            ensureKeysIsMutable();
            this.keys_.add(str);
        }

        private void addKeysBytes(ByteString byteString) {
            ensureKeysIsMutable();
            this.keys_.add(byteString.L());
        }

        private void addValues(Value value) {
            value.getClass();
            ensureValuesIsMutable();
            this.values_.add(value);
        }

        private void clearExtent() {
            this.bitField0_ &= -5;
            this.extent_ = 4096;
        }

        private void clearFeatures() {
            this.features_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void clearKeys() {
            this.keys_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void clearName() {
            this.bitField0_ &= -3;
            this.name_ = getDefaultInstance().getName();
        }

        private void clearValues() {
            this.values_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void clearVersion() {
            this.bitField0_ &= -2;
            this.version_ = 1;
        }

        private void ensureFeaturesIsMutable() {
            Internal.ProtobufList<Feature> protobufList = this.features_;
            if (!protobufList.h()) {
                this.features_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
        }

        private void ensureKeysIsMutable() {
            Internal.ProtobufList<String> protobufList = this.keys_;
            if (!protobufList.h()) {
                this.keys_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
        }

        private void ensureValuesIsMutable() {
            Internal.ProtobufList<Value> protobufList = this.values_;
            if (!protobufList.h()) {
                this.values_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
        }

        public static Layer getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Layer parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Layer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Layer parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Layer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<Layer> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        private void removeFeatures(int i8) {
            ensureFeaturesIsMutable();
            this.features_.remove(i8);
        }

        private void removeValues(int i8) {
            ensureValuesIsMutable();
            this.values_.remove(i8);
        }

        private void setExtent(int i8) {
            this.bitField0_ |= 4;
            this.extent_ = i8;
        }

        private void setFeatures(int i8, Feature feature) {
            feature.getClass();
            ensureFeaturesIsMutable();
            this.features_.set(i8, feature);
        }

        private void setKeys(int i8, String str) {
            str.getClass();
            ensureKeysIsMutable();
            this.keys_.set(i8, str);
        }

        private void setName(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.name_ = str;
        }

        private void setNameBytes(ByteString byteString) {
            this.name_ = byteString.L();
            this.bitField0_ |= 2;
        }

        private void setValues(int i8, Value value) {
            value.getClass();
            ensureValuesIsMutable();
            this.values_.set(i8, value);
        }

        private void setVersion(int i8) {
            this.bitField0_ |= 1;
            this.version_ = i8;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i8 = 1;
            switch (VectorTile$1.f53130a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Layer();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u000f\u0006\u0000\u0003\u0003\u0001ᔈ\u0001\u0002\u001b\u0003\u001a\u0004Л\u0005ဋ\u0002\u000fᔋ\u0000", new Object[]{"bitField0_", "name_", "features_", Feature.class, "keys_", "values_", Value.class, "extent_", "version_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Layer> parser = PARSER;
                    if (parser == null) {
                        synchronized (Layer.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    if (obj == null) {
                        i8 = 0;
                    }
                    this.memoizedIsInitialized = (byte) i8;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public int getExtent() {
            return this.extent_;
        }

        public Feature getFeatures(int i8) {
            return this.features_.get(i8);
        }

        public int getFeaturesCount() {
            return this.features_.size();
        }

        public List<Feature> getFeaturesList() {
            return this.features_;
        }

        public FeatureOrBuilder getFeaturesOrBuilder(int i8) {
            return this.features_.get(i8);
        }

        public List<? extends FeatureOrBuilder> getFeaturesOrBuilderList() {
            return this.features_;
        }

        public String getKeys(int i8) {
            return this.keys_.get(i8);
        }

        public ByteString getKeysBytes(int i8) {
            return ByteString.r(this.keys_.get(i8));
        }

        public int getKeysCount() {
            return this.keys_.size();
        }

        public List<String> getKeysList() {
            return this.keys_;
        }

        public String getName() {
            return this.name_;
        }

        public ByteString getNameBytes() {
            return ByteString.r(this.name_);
        }

        public Value getValues(int i8) {
            return this.values_.get(i8);
        }

        public int getValuesCount() {
            return this.values_.size();
        }

        public List<Value> getValuesList() {
            return this.values_;
        }

        public ValueOrBuilder getValuesOrBuilder(int i8) {
            return this.values_.get(i8);
        }

        public List<? extends ValueOrBuilder> getValuesOrBuilderList() {
            return this.values_;
        }

        public int getVersion() {
            return this.version_;
        }

        public boolean hasExtent() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasVersion() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(Layer layer) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(layer);
        }

        public static Layer parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Layer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Layer parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Layer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Layer parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Layer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        private void addFeatures(int i8, Feature feature) {
            feature.getClass();
            ensureFeaturesIsMutable();
            this.features_.add(i8, feature);
        }

        private void addValues(int i8, Value value) {
            value.getClass();
            ensureValuesIsMutable();
            this.values_.add(i8, value);
        }

        public static Layer parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Layer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Layer parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Layer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Layer parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Layer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Layer parseFrom(InputStream inputStream) throws IOException {
            return (Layer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Layer parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Layer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Layer parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Layer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Layer parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Layer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes4.dex */
    public interface LayerOrBuilder extends MessageLiteOrBuilder {
    }

    /* loaded from: classes4.dex */
    public static final class Value extends GeneratedMessageLite.ExtendableMessage<Value, Builder> implements ValueOrBuilder {
        public static final int BOOL_VALUE_FIELD_NUMBER = 7;
        private static final Value DEFAULT_INSTANCE;
        public static final int DOUBLE_VALUE_FIELD_NUMBER = 3;
        public static final int FLOAT_VALUE_FIELD_NUMBER = 2;
        public static final int INT_VALUE_FIELD_NUMBER = 4;
        private static volatile Parser<Value> PARSER = null;
        public static final int SINT_VALUE_FIELD_NUMBER = 6;
        public static final int STRING_VALUE_FIELD_NUMBER = 1;
        public static final int UINT_VALUE_FIELD_NUMBER = 5;
        private int bitField0_;
        private boolean boolValue_;
        private double doubleValue_;
        private float floatValue_;
        private long intValue_;
        private long sintValue_;
        private long uintValue_;
        private byte memoizedIsInitialized = 2;
        private String stringValue_ = "";

        /* loaded from: classes4.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Value, Builder> implements ValueOrBuilder {
            private Builder() {
                super(Value.DEFAULT_INSTANCE);
            }
        }

        static {
            Value value = new Value();
            DEFAULT_INSTANCE = value;
            GeneratedMessageLite.registerDefaultInstance(Value.class, value);
        }

        private Value() {
        }

        private void clearBoolValue() {
            this.bitField0_ &= -65;
            this.boolValue_ = false;
        }

        private void clearDoubleValue() {
            this.bitField0_ &= -5;
            this.doubleValue_ = 0.0d;
        }

        private void clearFloatValue() {
            this.bitField0_ &= -3;
            this.floatValue_ = 0.0f;
        }

        private void clearIntValue() {
            this.bitField0_ &= -9;
            this.intValue_ = 0L;
        }

        private void clearSintValue() {
            this.bitField0_ &= -33;
            this.sintValue_ = 0L;
        }

        private void clearStringValue() {
            this.bitField0_ &= -2;
            this.stringValue_ = getDefaultInstance().getStringValue();
        }

        private void clearUintValue() {
            this.bitField0_ &= -17;
            this.uintValue_ = 0L;
        }

        public static Value getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Value parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Value) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Value parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<Value> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        private void setBoolValue(boolean z7) {
            this.bitField0_ |= 64;
            this.boolValue_ = z7;
        }

        private void setDoubleValue(double d8) {
            this.bitField0_ |= 4;
            this.doubleValue_ = d8;
        }

        private void setFloatValue(float f8) {
            this.bitField0_ |= 2;
            this.floatValue_ = f8;
        }

        private void setIntValue(long j8) {
            this.bitField0_ |= 8;
            this.intValue_ = j8;
        }

        private void setSintValue(long j8) {
            this.bitField0_ |= 32;
            this.sintValue_ = j8;
        }

        private void setStringValue(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.stringValue_ = str;
        }

        private void setStringValueBytes(ByteString byteString) {
            this.stringValue_ = byteString.L();
            this.bitField0_ |= 1;
        }

        private void setUintValue(long j8) {
            this.bitField0_ |= 16;
            this.uintValue_ = j8;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i8 = 1;
            switch (VectorTile$1.f53130a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Value();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ခ\u0001\u0003က\u0002\u0004ဂ\u0003\u0005ဃ\u0004\u0006တ\u0005\u0007ဇ\u0006", new Object[]{"bitField0_", "stringValue_", "floatValue_", "doubleValue_", "intValue_", "uintValue_", "sintValue_", "boolValue_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Value> parser = PARSER;
                    if (parser == null) {
                        synchronized (Value.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    if (obj == null) {
                        i8 = 0;
                    }
                    this.memoizedIsInitialized = (byte) i8;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public boolean getBoolValue() {
            return this.boolValue_;
        }

        public double getDoubleValue() {
            return this.doubleValue_;
        }

        public float getFloatValue() {
            return this.floatValue_;
        }

        public long getIntValue() {
            return this.intValue_;
        }

        public long getSintValue() {
            return this.sintValue_;
        }

        public String getStringValue() {
            return this.stringValue_;
        }

        public ByteString getStringValueBytes() {
            return ByteString.r(this.stringValue_);
        }

        public long getUintValue() {
            return this.uintValue_;
        }

        public boolean hasBoolValue() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasDoubleValue() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasFloatValue() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasIntValue() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasSintValue() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasStringValue() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasUintValue() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(Value value) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(value);
        }

        public static Value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Value) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Value parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Value parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Value parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Value parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Value parseFrom(InputStream inputStream) throws IOException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Value parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes4.dex */
    public interface ValueOrBuilder extends MessageLiteOrBuilder {
    }

    static {
        VectorTile$Tile vectorTile$Tile = new VectorTile$Tile();
        DEFAULT_INSTANCE = vectorTile$Tile;
        GeneratedMessageLite.registerDefaultInstance(VectorTile$Tile.class, vectorTile$Tile);
    }

    private VectorTile$Tile() {
    }

    private void addAllLayers(Iterable<? extends Layer> iterable) {
        ensureLayersIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.layers_);
    }

    private void addLayers(Layer layer) {
        layer.getClass();
        ensureLayersIsMutable();
        this.layers_.add(layer);
    }

    private void clearLayers() {
        this.layers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureLayersIsMutable() {
        Internal.ProtobufList<Layer> protobufList = this.layers_;
        if (!protobufList.h()) {
            this.layers_ = GeneratedMessageLite.mutableCopy(protobufList);
        }
    }

    public static VectorTile$Tile getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static VectorTile$Tile parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (VectorTile$Tile) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VectorTile$Tile parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (VectorTile$Tile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<VectorTile$Tile> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeLayers(int i8) {
        ensureLayersIsMutable();
        this.layers_.remove(i8);
    }

    private void setLayers(int i8, Layer layer) {
        layer.getClass();
        ensureLayersIsMutable();
        this.layers_.set(i8, layer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i8 = 1;
        switch (VectorTile$1.f53130a[methodToInvoke.ordinal()]) {
            case 1:
                return new VectorTile$Tile();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0003\u0003\u0001\u0000\u0001\u0001\u0003Л", new Object[]{"layers_", Layer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<VectorTile$Tile> parser = PARSER;
                if (parser == null) {
                    synchronized (VectorTile$Tile.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return Byte.valueOf(this.memoizedIsInitialized);
            case 7:
                if (obj == null) {
                    i8 = 0;
                }
                this.memoizedIsInitialized = (byte) i8;
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public Layer getLayers(int i8) {
        return this.layers_.get(i8);
    }

    public int getLayersCount() {
        return this.layers_.size();
    }

    public List<Layer> getLayersList() {
        return this.layers_;
    }

    public LayerOrBuilder getLayersOrBuilder(int i8) {
        return this.layers_.get(i8);
    }

    public List<? extends LayerOrBuilder> getLayersOrBuilderList() {
        return this.layers_;
    }

    public static Builder newBuilder(VectorTile$Tile vectorTile$Tile) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(vectorTile$Tile);
    }

    public static VectorTile$Tile parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (VectorTile$Tile) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static VectorTile$Tile parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (VectorTile$Tile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static VectorTile$Tile parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (VectorTile$Tile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    private void addLayers(int i8, Layer layer) {
        layer.getClass();
        ensureLayersIsMutable();
        this.layers_.add(i8, layer);
    }

    public static VectorTile$Tile parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (VectorTile$Tile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static VectorTile$Tile parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (VectorTile$Tile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VectorTile$Tile parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (VectorTile$Tile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static VectorTile$Tile parseFrom(InputStream inputStream) throws IOException {
        return (VectorTile$Tile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VectorTile$Tile parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (VectorTile$Tile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static VectorTile$Tile parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (VectorTile$Tile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static VectorTile$Tile parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (VectorTile$Tile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
