package task2a

// Task 2a
def neg(predicate: String => Boolean): String => Boolean =
  (input: String) => !predicate(input)

def genericNeg[X](predicate: X => Boolean): X => Boolean =
  (input: X) => !predicate(input)


// Task 2b
val curriedValNeg: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
def curriedDefNeg(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z
val nonCurriedValNeg: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y == z
def nonCurriedDefNeg(x: Int, y: Int, z: Int): Boolean = x <= y && y == z