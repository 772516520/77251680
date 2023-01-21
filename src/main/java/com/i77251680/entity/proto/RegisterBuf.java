package com.i77251680.entity.proto;

public final class RegisterBuf {
    private RegisterBuf() {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions(
                (com.google.protobuf.ExtensionRegistryLite) registry);
    }

    public interface reg_bufOrBuilder extends
            // @@protoc_insertion_point(interface_extends:reg_buf)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>required .buf1 buf1 = 1;</code>
         *
         * @return Whether the buf1 field is set.
         */
        boolean hasBuf1();

        /**
         * <code>required .buf1 buf1 = 1;</code>
         *
         * @return The buf1.
         */
        RegisterBuf.buf1 getBuf1();

        /**
         * <code>required .buf1 buf1 = 1;</code>
         */
        RegisterBuf.buf1OrBuilder getBuf1OrBuilder();

        /**
         * <code>required .buf2 buf2 = 2;</code>
         *
         * @return Whether the buf2 field is set.
         */
        boolean hasBuf2();

        /**
         * <code>required .buf2 buf2 = 2;</code>
         *
         * @return The buf2.
         */
        RegisterBuf.buf2 getBuf2();

        /**
         * <code>required .buf2 buf2 = 2;</code>
         */
        RegisterBuf.buf2OrBuilder getBuf2OrBuilder();
    }

    /**
     * Protobuf type {@code reg_buf}
     */
    public static final class reg_buf extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:reg_buf)
            reg_bufOrBuilder {
        private static final long serialVersionUID = 0L;

        // Use reg_buf.newBuilder() to construct.
        private reg_buf(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private reg_buf() {
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new reg_buf();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return RegisterBuf.internal_static_reg_buf_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return RegisterBuf.internal_static_reg_buf_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            RegisterBuf.reg_buf.class, RegisterBuf.reg_buf.Builder.class);
        }

        private int bitField0_;
        public static final int BUF1_FIELD_NUMBER = 1;
        private RegisterBuf.buf1 buf1_;

        /**
         * <code>required .buf1 buf1 = 1;</code>
         *
         * @return Whether the buf1 field is set.
         */
        @java.lang.Override
        public boolean hasBuf1() {
            return ((bitField0_ & 0x00000001) != 0);
        }

        /**
         * <code>required .buf1 buf1 = 1;</code>
         *
         * @return The buf1.
         */
        @java.lang.Override
        public RegisterBuf.buf1 getBuf1() {
            return buf1_ == null ? RegisterBuf.buf1.getDefaultInstance() : buf1_;
        }

        /**
         * <code>required .buf1 buf1 = 1;</code>
         */
        @java.lang.Override
        public RegisterBuf.buf1OrBuilder getBuf1OrBuilder() {
            return buf1_ == null ? RegisterBuf.buf1.getDefaultInstance() : buf1_;
        }

        public static final int BUF2_FIELD_NUMBER = 2;
        private RegisterBuf.buf2 buf2_;

        /**
         * <code>required .buf2 buf2 = 2;</code>
         *
         * @return Whether the buf2 field is set.
         */
        @java.lang.Override
        public boolean hasBuf2() {
            return ((bitField0_ & 0x00000002) != 0);
        }

        /**
         * <code>required .buf2 buf2 = 2;</code>
         *
         * @return The buf2.
         */
        @java.lang.Override
        public RegisterBuf.buf2 getBuf2() {
            return buf2_ == null ? RegisterBuf.buf2.getDefaultInstance() : buf2_;
        }

        /**
         * <code>required .buf2 buf2 = 2;</code>
         */
        @java.lang.Override
        public RegisterBuf.buf2OrBuilder getBuf2OrBuilder() {
            return buf2_ == null ? RegisterBuf.buf2.getDefaultInstance() : buf2_;
        }

        private byte memoizedIsInitialized = -1;

        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            if (!hasBuf1()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasBuf2()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!getBuf1().isInitialized()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!getBuf2().isInitialized()) {
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
                output.writeMessage(1, getBuf1());
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                output.writeMessage(2, getBuf2());
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
                        .computeMessageSize(1, getBuf1());
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(2, getBuf2());
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
            if (!(obj instanceof RegisterBuf.reg_buf)) {
                return super.equals(obj);
            }
            RegisterBuf.reg_buf other = (RegisterBuf.reg_buf) obj;

            if (hasBuf1() != other.hasBuf1()) return false;
            if (hasBuf1()) {
                if (!getBuf1()
                        .equals(other.getBuf1())) return false;
            }
            if (hasBuf2() != other.hasBuf2()) return false;
            if (hasBuf2()) {
                if (!getBuf2()
                        .equals(other.getBuf2())) return false;
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
            if (hasBuf1()) {
                hash = (37 * hash) + BUF1_FIELD_NUMBER;
                hash = (53 * hash) + getBuf1().hashCode();
            }
            if (hasBuf2()) {
                hash = (37 * hash) + BUF2_FIELD_NUMBER;
                hash = (53 * hash) + getBuf2().hashCode();
            }
            hash = (29 * hash) + getUnknownFields().hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static RegisterBuf.reg_buf parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RegisterBuf.reg_buf parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RegisterBuf.reg_buf parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RegisterBuf.reg_buf parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RegisterBuf.reg_buf parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RegisterBuf.reg_buf parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RegisterBuf.reg_buf parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static RegisterBuf.reg_buf parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RegisterBuf.reg_buf parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static RegisterBuf.reg_buf parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RegisterBuf.reg_buf parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static RegisterBuf.reg_buf parseFrom(
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

        public static Builder newBuilder(RegisterBuf.reg_buf prototype) {
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
         * Protobuf type {@code reg_buf}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:reg_buf)
                RegisterBuf.reg_bufOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return RegisterBuf.internal_static_reg_buf_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return RegisterBuf.internal_static_reg_buf_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                RegisterBuf.reg_buf.class, RegisterBuf.reg_buf.Builder.class);
            }

            // Construct using RegisterBuf.reg_buf.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                    getBuf1FieldBuilder();
                    getBuf2FieldBuilder();
                }
            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                if (buf1Builder_ == null) {
                    buf1_ = null;
                } else {
                    buf1Builder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000001);
                if (buf2Builder_ == null) {
                    buf2_ = null;
                } else {
                    buf2Builder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000002);
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return RegisterBuf.internal_static_reg_buf_descriptor;
            }

            @java.lang.Override
            public RegisterBuf.reg_buf getDefaultInstanceForType() {
                return RegisterBuf.reg_buf.getDefaultInstance();
            }

            @java.lang.Override
            public RegisterBuf.reg_buf build() {
                RegisterBuf.reg_buf result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public RegisterBuf.reg_buf buildPartial() {
                RegisterBuf.reg_buf result = new RegisterBuf.reg_buf(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) != 0)) {
                    if (buf1Builder_ == null) {
                        result.buf1_ = buf1_;
                    } else {
                        result.buf1_ = buf1Builder_.build();
                    }
                    to_bitField0_ |= 0x00000001;
                }
                if (((from_bitField0_ & 0x00000002) != 0)) {
                    if (buf2Builder_ == null) {
                        result.buf2_ = buf2_;
                    } else {
                        result.buf2_ = buf2Builder_.build();
                    }
                    to_bitField0_ |= 0x00000002;
                }
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
                if (other instanceof RegisterBuf.reg_buf) {
                    return mergeFrom((RegisterBuf.reg_buf) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(RegisterBuf.reg_buf other) {
                if (other == RegisterBuf.reg_buf.getDefaultInstance()) return this;
                if (other.hasBuf1()) {
                    mergeBuf1(other.getBuf1());
                }
                if (other.hasBuf2()) {
                    mergeBuf2(other.getBuf2());
                }
                this.mergeUnknownFields(other.getUnknownFields());
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                if (!hasBuf1()) {
                    return false;
                }
                if (!hasBuf2()) {
                    return false;
                }
                if (!getBuf1().isInitialized()) {
                    return false;
                }
                if (!getBuf2().isInitialized()) {
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
                            case 10: {
                                input.readMessage(
                                        getBuf1FieldBuilder().getBuilder(),
                                        extensionRegistry);
                                bitField0_ |= 0x00000001;
                                break;
                            } // case 10
                            case 18: {
                                input.readMessage(
                                        getBuf2FieldBuilder().getBuilder(),
                                        extensionRegistry);
                                bitField0_ |= 0x00000002;
                                break;
                            } // case 18
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

            private RegisterBuf.buf1 buf1_;
            private com.google.protobuf.SingleFieldBuilderV3<
                    RegisterBuf.buf1, RegisterBuf.buf1.Builder, RegisterBuf.buf1OrBuilder> buf1Builder_;

            /**
             * <code>required .buf1 buf1 = 1;</code>
             *
             * @return Whether the buf1 field is set.
             */
            public boolean hasBuf1() {
                return ((bitField0_ & 0x00000001) != 0);
            }

            /**
             * <code>required .buf1 buf1 = 1;</code>
             *
             * @return The buf1.
             */
            public RegisterBuf.buf1 getBuf1() {
                if (buf1Builder_ == null) {
                    return buf1_ == null ? RegisterBuf.buf1.getDefaultInstance() : buf1_;
                } else {
                    return buf1Builder_.getMessage();
                }
            }

            /**
             * <code>required .buf1 buf1 = 1;</code>
             */
            public Builder setBuf1(RegisterBuf.buf1 value) {
                if (buf1Builder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    buf1_ = value;
                    onChanged();
                } else {
                    buf1Builder_.setMessage(value);
                }
                bitField0_ |= 0x00000001;
                return this;
            }

            /**
             * <code>required .buf1 buf1 = 1;</code>
             */
            public Builder setBuf1(
                    RegisterBuf.buf1.Builder builderForValue) {
                if (buf1Builder_ == null) {
                    buf1_ = builderForValue.build();
                    onChanged();
                } else {
                    buf1Builder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000001;
                return this;
            }

            /**
             * <code>required .buf1 buf1 = 1;</code>
             */
            public Builder mergeBuf1(RegisterBuf.buf1 value) {
                if (buf1Builder_ == null) {
                    if (((bitField0_ & 0x00000001) != 0) &&
                            buf1_ != null &&
                            buf1_ != RegisterBuf.buf1.getDefaultInstance()) {
                        buf1_ =
                                RegisterBuf.buf1.newBuilder(buf1_).mergeFrom(value).buildPartial();
                    } else {
                        buf1_ = value;
                    }
                    onChanged();
                } else {
                    buf1Builder_.mergeFrom(value);
                }
                bitField0_ |= 0x00000001;
                return this;
            }

            /**
             * <code>required .buf1 buf1 = 1;</code>
             */
            public Builder clearBuf1() {
                if (buf1Builder_ == null) {
                    buf1_ = null;
                    onChanged();
                } else {
                    buf1Builder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000001);
                return this;
            }

            /**
             * <code>required .buf1 buf1 = 1;</code>
             */
            public RegisterBuf.buf1.Builder getBuf1Builder() {
                bitField0_ |= 0x00000001;
                onChanged();
                return getBuf1FieldBuilder().getBuilder();
            }

            /**
             * <code>required .buf1 buf1 = 1;</code>
             */
            public RegisterBuf.buf1OrBuilder getBuf1OrBuilder() {
                if (buf1Builder_ != null) {
                    return buf1Builder_.getMessageOrBuilder();
                } else {
                    return buf1_ == null ?
                            RegisterBuf.buf1.getDefaultInstance() : buf1_;
                }
            }

            /**
             * <code>required .buf1 buf1 = 1;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    RegisterBuf.buf1, RegisterBuf.buf1.Builder, RegisterBuf.buf1OrBuilder>
            getBuf1FieldBuilder() {
                if (buf1Builder_ == null) {
                    buf1Builder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            RegisterBuf.buf1, RegisterBuf.buf1.Builder, RegisterBuf.buf1OrBuilder>(
                            getBuf1(),
                            getParentForChildren(),
                            isClean());
                    buf1_ = null;
                }
                return buf1Builder_;
            }

            private RegisterBuf.buf2 buf2_;
            private com.google.protobuf.SingleFieldBuilderV3<
                    RegisterBuf.buf2, RegisterBuf.buf2.Builder, RegisterBuf.buf2OrBuilder> buf2Builder_;

            /**
             * <code>required .buf2 buf2 = 2;</code>
             *
             * @return Whether the buf2 field is set.
             */
            public boolean hasBuf2() {
                return ((bitField0_ & 0x00000002) != 0);
            }

            /**
             * <code>required .buf2 buf2 = 2;</code>
             *
             * @return The buf2.
             */
            public RegisterBuf.buf2 getBuf2() {
                if (buf2Builder_ == null) {
                    return buf2_ == null ? RegisterBuf.buf2.getDefaultInstance() : buf2_;
                } else {
                    return buf2Builder_.getMessage();
                }
            }

            /**
             * <code>required .buf2 buf2 = 2;</code>
             */
            public Builder setBuf2(RegisterBuf.buf2 value) {
                if (buf2Builder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    buf2_ = value;
                    onChanged();
                } else {
                    buf2Builder_.setMessage(value);
                }
                bitField0_ |= 0x00000002;
                return this;
            }

            /**
             * <code>required .buf2 buf2 = 2;</code>
             */
            public Builder setBuf2(
                    RegisterBuf.buf2.Builder builderForValue) {
                if (buf2Builder_ == null) {
                    buf2_ = builderForValue.build();
                    onChanged();
                } else {
                    buf2Builder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000002;
                return this;
            }

            /**
             * <code>required .buf2 buf2 = 2;</code>
             */
            public Builder mergeBuf2(RegisterBuf.buf2 value) {
                if (buf2Builder_ == null) {
                    if (((bitField0_ & 0x00000002) != 0) &&
                            buf2_ != null &&
                            buf2_ != RegisterBuf.buf2.getDefaultInstance()) {
                        buf2_ =
                                RegisterBuf.buf2.newBuilder(buf2_).mergeFrom(value).buildPartial();
                    } else {
                        buf2_ = value;
                    }
                    onChanged();
                } else {
                    buf2Builder_.mergeFrom(value);
                }
                bitField0_ |= 0x00000002;
                return this;
            }

            /**
             * <code>required .buf2 buf2 = 2;</code>
             */
            public Builder clearBuf2() {
                if (buf2Builder_ == null) {
                    buf2_ = null;
                    onChanged();
                } else {
                    buf2Builder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000002);
                return this;
            }

            /**
             * <code>required .buf2 buf2 = 2;</code>
             */
            public RegisterBuf.buf2.Builder getBuf2Builder() {
                bitField0_ |= 0x00000002;
                onChanged();
                return getBuf2FieldBuilder().getBuilder();
            }

            /**
             * <code>required .buf2 buf2 = 2;</code>
             */
            public RegisterBuf.buf2OrBuilder getBuf2OrBuilder() {
                if (buf2Builder_ != null) {
                    return buf2Builder_.getMessageOrBuilder();
                } else {
                    return buf2_ == null ?
                            RegisterBuf.buf2.getDefaultInstance() : buf2_;
                }
            }

            /**
             * <code>required .buf2 buf2 = 2;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    RegisterBuf.buf2, RegisterBuf.buf2.Builder, RegisterBuf.buf2OrBuilder>
            getBuf2FieldBuilder() {
                if (buf2Builder_ == null) {
                    buf2Builder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            RegisterBuf.buf2, RegisterBuf.buf2.Builder, RegisterBuf.buf2OrBuilder>(
                            getBuf2(),
                            getParentForChildren(),
                            isClean());
                    buf2_ = null;
                }
                return buf2Builder_;
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


            // @@protoc_insertion_point(builder_scope:reg_buf)
        }

        // @@protoc_insertion_point(class_scope:reg_buf)
        private static final RegisterBuf.reg_buf DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new RegisterBuf.reg_buf();
        }

        public static RegisterBuf.reg_buf getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<reg_buf>
                PARSER = new com.google.protobuf.AbstractParser<reg_buf>() {
            @java.lang.Override
            public reg_buf parsePartialFrom(
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

        public static com.google.protobuf.Parser<reg_buf> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<reg_buf> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public RegisterBuf.reg_buf getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface buf1OrBuilder extends
            // @@protoc_insertion_point(interface_extends:buf1)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>required int32 const46 = 1;</code>
         *
         * @return Whether the const46 field is set.
         */
        boolean hasConst46();

        /**
         * <code>required int32 const46 = 1;</code>
         *
         * @return The const46.
         */
        int getConst46();

        /**
         * <code>required int32 Date = 2;</code>
         *
         * @return Whether the date field is set.
         */
        boolean hasDate();

        /**
         * <code>required int32 Date = 2;</code>
         *
         * @return The date.
         */
        int getDate();
    }

    /**
     * Protobuf type {@code buf1}
     */
    public static final class buf1 extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:buf1)
            buf1OrBuilder {
        private static final long serialVersionUID = 0L;

        // Use buf1.newBuilder() to construct.
        private buf1(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private buf1() {
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new buf1();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return RegisterBuf.internal_static_buf1_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return RegisterBuf.internal_static_buf1_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            RegisterBuf.buf1.class, RegisterBuf.buf1.Builder.class);
        }

        private int bitField0_;
        public static final int CONST46_FIELD_NUMBER = 1;
        private int const46_;

        /**
         * <code>required int32 const46 = 1;</code>
         *
         * @return Whether the const46 field is set.
         */
        @java.lang.Override
        public boolean hasConst46() {
            return ((bitField0_ & 0x00000001) != 0);
        }

        /**
         * <code>required int32 const46 = 1;</code>
         *
         * @return The const46.
         */
        @java.lang.Override
        public int getConst46() {
            return const46_;
        }

        public static final int DATE_FIELD_NUMBER = 2;
        private int date_;

        /**
         * <code>required int32 Date = 2;</code>
         *
         * @return Whether the date field is set.
         */
        @java.lang.Override
        public boolean hasDate() {
            return ((bitField0_ & 0x00000002) != 0);
        }

        /**
         * <code>required int32 Date = 2;</code>
         *
         * @return The date.
         */
        @java.lang.Override
        public int getDate() {
            return date_;
        }

        private byte memoizedIsInitialized = -1;

        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            if (!hasConst46()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasDate()) {
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
                output.writeInt32(1, const46_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                output.writeInt32(2, date_);
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
                        .computeInt32Size(1, const46_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(2, date_);
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
            if (!(obj instanceof RegisterBuf.buf1)) {
                return super.equals(obj);
            }
            RegisterBuf.buf1 other = (RegisterBuf.buf1) obj;

            if (hasConst46() != other.hasConst46()) return false;
            if (hasConst46()) {
                if (getConst46()
                        != other.getConst46()) return false;
            }
            if (hasDate() != other.hasDate()) return false;
            if (hasDate()) {
                if (getDate()
                        != other.getDate()) return false;
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
            if (hasConst46()) {
                hash = (37 * hash) + CONST46_FIELD_NUMBER;
                hash = (53 * hash) + getConst46();
            }
            if (hasDate()) {
                hash = (37 * hash) + DATE_FIELD_NUMBER;
                hash = (53 * hash) + getDate();
            }
            hash = (29 * hash) + getUnknownFields().hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static RegisterBuf.buf1 parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RegisterBuf.buf1 parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RegisterBuf.buf1 parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RegisterBuf.buf1 parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RegisterBuf.buf1 parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RegisterBuf.buf1 parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RegisterBuf.buf1 parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static RegisterBuf.buf1 parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RegisterBuf.buf1 parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static RegisterBuf.buf1 parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RegisterBuf.buf1 parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static RegisterBuf.buf1 parseFrom(
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

        public static Builder newBuilder(RegisterBuf.buf1 prototype) {
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
         * Protobuf type {@code buf1}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:buf1)
                RegisterBuf.buf1OrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return RegisterBuf.internal_static_buf1_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return RegisterBuf.internal_static_buf1_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                RegisterBuf.buf1.class, RegisterBuf.buf1.Builder.class);
            }

            // Construct using RegisterBuf.buf1.newBuilder()
            private Builder() {

            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);

            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                const46_ = 0;
                bitField0_ = (bitField0_ & ~0x00000001);
                date_ = 0;
                bitField0_ = (bitField0_ & ~0x00000002);
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return RegisterBuf.internal_static_buf1_descriptor;
            }

            @java.lang.Override
            public RegisterBuf.buf1 getDefaultInstanceForType() {
                return RegisterBuf.buf1.getDefaultInstance();
            }

            @java.lang.Override
            public RegisterBuf.buf1 build() {
                RegisterBuf.buf1 result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public RegisterBuf.buf1 buildPartial() {
                RegisterBuf.buf1 result = new RegisterBuf.buf1(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) != 0)) {
                    result.const46_ = const46_;
                    to_bitField0_ |= 0x00000001;
                }
                if (((from_bitField0_ & 0x00000002) != 0)) {
                    result.date_ = date_;
                    to_bitField0_ |= 0x00000002;
                }
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
                if (other instanceof RegisterBuf.buf1) {
                    return mergeFrom((RegisterBuf.buf1) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(RegisterBuf.buf1 other) {
                if (other == RegisterBuf.buf1.getDefaultInstance()) return this;
                if (other.hasConst46()) {
                    setConst46(other.getConst46());
                }
                if (other.hasDate()) {
                    setDate(other.getDate());
                }
                this.mergeUnknownFields(other.getUnknownFields());
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                if (!hasConst46()) {
                    return false;
                }
                if (!hasDate()) {
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
                                const46_ = input.readInt32();
                                bitField0_ |= 0x00000001;
                                break;
                            } // case 8
                            case 16: {
                                date_ = input.readInt32();
                                bitField0_ |= 0x00000002;
                                break;
                            } // case 16
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

            private int const46_;

            /**
             * <code>required int32 const46 = 1;</code>
             *
             * @return Whether the const46 field is set.
             */
            @java.lang.Override
            public boolean hasConst46() {
                return ((bitField0_ & 0x00000001) != 0);
            }

            /**
             * <code>required int32 const46 = 1;</code>
             *
             * @return The const46.
             */
            @java.lang.Override
            public int getConst46() {
                return const46_;
            }

            /**
             * <code>required int32 const46 = 1;</code>
             *
             * @param value The const46 to set.
             * @return This builder for chaining.
             */
            public Builder setConst46(int value) {
                bitField0_ |= 0x00000001;
                const46_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>required int32 const46 = 1;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearConst46() {
                bitField0_ = (bitField0_ & ~0x00000001);
                const46_ = 0;
                onChanged();
                return this;
            }

            private int date_;

            /**
             * <code>required int32 Date = 2;</code>
             *
             * @return Whether the date field is set.
             */
            @java.lang.Override
            public boolean hasDate() {
                return ((bitField0_ & 0x00000002) != 0);
            }

            /**
             * <code>required int32 Date = 2;</code>
             *
             * @return The date.
             */
            @java.lang.Override
            public int getDate() {
                return date_;
            }

            /**
             * <code>required int32 Date = 2;</code>
             *
             * @param value The date to set.
             * @return This builder for chaining.
             */
            public Builder setDate(int value) {
                bitField0_ |= 0x00000002;
                date_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>required int32 Date = 2;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearDate() {
                bitField0_ = (bitField0_ & ~0x00000002);
                date_ = 0;
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


            // @@protoc_insertion_point(builder_scope:buf1)
        }

        // @@protoc_insertion_point(class_scope:buf1)
        private static final RegisterBuf.buf1 DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new RegisterBuf.buf1();
        }

        public static RegisterBuf.buf1 getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<buf1>
                PARSER = new com.google.protobuf.AbstractParser<buf1>() {
            @java.lang.Override
            public buf1 parsePartialFrom(
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

        public static com.google.protobuf.Parser<buf1> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<buf1> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public RegisterBuf.buf1 getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface buf2OrBuilder extends
            // @@protoc_insertion_point(interface_extends:buf2)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>required int32 const283 = 1;</code>
         *
         * @return Whether the const283 field is set.
         */
        boolean hasConst283();

        /**
         * <code>required int32 const283 = 1;</code>
         *
         * @return The const283.
         */
        int getConst283();

        /**
         * <code>required int32 const0 = 2;</code>
         *
         * @return Whether the const0 field is set.
         */
        boolean hasConst0();

        /**
         * <code>required int32 const0 = 2;</code>
         *
         * @return The const0.
         */
        int getConst0();
    }

    /**
     * Protobuf type {@code buf2}
     */
    public static final class buf2 extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:buf2)
            buf2OrBuilder {
        private static final long serialVersionUID = 0L;

        // Use buf2.newBuilder() to construct.
        private buf2(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private buf2() {
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new buf2();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return RegisterBuf.internal_static_buf2_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return RegisterBuf.internal_static_buf2_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            RegisterBuf.buf2.class, RegisterBuf.buf2.Builder.class);
        }

        private int bitField0_;
        public static final int CONST283_FIELD_NUMBER = 1;
        private int const283_;

        /**
         * <code>required int32 const283 = 1;</code>
         *
         * @return Whether the const283 field is set.
         */
        @java.lang.Override
        public boolean hasConst283() {
            return ((bitField0_ & 0x00000001) != 0);
        }

        /**
         * <code>required int32 const283 = 1;</code>
         *
         * @return The const283.
         */
        @java.lang.Override
        public int getConst283() {
            return const283_;
        }

        public static final int CONST0_FIELD_NUMBER = 2;
        private int const0_;

        /**
         * <code>required int32 const0 = 2;</code>
         *
         * @return Whether the const0 field is set.
         */
        @java.lang.Override
        public boolean hasConst0() {
            return ((bitField0_ & 0x00000002) != 0);
        }

        /**
         * <code>required int32 const0 = 2;</code>
         *
         * @return The const0.
         */
        @java.lang.Override
        public int getConst0() {
            return const0_;
        }

        private byte memoizedIsInitialized = -1;

        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            if (!hasConst283()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasConst0()) {
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
                output.writeInt32(1, const283_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                output.writeInt32(2, const0_);
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
                        .computeInt32Size(1, const283_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(2, const0_);
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
            if (!(obj instanceof RegisterBuf.buf2)) {
                return super.equals(obj);
            }
            RegisterBuf.buf2 other = (RegisterBuf.buf2) obj;

            if (hasConst283() != other.hasConst283()) return false;
            if (hasConst283()) {
                if (getConst283()
                        != other.getConst283()) return false;
            }
            if (hasConst0() != other.hasConst0()) return false;
            if (hasConst0()) {
                if (getConst0()
                        != other.getConst0()) return false;
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
            if (hasConst283()) {
                hash = (37 * hash) + CONST283_FIELD_NUMBER;
                hash = (53 * hash) + getConst283();
            }
            if (hasConst0()) {
                hash = (37 * hash) + CONST0_FIELD_NUMBER;
                hash = (53 * hash) + getConst0();
            }
            hash = (29 * hash) + getUnknownFields().hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static RegisterBuf.buf2 parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RegisterBuf.buf2 parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RegisterBuf.buf2 parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RegisterBuf.buf2 parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RegisterBuf.buf2 parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RegisterBuf.buf2 parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RegisterBuf.buf2 parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static RegisterBuf.buf2 parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RegisterBuf.buf2 parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static RegisterBuf.buf2 parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RegisterBuf.buf2 parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static RegisterBuf.buf2 parseFrom(
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

        public static Builder newBuilder(RegisterBuf.buf2 prototype) {
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
         * Protobuf type {@code buf2}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:buf2)
                RegisterBuf.buf2OrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return RegisterBuf.internal_static_buf2_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return RegisterBuf.internal_static_buf2_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                RegisterBuf.buf2.class, RegisterBuf.buf2.Builder.class);
            }

            // Construct using RegisterBuf.buf2.newBuilder()
            private Builder() {

            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);

            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                const283_ = 0;
                bitField0_ = (bitField0_ & ~0x00000001);
                const0_ = 0;
                bitField0_ = (bitField0_ & ~0x00000002);
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return RegisterBuf.internal_static_buf2_descriptor;
            }

            @java.lang.Override
            public RegisterBuf.buf2 getDefaultInstanceForType() {
                return RegisterBuf.buf2.getDefaultInstance();
            }

            @java.lang.Override
            public RegisterBuf.buf2 build() {
                RegisterBuf.buf2 result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public RegisterBuf.buf2 buildPartial() {
                RegisterBuf.buf2 result = new RegisterBuf.buf2(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) != 0)) {
                    result.const283_ = const283_;
                    to_bitField0_ |= 0x00000001;
                }
                if (((from_bitField0_ & 0x00000002) != 0)) {
                    result.const0_ = const0_;
                    to_bitField0_ |= 0x00000002;
                }
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
                if (other instanceof RegisterBuf.buf2) {
                    return mergeFrom((RegisterBuf.buf2) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(RegisterBuf.buf2 other) {
                if (other == RegisterBuf.buf2.getDefaultInstance()) return this;
                if (other.hasConst283()) {
                    setConst283(other.getConst283());
                }
                if (other.hasConst0()) {
                    setConst0(other.getConst0());
                }
                this.mergeUnknownFields(other.getUnknownFields());
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                if (!hasConst283()) {
                    return false;
                }
                if (!hasConst0()) {
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
                                const283_ = input.readInt32();
                                bitField0_ |= 0x00000001;
                                break;
                            } // case 8
                            case 16: {
                                const0_ = input.readInt32();
                                bitField0_ |= 0x00000002;
                                break;
                            } // case 16
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

            private int const283_;

            /**
             * <code>required int32 const283 = 1;</code>
             *
             * @return Whether the const283 field is set.
             */
            @java.lang.Override
            public boolean hasConst283() {
                return ((bitField0_ & 0x00000001) != 0);
            }

            /**
             * <code>required int32 const283 = 1;</code>
             *
             * @return The const283.
             */
            @java.lang.Override
            public int getConst283() {
                return const283_;
            }

            /**
             * <code>required int32 const283 = 1;</code>
             *
             * @param value The const283 to set.
             * @return This builder for chaining.
             */
            public Builder setConst283(int value) {
                bitField0_ |= 0x00000001;
                const283_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>required int32 const283 = 1;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearConst283() {
                bitField0_ = (bitField0_ & ~0x00000001);
                const283_ = 0;
                onChanged();
                return this;
            }

            private int const0_;

            /**
             * <code>required int32 const0 = 2;</code>
             *
             * @return Whether the const0 field is set.
             */
            @java.lang.Override
            public boolean hasConst0() {
                return ((bitField0_ & 0x00000002) != 0);
            }

            /**
             * <code>required int32 const0 = 2;</code>
             *
             * @return The const0.
             */
            @java.lang.Override
            public int getConst0() {
                return const0_;
            }

            /**
             * <code>required int32 const0 = 2;</code>
             *
             * @param value The const0 to set.
             * @return This builder for chaining.
             */
            public Builder setConst0(int value) {
                bitField0_ |= 0x00000002;
                const0_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>required int32 const0 = 2;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearConst0() {
                bitField0_ = (bitField0_ & ~0x00000002);
                const0_ = 0;
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


            // @@protoc_insertion_point(builder_scope:buf2)
        }

        // @@protoc_insertion_point(class_scope:buf2)
        private static final RegisterBuf.buf2 DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new RegisterBuf.buf2();
        }

        public static RegisterBuf.buf2 getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<buf2>
                PARSER = new com.google.protobuf.AbstractParser<buf2>() {
            @java.lang.Override
            public buf2 parsePartialFrom(
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

        public static com.google.protobuf.Parser<buf2> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<buf2> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public RegisterBuf.buf2 getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_reg_buf_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_reg_buf_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_buf1_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_buf1_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_buf2_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_buf2_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        java.lang.String[] descriptorData = {
                "\n1com/i77251680/core/packet/proto/Regist" +
                        "erBuf.proto\"3\n\007reg_buf\022\023\n\004buf1\030\001 \002(\0132\005.b" +
                        "uf1\022\023\n\004buf2\030\002 \002(\0132\005.buf2\"%\n\004buf1\022\017\n\007cons" +
                        "t46\030\001 \002(\005\022\014\n\004Date\030\002 \002(\005\"(\n\004buf2\022\020\n\010const" +
                        "283\030\001 \002(\005\022\016\n\006const0\030\002 \002(\005B\rB\013RegisterBuf"
        };
        descriptor = com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[]{
                        });
        internal_static_reg_buf_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_reg_buf_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_reg_buf_descriptor,
                new java.lang.String[]{"Buf1", "Buf2",});
        internal_static_buf1_descriptor =
                getDescriptor().getMessageTypes().get(1);
        internal_static_buf1_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_buf1_descriptor,
                new java.lang.String[]{"Const46", "Date",});
        internal_static_buf2_descriptor =
                getDescriptor().getMessageTypes().get(2);
        internal_static_buf2_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_buf2_descriptor,
                new java.lang.String[]{"Const283", "Const0",});
    }

    // @@protoc_insertion_point(outer_class_scope)
}
