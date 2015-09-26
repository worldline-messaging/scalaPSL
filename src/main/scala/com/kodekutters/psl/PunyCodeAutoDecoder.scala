package com.kodekutters.psl

import java.net.IDN

/**
 * Automatic Punycode Codec.
 *
 * This codec remembers at {@link PunycodeAutoDecoder#decode(String)} whether the input was encoded or not.
 * The {@link PunycodeAutoDecoder#recode(String)} method will return the same format as the original input.
 *
 */
final class PunycodeAutoDecoder() {
  /**
   * the state of {@code PunycodeAutoDecoder#decode(String)}.
   */
  private var decoded = false

  /**
   * Decodes a domain name into UTF-8 if it is in Punycode ASCII.
   *
   * If the domain name is already UTF-8 no change occurs.
   * The original format (Punycode or UTF-8) is saved in {@link #decoded}.
   * {@link #recode(String)} can return the string in the saved format.
   *
   * @param domain the domain name
   * @return the UTF-8 domain name
   */
  def decode(domain: String): String = {
    val asciiDomain = IDN.toUnicode(domain)
    decoded = !(asciiDomain == domain)
    asciiDomain
  }

  /**
   * Returns the UTF-8 domain name in the original format.
   *
   * The original format is Punycode ASCII or UTF-8. The format is determined in {@link #decode(String)}.
   *
   * @param domain the UTF-8 domain name
   * @return the domain name in the original format
   */
  def recode(domain: String): String = if (decoded) IDN.toASCII(domain) else domain

  /**
   * determines if the original format was Punnycode ASCII.
   * The original format is set in {@link #decode(String)}.
   *
   * @return { @code true} if the original format was Punnycode ASCII
   */
  def isConverted: Boolean = decoded

}