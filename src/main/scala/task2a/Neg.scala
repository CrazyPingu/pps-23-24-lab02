package task2a

// Task 2a
def neg(predicate: String => Boolean): String => Boolean =
  (input: String) => !predicate(input)

def genericNeg[X](predicate: X => Boolean): X => Boolean =
  (input: X) => !predicate(input)


// Task 2b
def curriedNeg(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z
def nonCurriedNeg(x: Int, y: Int, z: Int): Boolean = x <= y && y == z
