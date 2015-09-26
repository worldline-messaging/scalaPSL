package com.kodekutters.psl

import java.net.IDN

/**
 * a basic check of a domain name input
 * ref: https://github.com/wrangr/psl
 */
object BasicChecker {

  // error messages
  val DOMAIN_TOO_SHORT = "Domain name too short."
  val DOMAIN_TOO_LONG = "Domain name too long. It should be no more than 255 chars."
  val LABEL_STARTS_WITH_DASH = "Domain name label can not start with a dash."
  val LABEL_ENDS_WITH_DASH = "Domain name label can not end with a dash."
  val LABEL_TOO_LONG = "Domain name label should be at most 63 chars long."
  val LABEL_TOO_SHORT = "Domain name label should be at least 1 characters long."
  val LABEL_INVALID_CHARS = "Domain name label can only contain alphanumeric characters or dashes."

  /**
   * Note: checks is based on the lowercase of the input
   */
  def isValid(input: String): Boolean = {
    if (input == null) false
    else {
      var check = false
      val ascii = IDN.toASCII(input)
      ascii match {
        case str if str.length < 1 => println(DOMAIN_TOO_SHORT + " input: " + input)
        case str if str.length > 255 => println(DOMAIN_TOO_LONG + " input: " + input)
        case _ => check = true
      }
      for (label <- Util.splitLabels(ascii)) {
        label match {
          case lbl if lbl.length < 1 => println(LABEL_TOO_SHORT + " input: " + input)
          case lbl if lbl.length > 63 => println(LABEL_TOO_LONG + " input: " + input)
          case lbl if lbl.charAt(0) == '-' => println(LABEL_STARTS_WITH_DASH + " input: " + input)
          case lbl if lbl.charAt(lbl.length - 1) == '-' => println(LABEL_ENDS_WITH_DASH + " input: " + input)
          case lbl if ! """^[a-z0-9\-]+$""".r.pattern.matcher(lbl.toLowerCase).matches => println(LABEL_INVALID_CHARS + " input: " + input)
          case _ => check = check && true
        }
      }
      check
    }
  }

}
