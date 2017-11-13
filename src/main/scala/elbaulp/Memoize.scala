package elbaulp

import scala.collection._


// Challenges of Bartosz Milewsky Types & Functions

/**
  * Define a higher-order function (or a function object) memoize in
  * your favorite language. This function takes a pure function f as an
  * argument and returns a function that behaves almost exactly like f,
  * except that it only calls the original function once for every
  * argument, stores the result internally, and subsequently returns
  * this stored result every time it’s called with the same argument.
  * You can tell the memoized function from the original by watching
  * its performance. For instance, try to memoize a function that takes
  * a long time to evaluate. You’ll have to wait for the result the
  * first time you call it, but on subsequent calls, with the same
  * argument, you should get the result immediately.
  **/

// Example of use:
// def f(a:Int) = {
//   Thread.sleep(5000)
//   a*a
// }
// val b = Memoize(f)
// b(10) // Takes 5 secs
// b(10) // immediate
case class Memoize[A, B](f: A => B) {
  private[this] val values: mutable.Map[A,B] = mutable.Map.empty
  def apply(x: A) = values getOrElseUpdate(x, f(x))
}

// Challenge 2.5: How many different functions are there from Bool to Bool? Can you implement them all?
// As Bool can only take 2 values, From bool -> Bool you can only get 4 different funtions (2^2)
// Callenge 2.6
