package com.i77251680.entity.proto;

public final class OidbSvc_0x480_9_IMCore {
    private OidbSvc_0x480_9_IMCore() {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions(
                (com.google.protobuf.ExtensionRegistryLite) registry);
    }

    public interface hb480OrBuilder extends
            // @@protoc_insertion_point(interface_extends:hb480)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>required int32 const1152 = 1;</code>
         *
         * @return Whether the const1152 field is set.
         */
        boolean hasConst1152();

        /**
         * <code>required int32 const1152 = 1;</code>
         *
         * @return The const1152.
         */
        int getConst1152();

        /**
         * <code>required int32 const9 = 2;</code>
         *
         * @return Whether the const9 field is set.
         */
        boolean hasConst9();

        /**
         * <code>required int32 const9 = 2;</code>
         *
         * @return The const9.
         */
        int getConst9();

        /**
         * <code>required bytes buf = 3;</code>
         *
         * @return Whether the buf field is set.
         */
        boolean hasBuf();

        /**
         * <code>required bytes buf = 3;</code>
         *
         * @return The buf.
         */
        com.google.protobuf.ByteString getBuf();
    }

    /**
     * Protobuf type {@code hb480}
     */
    public static final class hb480 extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:hb480)
            hb480OrBuilder {
        private static final long serialVersionUID = 0L;

        // Use hb480.newBuilder() to construct.
        private hb480(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private hb480() {
            buf_ = com.google.protobuf.ByteString.EMPTY;
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new hb480();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return OidbSvc_0x480_9_IMCore.internal_static_hb480_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return OidbSvc_0x480_9_IMCore.internal_static_hb480_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            OidbSvc_0x480_9_IMCore.hb480.class, OidbSvc_0x480_9_IMCore.hb480.Builder.class);
        }

        private int bitField0_;
        public static final int CONST1152_FIELD_NUMBER = 1;
        private int const1152_;

        /**
         * <code>required int32 const1152 = 1;</code>
         *
         * @return Whether the const1152 field is set.
         */
        @java.lang.Override
        public boolean hasConst1152() {
            return ((bitField0_ & 0x00000001) != 0);
        }

        /**
         * <code>required int32 const1152 = 1;</code>
         *
         * @return The const1152.
         */
        @java.lang.Override
        public int getConst1152() {
            return const1152_;
        }

        public static final int CONST9_FIELD_NUMBER = 2;
        private int const9_;

        /**
         * <code>required int32 const9 = 2;</code>
         *
         * @return Whether the const9 field is set.
         */
        @java.lang.Override
        public boolean hasConst9() {
            return ((bitField0_ & 0x00000002) != 0);
        }

        /**
         * <code>required int32 const9 = 2;</code>
         *
         * @return The const9.
         */
        @java.lang.Override
        public int getConst9() {
            return const9_;
        }

        public static final int BUF_FIELD_NUMBER = 3;
        private com.google.protobuf.ByteString buf_;

        /**
         * <code>required bytes buf = 3;</code>
         *
         * @return Whether the buf field is set.
         */
        @java.lang.Override
        public boolean hasBuf() {
            return ((bitField0_ & 0x00000004) != 0);
        }

        /**
         * <code>required bytes buf = 3;</code>
         *
         * @return The buf.
         */
        @java.lang.Override
        public com.google.protobuf.ByteString getBuf() {
            return buf_;
        }

        private byte memoizedIsInitialized = -1;

        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            if (!hasConst1152()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasConst9()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasBuf()) {
                memoizedIsInitialized = 0;
                return false;
            }
            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (((bitField0_ & 0x00000001) != 0)) {
                output.writeInt32(1, const1152_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                output.writeInt32(2, const9_);
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                output.writeBytes(3, buf_);
            }
            getUnknownFields().writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(1, const1152_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(2, const9_);
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(3, buf_);
            }
            size += getUnknownFields().getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof OidbSvc_0x480_9_IMCore.hb480)) {
                return super.equals(obj);
            }
            OidbSvc_0x480_9_IMCore.hb480 other = (OidbSvc_0x480_9_IMCore.hb480) obj;

            if (hasConst1152() != other.hasConst1152()) return false;
            if (hasConst1152()) {
                if (getConst1152()
                        != other.getConst1152()) return false;
            }
            if (hasConst9() != other.hasConst9()) return false;
            if (hasConst9()) {
                if (getConst9()
                        != other.getConst9()) return false;
            }
            if (hasBuf() != other.hasBuf()) return false;
            if (hasBuf()) {
                if (!getBuf()
                        .equals(other.getBuf())) return false;
            }
            if (!getUnknownFields().equals(other.getUnknownFields())) return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasConst1152()) {
                hash = (37 * hash) + CONST1152_FIELD_NUMBER;
                hash = (53 * hash) + getConst1152();
            }
            if (hasConst9()) {
                hash = (37 * hash) + CONST9_FIELD_NUMBER;
                hash = (53 * hash) + getConst9();
            }
            if (hasBuf()) {
                hash = (37 * hash) + BUF_FIELD_NUMBER;
                hash = (53 * hash) + getBuf().hashCode();
            }
            hash = (29 * hash) + getUnknownFields().hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static OidbSvc_0x480_9_IMCore.hb480 parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static OidbSvc_0x480_9_IMCore.hb480 parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static OidbSvc_0x480_9_IMCore.hb480 parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static OidbSvc_0x480_9_IMCore.hb480 parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static OidbSvc_0x480_9_IMCore.hb480 parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static OidbSvc_0x480_9_IMCore.hb480 parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static OidbSvc_0x480_9_IMCore.hb480 parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static OidbSvc_0x480_9_IMCore.hb480 parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static OidbSvc_0x480_9_IMCore.hb480 parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static OidbSvc_0x480_9_IMCore.hb480 parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static OidbSvc_0x480_9_IMCore.hb480 parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static OidbSvc_0x480_9_IMCore.hb480 parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(OidbSvc_0x480_9_IMCore.hb480 prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        /**
         * Protobuf type {@code hb480}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:hb480)
                OidbSvc_0x480_9_IMCore.hb480OrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return OidbSvc_0x480_9_IMCore.internal_static_hb480_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return OidbSvc_0x480_9_IMCore.internal_static_hb480_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                OidbSvc_0x480_9_IMCore.hb480.class, OidbSvc_0x480_9_IMCore.hb480.Builder.class);
            }

            // Construct using OidbSvc_0x480_9_IMCore.hb480.newBuilder()
            private Builder() {

            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);

            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                const1152_ = 0;
                bitField0_ = (bitField0_ & ~0x00000001);
                const9_ = 0;
                bitField0_ = (bitField0_ & ~0x00000002);
                buf_ = com.google.protobuf.ByteString.EMPTY;
                bitField0_ = (bitField0_ & ~0x00000004);
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return OidbSvc_0x480_9_IMCore.internal_static_hb480_descriptor;
            }

            @java.lang.Override
            public OidbSvc_0x480_9_IMCore.hb480 getDefaultInstanceForType() {
                return OidbSvc_0x480_9_IMCore.hb480.getDefaultInstance();
            }

            @java.lang.Override
            public OidbSvc_0x480_9_IMCore.hb480 build() {
                OidbSvc_0x480_9_IMCore.hb480 result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public OidbSvc_0x480_9_IMCore.hb480 buildPartial() {
                OidbSvc_0x480_9_IMCore.hb480 result = new OidbSvc_0x480_9_IMCore.hb480(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) != 0)) {
                    result.const1152_ = const1152_;
                    to_bitField0_ |= 0x00000001;
                }
                if (((from_bitField0_ & 0x00000002) != 0)) {
                    result.const9_ = const9_;
                    to_bitField0_ |= 0x00000002;
                }
                if (((from_bitField0_ & 0x00000004) != 0)) {
                    to_bitField0_ |= 0x00000004;
                }
                result.buf_ = buf_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }

            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }

            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }

            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }

            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }

            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }

            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof OidbSvc_0x480_9_IMCore.hb480) {
                    return mergeFrom((OidbSvc_0x480_9_IMCore.hb480) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(OidbSvc_0x480_9_IMCore.hb480 other) {
                if (other == OidbSvc_0x480_9_IMCore.hb480.getDefaultInstance()) return this;
                if (other.hasConst1152()) {
                    setConst1152(other.getConst1152());
                }
                if (other.hasConst9()) {
                    setConst9(other.getConst9());
                }
                if (other.hasBuf()) {
                    setBuf(other.getBuf());
                }
                this.mergeUnknownFields(other.getUnknownFields());
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                if (!hasConst1152()) {
                    return false;
                }
                if (!hasConst9()) {
                    return false;
                }
                if (!hasBuf()) {
                    return false;
                }
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                if (extensionRegistry == null) {
                    throw new java.lang.NullPointerException();
                }
                try {
                    boolean done = false;
                    while (!done) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 8: {
                                const1152_ = input.readInt32();
                                bitField0_ |= 0x00000001;
                                break;
                            } // case 8
                            case 16: {
                                const9_ = input.readInt32();
                                bitField0_ |= 0x00000002;
                                break;
                            } // case 16
                            case 26: {
                                buf_ = input.readBytes();
                                bitField0_ |= 0x00000004;
                                break;
                            } // case 26
                            default: {
                                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                                    done = true; // was an endgroup tag
                                }
                                break;
                            } // default:
                        } // switch (tag)
                    } // while (!done)
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    throw e.unwrapIOException();
                } finally {
                    onChanged();
                } // finally
                return this;
            }

            private int bitField0_;

            private int const1152_;

            /**
             * <code>required int32 const1152 = 1;</code>
             *
             * @return Whether the const1152 field is set.
             */
            @java.lang.Override
            public boolean hasConst1152() {
                return ((bitField0_ & 0x00000001) != 0);
            }

            /**
             * <code>required int32 const1152 = 1;</code>
             *
             * @return The const1152.
             */
            @java.lang.Override
            public int getConst1152() {
                return const1152_;
            }

            /**
             * <code>required int32 const1152 = 1;</code>
             *
             * @param value The const1152 to set.
             * @return This builder for chaining.
             */
            public Builder setConst1152(int value) {
                bitField0_ |= 0x00000001;
                const1152_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>required int32 const1152 = 1;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearConst1152() {
                bitField0_ = (bitField0_ & ~0x00000001);
                const1152_ = 0;
                onChanged();
                return this;
            }

            private int const9_;

            /**
             * <code>required int32 const9 = 2;</code>
             *
             * @return Whether the const9 field is set.
             */
            @java.lang.Override
            public boolean hasConst9() {
                return ((bitField0_ & 0x00000002) != 0);
            }

            /**
             * <code>required int32 const9 = 2;</code>
             *
             * @return The const9.
             */
            @java.lang.Override
            public int getConst9() {
                return const9_;
            }

            /**
             * <code>required int32 const9 = 2;</code>
             *
             * @param value The const9 to set.
             * @return This builder for chaining.
             */
            public Builder setConst9(int value) {
                bitField0_ |= 0x00000002;
                const9_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>required int32 const9 = 2;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearConst9() {
                bitField0_ = (bitField0_ & ~0x00000002);
                const9_ = 0;
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString buf_ = com.google.protobuf.ByteString.EMPTY;

            /**
             * <code>required bytes buf = 3;</code>
             *
             * @return Whether the buf field is set.
             */
            @java.lang.Override
            public boolean hasBuf() {
                return ((bitField0_ & 0x00000004) != 0);
            }

            /**
             * <code>required bytes buf = 3;</code>
             *
             * @return The buf.
             */
            @java.lang.Override
            public com.google.protobuf.ByteString getBuf() {
                return buf_;
            }

            /**
             * <code>required bytes buf = 3;</code>
             *
             * @param value The buf to set.
             * @return This builder for chaining.
             */
            public Builder setBuf(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000004;
                buf_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>required bytes buf = 3;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearBuf() {
                bitField0_ = (bitField0_ & ~0x00000004);
                buf_ = getDefaultInstance().getBuf();
                onChanged();
                return this;
            }

            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:hb480)
        }

        // @@protoc_insertion_point(class_scope:hb480)
        private static final OidbSvc_0x480_9_IMCore.hb480 DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new OidbSvc_0x480_9_IMCore.hb480();
        }

        public static OidbSvc_0x480_9_IMCore.hb480 getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<hb480>
                PARSER = new com.google.protobuf.AbstractParser<hb480>() {
            @java.lang.Override
            public hb480 parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                Builder builder = newBuilder();
                try {
                    builder.mergeFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(builder.buildPartial());
                } catch (com.google.protobuf.UninitializedMessageException e) {
                    throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
                } catch (java.io.IOException e) {
                    throw new com.google.protobuf.InvalidProtocolBufferException(e)
                            .setUnfinishedMessage(builder.buildPartial());
                }
                return builder.buildPartial();
            }
        };

        public static com.google.protobuf.Parser<hb480> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<hb480> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public OidbSvc_0x480_9_IMCore.hb480 getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_hb480_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_hb480_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        java.lang.String[] descriptorData = {
                "\n.core/packet/proto/OidbSvc.0x480_9_IMCo" +
                        "re.proto\"7\n\005hb480\022\021\n\tconst1152\030\001 \002(\005\022\016\n\006" +
                        "const9\030\002 \002(\005\022\013\n\003buf\030\003 \002(\014B\030B\026OidbSvc_0x4" +
                        "80_9_IMCore"
        };
        descriptor = com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[]{
                        });
        internal_static_hb480_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_hb480_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_hb480_descriptor,
                new java.lang.String[]{"Const1152", "Const9", "Buf",});
    }

    // @@protoc_insertion_point(outer_class_scope)
}
