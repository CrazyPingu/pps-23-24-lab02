package task2a

object Sign extends Enumeration {
  val POSITIVE = "positive"
  val NEGATIVE = "negative"
}

def positive(x: Int): String = x match {
  case x if x >= 0 => Sign.POSITIVE
  case _ => Sign.NEGATIVE
}