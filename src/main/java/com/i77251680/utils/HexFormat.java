package com.i77251680.utils;

import java.util.Objects;

public class HexFormat {
    private static final byte[] LOWERCASE_DIGITS = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f',
    };
    private static final byte[] DIGITS = {
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1,
            -1, 10, 11, 12, 13, 14, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, 10, 11, 12, 13, 14, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
    };
    private static final HexFormat HEX_FORMAT =
            new HexFormat("", "", "", LOWERCASE_DIGITS);
    private final String suffix;
    private final String prefix;
    private final String delimiter;
    private final byte[] digits;

    private HexFormat(String delimiter, String prefix, String suffix, byte[] digits) {
        this.delimiter = Objects.requireNonNull(delimiter, "delimiter");
        this.prefix = Objects.requireNonNull(prefix, "prefix");
        this.suffix = Objects.requireNonNull(suffix, "suffix");
        this.digits = digits;
    }

    public static HexFormat of() {
        return HEX_FORMAT;
    }

    public byte[] parseHex(CharSequence string) {
        return parseHex(string, 0, string.length());
    }

    public byte[] parseHex(CharSequence string, int fromIndex, int toIndex) {
        Objects.requireNonNull(string, "string");

        if (fromIndex != 0 || toIndex != string.length()) {
            string = string.subSequence(fromIndex, toIndex);
        }

        // avoid overflow for max length prefix or suffix
        long valueChars = prefix.length() + 2L + suffix.length();
        long stride = valueChars + delimiter.length();
        if ((string.length() - valueChars) % stride != 0)
            throw new IllegalArgumentException("extra or missing delimiters " +
                    "or values consisting of prefix, two hexadecimal digits, and suffix");

        checkLiteral(string, 0, prefix);
        checkLiteral(string, string.length() - suffix.length(), suffix);
        String between = suffix + delimiter + prefix;
        final int len = (int) ((string.length() - valueChars) / stride + 1L);
        byte[] bytes = new byte[len];
        int i, offset;
        for (i = 0, offset = prefix.length(); i < len - 1; i++, offset += 2 + between.length()) {
            bytes[i] = (byte) fromHexDigits(string, offset);
            checkLiteral(string, offset + 2, between);
        }
        bytes[i] = (byte) fromHexDigits(string, offset);

        return bytes;
    }

    public String formatHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte i : bytes) {
            sb.append(String.format("%02x", i));
        }
        return new String(sb);
    }

    private static int fromHexDigits(CharSequence string, int index) {
        int high = fromHexDigit(string.charAt(index));
        int low = fromHexDigit(string.charAt(index + 1));
        return (high << 4) | low;
    }

    private static int fromHexDigit(int ch) {
        int value;
        if ((ch >>> 8) == 0 && (value = DIGITS[ch]) >= 0) {
            return value;
        }
        throw new NumberFormatException("not a hexadecimal digit: \"" + (char) ch + "\" = " + ch);
    }

    private static void checkLiteral(CharSequence string, int index, String literal) {
        assert index <= string.length() - literal.length() : "pre-checked invariant error";
        if (literal.isEmpty() ||
                (literal.length() == 1 && literal.charAt(0) == string.charAt(index))) {
            return;
        }
        for (int i = 0; i < literal.length(); i++) {
            if (string.charAt(index + i) != literal.charAt(i)) {
                throw new IllegalArgumentException(escapeNL("found: \"" +
                        string.subSequence(index, index + literal.length()) +
                        "\", expected: \"" + literal + "\", index: " + index +
                        " ch: " + (int) string.charAt(index + i)));
            }
        }
    }

    private static String escapeNL(String string) {
        return string.replace("\n", "\\n")
                .replace("\r", "\\r");
    }

}
