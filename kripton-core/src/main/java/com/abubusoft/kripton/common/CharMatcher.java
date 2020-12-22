/*******************************************************************************
 * Copyright 2015, 2016 Francesco Benincasa.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package com.abubusoft.kripton.common;

import static com.abubusoft.kripton.common.Preconditions.checkArgument;
import static com.abubusoft.kripton.common.Preconditions.checkNotNull;

import java.util.Arrays;
import java.util.BitSet;



/**
 * Determines a true or false value for any Java {@code char} value, just as {@link Predicate} does
 * for any {@link Object}. Also offers basic text processing methods based on this function.
 * Implementations are strongly encouraged to be side-effect-free and immutable.
 *
 * <p>Throughout the documentation of this class, the phrase "matching character" is used to mean
 * "any character {@code c} for which {@code this.matches(c)} returns {@code true}".
 *
 * <p><b>Note:</b> This class deals only with {@code char} values; it does not understand
 * supplementary Unicode code points in the range {@code 0x10000} to {@code 0x10FFFF}. Such logical
 * characters are encoded into a {@code String} using surrogate pairs, and a {@code CharMatcher}
 * treats these just as two separate characters.
 *
 * <p>Example usages: <pre>
 *   String trimmed = {@link #WHITESPACE WHITESPACE}.{@link #trimFrom trimFrom}(userInput);
 *   if ({@link #ASCII ASCII}.{@link #matchesAllOf matchesAllOf}(s)) { ... }</pre>
 *
 * <p>See the Guava User Guide article on <a href=
 * "http://code.google.com/p/guava-libraries/wiki/StringsExplained#CharMatcher">
 * {@code CharMatcher}</a>.
 *
 * @author Kevin Bourrillion
 * @since 1.0
 */
public abstract class CharMatcher implements Predicate<Character> {

  // Constants
  /**
   * Determines whether a character is a breaking whitespace (that is, a whitespace which can be
   * interpreted as a break between words for formatting purposes). See {@link #WHITESPACE} for a
   * discussion of that term.
   *
   * @since 2.0
   */
  public static final CharMatcher BREAKING_WHITESPACE = new CharMatcher() {
    @Override
    public boolean matches(char c) {
      switch (c) {
        case '\t':
        case '\n':
        case '\013':
        case '\f':
        case '\r':
        case ' ':
        case '\u0085':
        case '\u1680':
        case '\u2028':
        case '\u2029':
        case '\u205f':
        case '\u3000':
          return true;
        case '\u2007':
          return false;
        default:
          return c >= '\u2000' && c <= '\u200a';
      }
    }

    @Override
    public String toString() {
      return "CharMatcher.BREAKING_WHITESPACE";
    }
  };

  /**
   * Determines whether a character is ASCII, meaning that its code point is less than 128.
   */
  public static final CharMatcher ASCII = new NamedFastMatcher("CharMatcher.ASCII") {
    @Override
    public boolean matches(char c) {
      return c <= '\u007f';
    }
  };

  /**
   * The Class RangesMatcher.
   */
  private static class RangesMatcher extends CharMatcher {
    
    /** The description. */
    private final String description;
    
    /** The range starts. */
    private final char[] rangeStarts;
    
    /** The range ends. */
    private final char[] rangeEnds;

    /**
     * Instantiates a new ranges matcher.
     *
     * @param description the description
     * @param rangeStarts the range starts
     * @param rangeEnds the range ends
     */
    RangesMatcher(String description, char[] rangeStarts, char[] rangeEnds) {
      this.description = description;
      this.rangeStarts = rangeStarts;
      this.rangeEnds = rangeEnds;
      checkArgument(rangeStarts.length == rangeEnds.length);
      for (int i = 0; i < rangeStarts.length; i++) {
        checkArgument(rangeStarts[i] <= rangeEnds[i]);
        if (i + 1 < rangeStarts.length) {
          checkArgument(rangeEnds[i] < rangeStarts[i + 1]);
        }
      }
    }

    /* (non-Javadoc)
     * @see com.abubusoft.kripton.common.CharMatcher#matches(char)
     */
    @Override
    public boolean matches(char c) {
      int index = Arrays.binarySearch(rangeStarts, c);
      if (index >= 0) {
        return true;
      } else {
        index = ~index - 1;
        return index >= 0 && c <= rangeEnds[index];
      }
    }

    /* (non-Javadoc)
     * @see com.abubusoft.kripton.common.CharMatcher#toString()
     */
    @Override
    public String toString() {
      return description;
    }
  }

  /** The Constant ZEROES. */
  // Must be in ascending order.
  private static final String ZEROES = "0\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6"
      + "\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0"
      + "\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10";

  /**
   * Determines whether a character is a digit according to
   * <a href="http://unicode.org/cldr/utility/list-unicodeset.jsp?a=%5Cp%7Bdigit%7D">Unicode</a>.
   * If you only care to match ASCII digits, you can use {@code inRange('0', '9')}.
   */
  public static final CharMatcher DIGIT;

  static {
    char[] zeroes = ZEROES.toCharArray();
    char[] nines = new char[zeroes.length];
    for (int i = 0; i < zeroes.length; i++) {
      nines[i] = (char) (zeroes[i] + 9);
    }
    DIGIT = new RangesMatcher("CharMatcher.DIGIT", zeroes, nines);
  }

  /**
   * Determines whether a character is a digit according to {@linkplain Character#isDigit(char)
   * Java's definition}. If you only care to match ASCII digits, you can use {@code
   * inRange('0', '9')}.
   */
  public static final CharMatcher JAVA_DIGIT = new CharMatcher() {
    @Override public boolean matches(char c) {
      return Character.isDigit(c);
    }

    @Override public String toString() {
      return "CharMatcher.JAVA_DIGIT";
    }
  };

  /**
   * Determines whether a character is a letter according to {@linkplain Character#isLetter(char)
   * Java's definition}. If you only care to match letters of the Latin alphabet, you can use {@code
   * inRange('a', 'z').or(inRange('A', 'Z'))}.
   */
  public static final CharMatcher JAVA_LETTER = new CharMatcher() {
    @Override public boolean matches(char c) {
      return Character.isLetter(c);
    }

    @Override public String toString() {
      return "CharMatcher.JAVA_LETTER";
    }
  };

  /**
   * Determines whether a character is a letter or digit according to {@linkplain
   * Character#isLetterOrDigit(char) Java's definition}.
   */
  public static final CharMatcher JAVA_LETTER_OR_DIGIT = new CharMatcher() {
    @Override public boolean matches(char c) {
      return Character.isLetterOrDigit(c);
    }

    @Override public String toString() {
      return "CharMatcher.JAVA_LETTER_OR_DIGIT";
    }
  };

  /**
   * Determines whether a character is upper case according to {@linkplain
   * Character#isUpperCase(char) Java's definition}.
   */
  public static final CharMatcher JAVA_UPPER_CASE = new CharMatcher() {
    @Override public boolean matches(char c) {
      return Character.isUpperCase(c);
    }

    @Override public String toString() {
      return "CharMatcher.JAVA_UPPER_CASE";
    }
  };

  /**
   * Determines whether a character is lower case according to {@linkplain
   * Character#isLowerCase(char) Java's definition}.
   */
  public static final CharMatcher JAVA_LOWER_CASE = new CharMatcher() {
    @Override public boolean matches(char c) {
      return Character.isLowerCase(c);
    }

    @Override public String toString() {
      return "CharMatcher.JAVA_LOWER_CASE";
    }
  };

  /**
   * Determines whether a character is an ISO control character as specified by {@link
   * Character#isISOControl(char)}.
   */
  public static final CharMatcher JAVA_ISO_CONTROL =
      new NamedFastMatcher("CharMatcher.JAVA_ISO_CONTROL") {
        @Override public boolean matches(char c) {
          return c <= '\u001f' || (c >= '\u007f' && c <= '\u009f');
        }
      };

  /**
   * Determines whether a character is invisible; that is, if its Unicode category is any of
   * SPACE_SEPARATOR, LINE_SEPARATOR, PARAGRAPH_SEPARATOR, CONTROL, FORMAT, SURROGATE, and
   * PRIVATE_USE according to ICU4J.
   */
  public static final CharMatcher INVISIBLE = new RangesMatcher("CharMatcher.INVISIBLE", (
      "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u1680\u180e\u2000\u2028\u205f\u2066\u2067\u2068"
      + "\u2069\u206a\u3000\ud800\ufeff\ufff9\ufffa").toCharArray(), (
      "\u0020\u00a0\u00ad\u0604\u061c\u06dd\u070f\u1680\u180e\u200f\u202f\u2064\u2066\u2067\u2068"
      + "\u2069\u206f\u3000\uf8ff\ufeff\ufff9\ufffb").toCharArray());

  /**
   * Show character.
   *
   * @param c the c
   * @return the string
   */
  private static String showCharacter(char c) {
    String hex = "0123456789ABCDEF";
    char[] tmp = {'\\', 'u', '\0', '\0', '\0', '\0'};
    for (int i = 0; i < 4; i++) {
      tmp[5 - i] = hex.charAt(c & 0xF);
      c = (char) (c >> 4);
    }
    return String.copyValueOf(tmp);
  }

  /**
   * Determines whether a character is single-width (not double-width). When in doubt, this matcher
   * errs on the side of returning {@code false} (that is, it tends to assume a character is
   * double-width).
   *
   * <p><b>Note:</b> as the reference file evolves, we will modify this constant to keep it up to
   * date.
   */
  public static final CharMatcher SINGLE_WIDTH = new RangesMatcher("CharMatcher.SINGLE_WIDTH",
      "\u0000\u05be\u05d0\u05f3\u0600\u0750\u0e00\u1e00\u2100\ufb50\ufe70\uff61".toCharArray(),
      "\u04f9\u05be\u05ea\u05f4\u06ff\u077f\u0e7f\u20af\u213a\ufdff\ufeff\uffdc".toCharArray());

  /** Matches any character. */
  public static final CharMatcher ANY = new NamedFastMatcher("CharMatcher.ANY") {
    @Override public boolean matches(char c) {
      return true;
    }

    @Override public int indexIn(CharSequence sequence) {
      return (sequence.length() == 0) ? -1 : 0;
    }

    @Override public int indexIn(CharSequence sequence, int start) {
      int length = sequence.length();
      Preconditions.checkPositionIndex(start, length);
      return (start == length) ? -1 : start;
    }

    @Override public int lastIndexIn(CharSequence sequence) {
      return sequence.length() - 1;
    }

    @Override public boolean matchesAllOf(CharSequence sequence) {
      checkNotNull(sequence);
      return true;
    }

    @Override public boolean matchesNoneOf(CharSequence sequence) {
      return sequence.length() == 0;
    }

    @Override public String removeFrom(CharSequence sequence) {
      checkNotNull(sequence);
      return "";
    }

    @Override public String replaceFrom(CharSequence sequence, char replacement) {
      char[] array = new char[sequence.length()];
      Arrays.fill(array, replacement);
      return new String(array);
    }

    @Override public String replaceFrom(CharSequence sequence, CharSequence replacement) {
      StringBuilder retval = new StringBuilder(sequence.length() * replacement.length());
      for (int i = 0; i < sequence.length(); i++) {
        retval.append(replacement);
      }
      return retval.toString();
    }

    @Override public String collapseFrom(CharSequence sequence, char replacement) {
      return (sequence.length() == 0) ? "" : String.valueOf(replacement);
    }

    @Override public String trimFrom(CharSequence sequence) {
      checkNotNull(sequence);
      return "";
    }

    @Override public int countIn(CharSequence sequence) {
      return sequence.length();
    }

    @Override public CharMatcher and(CharMatcher other) {
      return checkNotNull(other);
    }

    @Override public CharMatcher or(CharMatcher other) {
      checkNotNull(other);
      return this;
    }

    @Override public CharMatcher negate() {
      return NONE;
    }
  };

  /** Matches no characters. */
  public static final CharMatcher NONE = new NamedFastMatcher("CharMatcher.NONE") {
    @Override public boolean matches(char c) {
      return false;
    }

    @Override public int indexIn(CharSequence sequence) {
      checkNotNull(sequence);
      return -1;
    }

    @Override public int indexIn(CharSequence sequence, int start) {
      int length = sequence.length();
      Preconditions.checkPositionIndex(start, length);
      return -1;
    }

    @Override public int lastIndexIn(CharSequence sequence) {
      checkNotNull(sequence);
      return -1;
    }

    @Override public boolean matchesAllOf(CharSequence sequence) {
      return sequence.length() == 0;
    }

    @Override public boolean matchesNoneOf(CharSequence sequence) {
      checkNotNull(sequence);
      return true;
    }

    @Override public String removeFrom(CharSequence sequence) {
      return sequence.toString();
    }

    @Override public String replaceFrom(CharSequence sequence, char replacement) {
      return sequence.toString();
    }

    @Override public String replaceFrom(CharSequence sequence, CharSequence replacement) {
      checkNotNull(replacement);
      return sequence.toString();
    }

    @Override public String collapseFrom(CharSequence sequence, char replacement) {
      return sequence.toString();
    }

    @Override public String trimFrom(CharSequence sequence) {
      return sequence.toString();
    }

    @Override
    public String trimLeadingFrom(CharSequence sequence) {
      return sequence.toString();
    }

    @Override
    public String trimTrailingFrom(CharSequence sequence) {
      return sequence.toString();
    }

    @Override public int countIn(CharSequence sequence) {
      checkNotNull(sequence);
      return 0;
    }

    @Override public CharMatcher and(CharMatcher other) {
      checkNotNull(other);
      return this;
    }

    @Override public CharMatcher or(CharMatcher other) {
      return checkNotNull(other);
    }

    @Override public CharMatcher negate() {
      return ANY;
    }
  };

  // Static factories

  /**
   * Returns a {@code char} matcher that matches only one specified character.
   *
   * @param match the match
   * @return the char matcher
   */
  public static CharMatcher is(final char match) {
    return new FastMatcher() {
      @Override public boolean matches(char c) {
        return c == match;
      }

      @Override public String replaceFrom(CharSequence sequence, char replacement) {
        return sequence.toString().replace(match, replacement);
      }

      @Override public CharMatcher and(CharMatcher other) {
        return other.matches(match) ? this : NONE;
      }

      @Override public CharMatcher or(CharMatcher other) {
        return other.matches(match) ? other : super.or(other);
      }

      @Override public CharMatcher negate() {
        return isNot(match);
      }

      @Override
      void setBits(BitSet table) {
        table.set(match);
      }

      @Override public String toString() {
        return "CharMatcher.is('" + showCharacter(match) + "')";
      }
    };
  }

  /**
   * Returns a {@code char} matcher that matches any character except the one specified.
   * 
   * <p>To negate another {@code CharMatcher}, use {@link #negate()}.
   *
   * @param match the match
   * @return the char matcher
   */
  public static CharMatcher isNot(final char match) {
    return new FastMatcher() {
      @Override public boolean matches(char c) {
        return c != match;
      }

      @Override public CharMatcher and(CharMatcher other) {
        return other.matches(match) ? super.and(other) : other;
      }

      @Override public CharMatcher or(CharMatcher other) {
        return other.matches(match) ? ANY : this;
      }

      @Override
      void setBits(BitSet table) {
        table.set(0, match);
        table.set(match + 1, Character.MAX_VALUE + 1);
      }

      @Override public CharMatcher negate() {
        return is(match);
      }

      @Override public String toString() {
        return "CharMatcher.isNot('" + showCharacter(match) + "')";
      }
    };
  }

  /**
   * Returns a {@code char} matcher that matches any character present in the given character
   * sequence.
   *
   * @param sequence the sequence
   * @return the char matcher
   */
  public static CharMatcher anyOf(final CharSequence sequence) {
    switch (sequence.length()) {
      case 0:
        return NONE;
      case 1:
        return is(sequence.charAt(0));
      case 2:
        return isEither(sequence.charAt(0), sequence.charAt(1));
      default:
        // continue below to handle the general case
    }
    // TODO(user): is it potentially worth just going ahead and building a precomputed matcher?
    final char[] chars = sequence.toString().toCharArray();
    Arrays.sort(chars);
    return new CharMatcher() {
      @Override public boolean matches(char c) {
        return Arrays.binarySearch(chars, c) >= 0;
      }

      @Override
      void setBits(BitSet table) {
        for (char c : chars) {
          table.set(c);
        }
      }

      @Override public String toString() {
        StringBuilder description = new StringBuilder("CharMatcher.anyOf(\"");
        for (char c : chars) {
          description.append(showCharacter(c));
        }
        description.append("\")");
        return description.toString();
      }
    };
  }

  /**
   * Checks if is either.
   *
   * @param match1 the match 1
   * @param match2 the match 2
   * @return the char matcher
   */
  private static CharMatcher isEither(
      final char match1,
      final char match2) {
    return new FastMatcher() {
      @Override public boolean matches(char c) {
        return c == match1 || c == match2;
      }

      @Override void setBits(BitSet table) {
        table.set(match1);
        table.set(match2);
      }

      @Override public String toString() {
        return "CharMatcher.anyOf(\"" + showCharacter(match1) + showCharacter(match2) + "\")";
      }
    };
  }

  /**
   * Returns a {@code char} matcher that matches any character not present in the given character
   * sequence.
   *
   * @param sequence the sequence
   * @return the char matcher
   */
  public static CharMatcher noneOf(CharSequence sequence) {
    return anyOf(sequence).negate();
  }

  /**
   * Returns a {@code char} matcher that matches any character in a given range (both endpoints are
   * inclusive). For example, to match any lowercase letter of the English alphabet, use {@code
   * CharMatcher.inRange('a', 'z')}.
   *
   * @param startInclusive the start inclusive
   * @param endInclusive the end inclusive
   * @return the char matcher
   * @throws IllegalArgumentException if {@code endInclusive < startInclusive}
   */
  public static CharMatcher inRange(final char startInclusive, final char endInclusive) {
    checkArgument(endInclusive >= startInclusive);
    return new FastMatcher() {
      @Override public boolean matches(char c) {
        return startInclusive <= c && c <= endInclusive;
      }

      @Override void setBits(BitSet table) {
        table.set(startInclusive, endInclusive + 1);
      }

      @Override public String toString() {
        return "CharMatcher.inRange('" + showCharacter(startInclusive)
            + "', '" + showCharacter(endInclusive) + "')";
      }
    };
  }

  /**
   * Returns a matcher with identical behavior to the given {@link Character}-based predicate, but
   * which operates on primitive {@code char} instances instead.
   *
   * @param predicate the predicate
   * @return the char matcher
   */
  public static CharMatcher forPredicate(final Predicate<? super Character> predicate) {
    checkNotNull(predicate);
    if (predicate instanceof CharMatcher) {
      return (CharMatcher) predicate;
    }
    return new CharMatcher() {
      @Override public boolean matches(char c) {
        return predicate.apply(c);
      }

      @Override public boolean apply(Character character) {
        return predicate.apply(checkNotNull(character));
      }

      @Override public String toString() {
        return "CharMatcher.forPredicate(" + predicate + ")";
      }
    };
  }

  // Constructors
  /**
   * Constructor for use by subclasses. When subclassing, you may want to override
   * {@code toString()} to provide a useful description.
   */
  protected CharMatcher() {}

  // Abstract methods

  /**
   *  Determines a true or false value for the given character.
   *
   * @param c the c
   * @return true, if successful
   */
  public abstract boolean matches(char c);

  // Non-static factories

  /**
   * Returns a matcher that matches any character not matched by this matcher.
   *
   * @return the char matcher
   */
  public CharMatcher negate() {
    return new NegatedMatcher(this);
  }

  /**
   * The Class NegatedMatcher.
   */
  private static class NegatedMatcher extends CharMatcher {
    
    /** The original. */
    final CharMatcher original;

    /**
     * Instantiates a new negated matcher.
     *
     * @param original the original
     */
    NegatedMatcher(CharMatcher original) {
      this.original = checkNotNull(original);
    }

    /* (non-Javadoc)
     * @see com.abubusoft.kripton.common.CharMatcher#matches(char)
     */
    @Override public boolean matches(char c) {
      return !original.matches(c);
    }

    /* (non-Javadoc)
     * @see com.abubusoft.kripton.common.CharMatcher#matchesAllOf(java.lang.CharSequence)
     */
    @Override public boolean matchesAllOf(CharSequence sequence) {
      return original.matchesNoneOf(sequence);
    }

    /* (non-Javadoc)
     * @see com.abubusoft.kripton.common.CharMatcher#matchesNoneOf(java.lang.CharSequence)
     */
    @Override public boolean matchesNoneOf(CharSequence sequence) {
      return original.matchesAllOf(sequence);
    }

    /* (non-Javadoc)
     * @see com.abubusoft.kripton.common.CharMatcher#countIn(java.lang.CharSequence)
     */
    @Override public int countIn(CharSequence sequence) {
      return sequence.length() - original.countIn(sequence);
    }

    /* (non-Javadoc)
     * @see com.abubusoft.kripton.common.CharMatcher#setBits(java.util.BitSet)
     */
    @Override
    void setBits(BitSet table) {
      BitSet tmp = new BitSet();
      original.setBits(tmp);
      tmp.flip(Character.MIN_VALUE, Character.MAX_VALUE + 1);
      table.or(tmp);
    }

    /* (non-Javadoc)
     * @see com.abubusoft.kripton.common.CharMatcher#negate()
     */
    @Override public CharMatcher negate() {
      return original;
    }

    /* (non-Javadoc)
     * @see com.abubusoft.kripton.common.CharMatcher#toString()
     */
    @Override public String toString() {
      return original + ".negate()";
    }
  }

  /**
   * Returns a matcher that matches any character matched by both this matcher and {@code other}.
   *
   * @param other the other
   * @return the char matcher
   */
  public CharMatcher and(CharMatcher other) {
    return new And(this, other);
  }

  /**
   * The Class And.
   */
  private static class And extends CharMatcher {
    
    /** The first. */
    final CharMatcher first;
    
    /** The second. */
    final CharMatcher second;

    /**
     * Instantiates a new and.
     *
     * @param a the a
     * @param b the b
     */
    And(CharMatcher a, CharMatcher b) {
      first = checkNotNull(a);
      second = checkNotNull(b);
    }

    /* (non-Javadoc)
     * @see com.abubusoft.kripton.common.CharMatcher#matches(char)
     */
    @Override
    public boolean matches(char c) {
      return first.matches(c) && second.matches(c);
    }

    /* (non-Javadoc)
     * @see com.abubusoft.kripton.common.CharMatcher#setBits(java.util.BitSet)
     */
    @Override
    void setBits(BitSet table) {
      BitSet tmp1 = new BitSet();
      first.setBits(tmp1);
      BitSet tmp2 = new BitSet();
      second.setBits(tmp2);
      tmp1.and(tmp2);
      table.or(tmp1);
    }

    /* (non-Javadoc)
     * @see com.abubusoft.kripton.common.CharMatcher#toString()
     */
    @Override public String toString() {
      return "CharMatcher.and(" + first + ", " + second + ")";
    }
  }

  /**
   * Returns a matcher that matches any character matched by either this matcher or {@code other}.
   *
   * @param other the other
   * @return the char matcher
   */
  public CharMatcher or(CharMatcher other) {
    return new Or(this, other);
  }

  /**
   * The Class Or.
   */
  private static class Or extends CharMatcher {
    
    /** The first. */
    final CharMatcher first;
    
    /** The second. */
    final CharMatcher second;

    /**
     * Instantiates a new or.
     *
     * @param a the a
     * @param b the b
     */
    Or(CharMatcher a, CharMatcher b) {
      first = checkNotNull(a);
      second = checkNotNull(b);
    }

    /* (non-Javadoc)
     * @see com.abubusoft.kripton.common.CharMatcher#setBits(java.util.BitSet)
     */
    @Override
    void setBits(BitSet table) {
      first.setBits(table);
      second.setBits(table);
    }

    /* (non-Javadoc)
     * @see com.abubusoft.kripton.common.CharMatcher#matches(char)
     */
    @Override
    public boolean matches(char c) {
      return first.matches(c) || second.matches(c);
    }

    /* (non-Javadoc)
     * @see com.abubusoft.kripton.common.CharMatcher#toString()
     */
    @Override public String toString() {
      return "CharMatcher.or(" + first + ", " + second + ")";
    }
  }

  /**
   * Returns a {@code char} matcher functionally equivalent to this one, but which may be faster to
   * query than the original; your mileage may vary. Precomputation takes time and is likely to be
   * worthwhile only if the precomputed matcher is queried many thousands of times.
   * 
   * <p>This method has no effect (returns {@code this}) when called in GWT: it's unclear whether a
   * precomputed matcher is faster, but it certainly consumes more memory, which doesn't seem like a
   * worthwhile tradeoff in a browser.
   *
   * @return the char matcher
   */
  public CharMatcher precomputed() {
    return precomputedInternal();
  }

  /** The Constant DISTINCT_CHARS. */
  private static final int DISTINCT_CHARS = Character.MAX_VALUE - Character.MIN_VALUE + 1;

  /**
   * This is the actual implementation of {@link #precomputed}, but we bounce calls through a
   * method on {@link Platform} so that we can have different behavior in GWT.
   * 
   * <p>This implementation tries to be smart in a number of ways.  It recognizes cases where
   * the negation is cheaper to precompute than the matcher itself; it tries to build small
   * hash tables for matchers that only match a few characters, and so on.  In the worst-case
   * scenario, it constructs an eight-kilobyte bit array and queries that.
   * In many situations this produces a matcher which is faster to query than the original.
   *
   * @return the char matcher
   */
  CharMatcher precomputedInternal() {
    final BitSet table = new BitSet();
    setBits(table);
    int totalCharacters = table.cardinality();
    if (totalCharacters * 2 <= DISTINCT_CHARS) {
      return precomputedPositive(totalCharacters, table, toString());
    } else {
      // TODO(user): is it worth it to worry about the last character of large matchers?
      table.flip(Character.MIN_VALUE, Character.MAX_VALUE + 1);
      int negatedCharacters = DISTINCT_CHARS - totalCharacters;
      String suffix = ".negate()";
      final String description = toString();
      String negatedDescription = description.endsWith(suffix)
          ? description.substring(0, description.length() - suffix.length())
          : description + suffix;
      return new NegatedFastMatcher(
          precomputedPositive(negatedCharacters, table, negatedDescription)) {
        @Override
        public String toString() {
          return description;
        }
      };
    }
  }

  /**
   * A matcher for which precomputation will not yield any significant benefit.
   */
  abstract static class FastMatcher extends CharMatcher {
    
    /* (non-Javadoc)
     * @see com.abubusoft.kripton.common.CharMatcher#precomputed()
     */
    @Override
    public final CharMatcher precomputed() {
      return this;
    }

    /* (non-Javadoc)
     * @see com.abubusoft.kripton.common.CharMatcher#negate()
     */
    @Override
    public CharMatcher negate() {
      return new NegatedFastMatcher(this);
    }
  }

  /**
   * The Class NamedFastMatcher.
   */
  abstract static class NamedFastMatcher extends FastMatcher {
    
    /** The description. */
    private final String description;

    /**
     * Instantiates a new named fast matcher.
     *
     * @param description the description
     */
    NamedFastMatcher(String description) {
      this.description = checkNotNull(description);
    }

    /* (non-Javadoc)
     * @see com.abubusoft.kripton.common.CharMatcher#toString()
     */
    @Override public final String toString() {
      return description;
    }
  }

  /**
   * The Class NegatedFastMatcher.
   */
  static class NegatedFastMatcher extends NegatedMatcher {
    
    /**
     * Instantiates a new negated fast matcher.
     *
     * @param original the original
     */
    NegatedFastMatcher(CharMatcher original) {
      super(original);
    }

    /* (non-Javadoc)
     * @see com.abubusoft.kripton.common.CharMatcher#precomputed()
     */
    @Override
    public final CharMatcher precomputed() {
      return this;
    }
  }

  /**
   * Helper method for {@link #precomputedInternal} that doesn't test if the negation is cheaper.
   *
   * @param totalCharacters the total characters
   * @param table the table
   * @param description the description
   * @return the char matcher
   */
  private static CharMatcher precomputedPositive(
      int totalCharacters,
      BitSet table,
      String description) {
    switch (totalCharacters) {
      case 0:
        return NONE;
      case 1:
        return is((char) table.nextSetBit(0));
      case 2:
        char c1 = (char) table.nextSetBit(0);
        char c2 = (char) table.nextSetBit(c1 + 1);
        return isEither(c1, c2);
      default:
        return isSmall(totalCharacters, table.length())
            ? SmallCharMatcher.from(table, description)
            : new BitSetMatcher(table, description);
    }
  }

  /**
   * Checks if is small.
   *
   * @param totalCharacters the total characters
   * @param tableLength the table length
   * @return true, if is small
   */
  private static boolean isSmall(int totalCharacters, int tableLength) {
    return totalCharacters <= SmallCharMatcher.MAX_SIZE
        && tableLength > (totalCharacters * 4 * Character.SIZE);
        // err on the side of BitSetMatcher
  }

  /**
   * The Class BitSetMatcher.
   */
  private static class BitSetMatcher extends NamedFastMatcher {
    
    /** The table. */
    private final BitSet table;

    /**
     * Instantiates a new bit set matcher.
     *
     * @param table the table
     * @param description the description
     */
    private BitSetMatcher(BitSet table, String description) {
      super(description);
      if (table.length() + Long.SIZE < table.size()) {
        table = (BitSet) table.clone();
        // If only we could actually call BitSet.trimToSize() ourselves...
      }
      this.table = table;
    }

    /* (non-Javadoc)
     * @see com.abubusoft.kripton.common.CharMatcher#matches(char)
     */
    @Override public boolean matches(char c) {
      return table.get(c);
    }

    /* (non-Javadoc)
     * @see com.abubusoft.kripton.common.CharMatcher#setBits(java.util.BitSet)
     */
    @Override
    void setBits(BitSet bitSet) {
      bitSet.or(table);
    }
  }

  /**
   * Sets bits in {@code table} matched by this matcher.
   *
   * @param table the new bits
   */
  void setBits(BitSet table) {
    for (int c = Character.MAX_VALUE; c >= Character.MIN_VALUE; c--) {
      if (matches((char) c)) {
        table.set(c);
      }
    }
  }

  // Text processing routines

  /**
   * Returns {@code true} if a character sequence contains at least one matching character.
   * Equivalent to {@code !matchesNoneOf(sequence)}.
   *
   * <p>The default implementation iterates over the sequence, invoking {@link #matches} for each
   * character, until this returns {@code true} or the end is reached.
   *
   * @param sequence the character sequence to examine, possibly empty
   * @return {@code true} if this matcher matches at least one character in the sequence
   * @since 8.0
   */
  public boolean matchesAnyOf(CharSequence sequence) {
    return !matchesNoneOf(sequence);
  }

  /**
   * Returns {@code true} if a character sequence contains only matching characters.
   *
   * <p>The default implementation iterates over the sequence, invoking {@link #matches} for each
   * character, until this returns {@code false} or the end is reached.
   *
   * @param sequence the character sequence to examine, possibly empty
   * @return {@code true} if this matcher matches every character in the sequence, including when
   *         the sequence is empty
   */
  public boolean matchesAllOf(CharSequence sequence) {
    for (int i = sequence.length() - 1; i >= 0; i--) {
      if (!matches(sequence.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  /**
   * Returns {@code true} if a character sequence contains no matching characters. Equivalent to
   * {@code !matchesAnyOf(sequence)}.
   *
   * <p>The default implementation iterates over the sequence, invoking {@link #matches} for each
   * character, until this returns {@code false} or the end is reached.
   *
   * @param sequence the character sequence to examine, possibly empty
   * @return {@code true} if this matcher matches every character in the sequence, including when
   *         the sequence is empty
   */
  public boolean matchesNoneOf(CharSequence sequence) {
    return indexIn(sequence) == -1;
  }

  /**
   * Returns the index of the first matching character in a character sequence, or {@code -1} if no
   * matching character is present.
   *
   * <p>The default implementation iterates over the sequence in forward order calling {@link
   * #matches} for each character.
   *
   * @param sequence the character sequence to examine from the beginning
   * @return an index, or {@code -1} if no character matches
   */
  public int indexIn(CharSequence sequence) {
    int length = sequence.length();
    for (int i = 0; i < length; i++) {
      if (matches(sequence.charAt(i))) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Returns the index of the first matching character in a character sequence, starting from a
   * given position, or {@code -1} if no character matches after that position.
   *
   * <p>The default implementation iterates over the sequence in forward order, beginning at {@code
   * start}, calling {@link #matches} for each character.
   *
   * @param sequence the character sequence to examine
   * @param start the first index to examine; must be nonnegative and no greater than {@code
   *        sequence.length()}
   * @return the index of the first matching character, guaranteed to be no less than {@code start},
   *         or {@code -1} if no character matches
   * @throws IndexOutOfBoundsException if start is negative or greater than {@code
   *         sequence.length()}
   */
  public int indexIn(CharSequence sequence, int start) {
    int length = sequence.length();
    Preconditions.checkPositionIndex(start, length);
    for (int i = start; i < length; i++) {
      if (matches(sequence.charAt(i))) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Returns the index of the last matching character in a character sequence, or {@code -1} if no
   * matching character is present.
   *
   * <p>The default implementation iterates over the sequence in reverse order calling {@link
   * #matches} for each character.
   *
   * @param sequence the character sequence to examine from the end
   * @return an index, or {@code -1} if no character matches
   */
  public int lastIndexIn(CharSequence sequence) {
    for (int i = sequence.length() - 1; i >= 0; i--) {
      if (matches(sequence.charAt(i))) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Returns the number of matching characters found in a character sequence.
   *
   * @param sequence the sequence
   * @return the int
   */
  public int countIn(CharSequence sequence) {
    int count = 0;
    for (int i = 0; i < sequence.length(); i++) {
      if (matches(sequence.charAt(i))) {
        count++;
      }
    }
    return count;
  }

  /**
   * Returns a string containing all non-matching characters of a character sequence, in order. For
   * example: <pre>   {@code
   * 
   *   CharMatcher.is('a').removeFrom("bazaar")}</pre>
   * 
   * ... returns {@code "bzr"}.
   *
   * @param sequence the sequence
   * @return the string
   */
  public String removeFrom(CharSequence sequence) {
    String string = sequence.toString();
    int pos = indexIn(string);
    if (pos == -1) {
      return string;
    }

    char[] chars = string.toCharArray();
    int spread = 1;

    // This unusual loop comes from extensive benchmarking
    OUT: while (true) {
      pos++;
      while (true) {
        if (pos == chars.length) {
          break OUT;
        }
        if (matches(chars[pos])) {
          break;
        }
        chars[pos - spread] = chars[pos];
        pos++;
      }
      spread++;
    }
    return new String(chars, 0, pos - spread);
  }

  /**
   * Returns a string containing all matching characters of a character sequence, in order. For
   * example: <pre>   {@code
   * 
   *   CharMatcher.is('a').retainFrom("bazaar")}</pre>
   * 
   * ... returns {@code "aaa"}.
   *
   * @param sequence the sequence
   * @return the string
   */
  public String retainFrom(CharSequence sequence) {
    return negate().removeFrom(sequence);
  }

  /**
   * Returns a string copy of the input character sequence, with each character that matches this
   * matcher replaced by a given replacement character. For example: <pre>   {@code
   *
   *   CharMatcher.is('a').replaceFrom("radar", 'o')}</pre>
   *
   * ... returns {@code "rodor"}.
   *
   * <p>The default implementation uses {@link #indexIn(CharSequence)} to find the first matching
   * character, then iterates the remainder of the sequence calling {@link #matches(char)} for each
   * character.
   *
   * @param sequence the character sequence to replace matching characters in
   * @param replacement the character to append to the result string in place of each matching
   *        character in {@code sequence}
   * @return the new string
   */
  public String replaceFrom(CharSequence sequence, char replacement) {
    String string = sequence.toString();
    int pos = indexIn(string);
    if (pos == -1) {
      return string;
    }
    char[] chars = string.toCharArray();
    chars[pos] = replacement;
    for (int i = pos + 1; i < chars.length; i++) {
      if (matches(chars[i])) {
        chars[i] = replacement;
      }
    }
    return new String(chars);
  }

  /**
   * Returns a string copy of the input character sequence, with each character that matches this
   * matcher replaced by a given replacement sequence. For example: <pre>   {@code
   *
   *   CharMatcher.is('a').replaceFrom("yaha", "oo")}</pre>
   *
   * ... returns {@code "yoohoo"}.
   *
   * <p><b>Note:</b> If the replacement is a fixed string with only one character, you are better
   * off calling {@link #replaceFrom(CharSequence, char)} directly.
   *
   * @param sequence the character sequence to replace matching characters in
   * @param replacement the characters to append to the result string in place of each matching
   *        character in {@code sequence}
   * @return the new string
   */
  public String replaceFrom(CharSequence sequence, CharSequence replacement) {
    int replacementLen = replacement.length();
    if (replacementLen == 0) {
      return removeFrom(sequence);
    }
    if (replacementLen == 1) {
      return replaceFrom(sequence, replacement.charAt(0));
    }

    String string = sequence.toString();
    int pos = indexIn(string);
    if (pos == -1) {
      return string;
    }

    int len = string.length();
    StringBuilder buf = new StringBuilder((len * 3 / 2) + 16);

    int oldpos = 0;
    do {
      buf.append(string, oldpos, pos);
      buf.append(replacement);
      oldpos = pos + 1;
      pos = indexIn(string, oldpos);
    } while (pos != -1);

    buf.append(string, oldpos, len);
    return buf.toString();
  }

  /**
   * Returns a substring of the input character sequence that omits all characters this matcher
   * matches from the beginning and from the end of the string. For example: <pre>   {@code
   * 
   *   CharMatcher.anyOf("ab").trimFrom("abacatbab")}</pre>
   * 
   * ... returns {@code "cat"}.
   * 
   * <p>Note that: <pre>   {@code
   * 
   *   CharMatcher.inRange('\0', ' ').trimFrom(str)}</pre>
   * 
   * ... is equivalent to {@link String#trim()}.
   *
   * @param sequence the sequence
   * @return the string
   */
  public String trimFrom(CharSequence sequence) {
    int len = sequence.length();
    int first;
    int last;

    for (first = 0; first < len; first++) {
      if (!matches(sequence.charAt(first))) {
        break;
      }
    }
    for (last = len - 1; last > first; last--) {
      if (!matches(sequence.charAt(last))) {
        break;
      }
    }

    return sequence.subSequence(first, last + 1).toString();
  }

  /**
   * Returns a substring of the input character sequence that omits all characters this matcher
   * matches from the beginning of the string. For example: <pre> {@code
   * 
   *   CharMatcher.anyOf("ab").trimLeadingFrom("abacatbab")}</pre>
   * 
   * ... returns {@code "catbab"}.
   *
   * @param sequence the sequence
   * @return the string
   */
  public String trimLeadingFrom(CharSequence sequence) {
    int len = sequence.length();
    for (int first = 0; first < len; first++) {
      if (!matches(sequence.charAt(first))) {
        return sequence.subSequence(first, len).toString();
      }
    }
    return "";
  }

  /**
   * Returns a substring of the input character sequence that omits all characters this matcher
   * matches from the end of the string. For example: <pre> {@code
   * 
   *   CharMatcher.anyOf("ab").trimTrailingFrom("abacatbab")}</pre>
   * 
   * ... returns {@code "abacat"}.
   *
   * @param sequence the sequence
   * @return the string
   */
  public String trimTrailingFrom(CharSequence sequence) {
    int len = sequence.length();
    for (int last = len - 1; last >= 0; last--) {
      if (!matches(sequence.charAt(last))) {
        return sequence.subSequence(0, last + 1).toString();
      }
    }
    return "";
  }

  /**
   * Returns a string copy of the input character sequence, with each group of consecutive
   * characters that match this matcher replaced by a single replacement character. For example:
   * <pre>   {@code
   *
   *   CharMatcher.anyOf("eko").collapseFrom("bookkeeper", '-')}</pre>
   *
   * ... returns {@code "b-p-r"}.
   *
   * <p>The default implementation uses {@link #indexIn(CharSequence)} to find the first matching
   * character, then iterates the remainder of the sequence calling {@link #matches(char)} for each
   * character.
   *
   * @param sequence the character sequence to replace matching groups of characters in
   * @param replacement the character to append to the result string in place of each group of
   *        matching characters in {@code sequence}
   * @return the new string
   */
  public String collapseFrom(CharSequence sequence, char replacement) {
    // This implementation avoids unnecessary allocation.
    int len = sequence.length();
    for (int i = 0; i < len; i++) {
      char c = sequence.charAt(i);
      if (matches(c)) {
        if (c == replacement
            && (i == len - 1 || !matches(sequence.charAt(i + 1)))) {
          // a no-op replacement
          i++;
        } else {
          StringBuilder builder = new StringBuilder(len)
              .append(sequence.subSequence(0, i))
              .append(replacement);
          return finishCollapseFrom(sequence, i + 1, len, replacement, builder, true);
        }
      }
    }
    // no replacement needed
    return sequence.toString();
  }

  /**
   * Collapses groups of matching characters exactly as {@link #collapseFrom} does, except that
   * groups of matching characters at the start or end of the sequence are removed without
   * replacement.
   *
   * @param sequence the sequence
   * @param replacement the replacement
   * @return the string
   */
  public String trimAndCollapseFrom(CharSequence sequence, char replacement) {
    // This implementation avoids unnecessary allocation.
    int len = sequence.length();
    int first;
    int last;

    for (first = 0; first < len && matches(sequence.charAt(first)); first++) {}
    for (last = len - 1; last > first && matches(sequence.charAt(last)); last--) {}

    return (first == 0 && last == len - 1)
        ? collapseFrom(sequence, replacement)
        : finishCollapseFrom(
              sequence, first, last + 1, replacement,
              new StringBuilder(last + 1 - first),
              false);
  }

  /**
   * Finish collapse from.
   *
   * @param sequence the sequence
   * @param start the start
   * @param end the end
   * @param replacement the replacement
   * @param builder the builder
   * @param inMatchingGroup the in matching group
   * @return the string
   */
  private String finishCollapseFrom(
      CharSequence sequence, int start, int end, char replacement,
      StringBuilder builder, boolean inMatchingGroup) {
    for (int i = start; i < end; i++) {
      char c = sequence.charAt(i);
      if (matches(c)) {
        if (!inMatchingGroup) {
          builder.append(replacement);
          inMatchingGroup = true;
        }
      } else {
        builder.append(c);
        inMatchingGroup = false;
      }
    }
    return builder.toString();
  }

  /**
   * Apply.
   *
   * @param character the character
   * @return true, if successful
   * @deprecated Provided only to satisfy the {@link Predicate} interface; use {@link #matches}
   *     instead.
   */
  @Deprecated
  @Override
  public boolean apply(Character character) {
    return matches(character);
  }

  /**
   * Returns a string representation of this {@code CharMatcher}, such as
   * {@code CharMatcher.or(WHITESPACE, JAVA_DIGIT)}.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return super.toString();
  }

  /** The Constant WHITESPACE_TABLE. */
  static final String WHITESPACE_TABLE = ""
      + "\u2002\u3000\r\u0085\u200A\u2005\u2000\u3000"
      + "\u2029\u000B\u3000\u2008\u2003\u205F\u3000\u1680"
      + "\u0009\u0020\u2006\u2001\u202F\u00A0\u000C\u2009"
      + "\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000";
  
  /** The Constant WHITESPACE_MULTIPLIER. */
  static final int WHITESPACE_MULTIPLIER = 1682554634;
  
  /** The Constant WHITESPACE_SHIFT. */
  static final int WHITESPACE_SHIFT = Integer.numberOfLeadingZeros(WHITESPACE_TABLE.length() - 1);

  /**
   * Determines whether a character is whitespace according to the latest Unicode standard, as
   * illustrated
   * <a href="http://unicode.org/cldr/utility/list-unicodeset.jsp?a=%5Cp%7Bwhitespace%7D">here</a>.
   * This is not the same definition used by other Java APIs. (See a
   * <a href="http://spreadsheets.google.com/pub?key=pd8dAQyHbdewRsnE5x5GzKQ">comparison of several
   * definitions of "whitespace"</a>.)
   *
   * <p><b>Note:</b> as the Unicode definition evolves, we will modify this constant to keep it up
   * to date.
   */
  public static final CharMatcher WHITESPACE = new NamedFastMatcher("WHITESPACE") {
    @Override
    public boolean matches(char c) {
      return WHITESPACE_TABLE.charAt((WHITESPACE_MULTIPLIER * c) >>> WHITESPACE_SHIFT) == c;
    }

    @Override
    void setBits(BitSet table) {
      for (int i = 0; i < WHITESPACE_TABLE.length(); i++) {
        table.set(WHITESPACE_TABLE.charAt(i));
      }
    }
  };
}