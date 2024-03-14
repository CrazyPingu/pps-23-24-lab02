package task2a

// Task 2a
def neg(predicate: String => Boolean): String => Boolean =
  (input: String) => !predicate(input)

def genericNeg[X](predicate: X => Boolean): X => Boolean =
  (input: X) => !predicate(input)


// Task 2b
val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
val p2: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y == z
def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z
def p4(x: Int, y: Int, z: Int): Boolean = x <= y && y == z


