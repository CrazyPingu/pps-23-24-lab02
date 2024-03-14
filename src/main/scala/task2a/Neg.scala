package task2a

def neg(predicate: String => Boolean): String => Boolean =
  (input: String) => !predicate(input)


