package task2a

def neg(predicate: String => Boolean): String => Boolean =
  (input: String) => !predicate(input)

def genericNeg[X](predicate: X => Boolean): X => Boolean = 
  (input: X) => !predicate(input)

